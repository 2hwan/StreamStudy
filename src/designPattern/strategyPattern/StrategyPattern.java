package designPattern.strategyPattern;

import designPattern.builderPattern.BuilderPatternFunc;

import java.util.Arrays;
import java.util.List;

public class StrategyPattern {
    public static void main(String[] args) {
        BuilderPatternFunc user1 = BuilderPatternFunc.builder(1,"Alice")
                .with(builder -> {// consumer 로 손쉽게 객체 생성패턴을 가져감
                    builder.emailAddress = "alice@kt.com";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                })
                .build();
        BuilderPatternFunc user2 = BuilderPatternFunc.builder(2,"Bob")
                .with(builder -> {// consumer 로 손쉽게 객체 생성패턴을 가져감
                    builder.emailAddress = "bob@kt.com";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203);
                })
                .build();
        BuilderPatternFunc user3 = BuilderPatternFunc.builder(3,"Charlie")
                .with(builder -> {// consumer 로 손쉽게 객체 생성패턴을 가져감
                    builder.emailAddress = "charlie@kt.com";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213);
                })
                .build();

        List<BuilderPatternFunc> users = Arrays.asList(user1, user2, user3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakerMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider); //전략1
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendsEmailProvider); //전략2
        users.stream()
                .filter(BuilderPatternFunc::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "'Play With Friends' email for " + user.getName()); // 매번 class 생성안하고 바로 lambda로 전략 생성하기
        users.stream()
                .filter(BuilderPatternFunc::isVerified)
                .filter(user -> user.getFriendUserIds().size() > 5)
                .forEach(emailSender::sendEmail);
    }
}

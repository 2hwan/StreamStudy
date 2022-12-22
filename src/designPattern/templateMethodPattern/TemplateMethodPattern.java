package designPattern.templateMethodPattern;

import designPattern.builderPattern.BuilderPatternFunc;

import java.sql.SQLOutput;
import java.util.Arrays;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        BuilderPatternFunc alice = BuilderPatternFunc.builder(1,"Alice")
                .with(builder -> {// consumer 로 손쉽게 객체 생성패턴을 가져감
                    builder.emailAddress = "alice@kt.com";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                })
                .build();
        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();

        userService.createUser(alice);
        internalUserService.createUser(alice);


        /// 이아래로 함수형으로 전략패턴, 유연하게 적용가능
        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
                user -> {
                    System.out.println("Validating user " + user.getName());
                    return user.getName() != null && user.getEmailAddress().isPresent();
                },
                user -> {
                    System.out.println("Writing user " + user.getName() + " to DB");
                }
        );
        userServiceInFunctionalWay.createUser(alice);
    }
}

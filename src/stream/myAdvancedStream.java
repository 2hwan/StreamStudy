package stream;

import model.Order;
import model.User2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class myAdvancedStream {
    public static void main(String[] args) {
        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@kt.com");

        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@kt.com");

        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@kt.com");
        List<User2> users = Arrays.asList(user1, user2, user3);

        List<String> emails = new ArrayList<>();
//        for(User2 user: users) {
//            if(!user.isVerified()){
//                String email = user.getEmailAddress();
//                emails.add(email);
//            }
//        }
//        System.out.println(emails);

//        List<String> emails2 = users.stream()
//                .filter(user -> !user.isVerified())
//                .map(User2::getEmailAddress)
//                .collect(Collectors.toList());
//        System.out.println(emails2);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(40));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        //TODO : Error, createdbyUserId as a list
        List<Long> errorAndCreatedByUserIdList = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(errorAndCreatedByUserIdList);

        //TODO : Error, created within 24 hours as a list
        List<Order> errorAndCreatedWithin24 = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().plusHours(24).isAfter(now))
                .collect(Collectors.toList());
        System.out.println(errorAndCreatedWithin24);

    }
}

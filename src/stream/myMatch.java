package stream;

import model.Order;
import model.User2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class myMatch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0); //predicate, 전부 만족
        System.out.println(allPositive);
        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number <0); // 하나라도 만족
        System.out.println(anyNegative);

        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@kt.com");

        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(true)
                .setEmailAddress("bob@kt.com");

        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("charlie@kt.com");

        List<User2> users = Arrays.asList(user1, user2, user3);

        boolean areAllUserVerified = users.stream()
                .allMatch(User2::isVerified);
        System.out.println(areAllUserVerified);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setAmount(BigDecimal.valueOf(2000));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(4000));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setAmount(BigDecimal.valueOf(3000));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(7000));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean anyErrorOrder = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println(anyErrorOrder);

    }
}

package stream;

import model.Order;
import model.User2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myFilter {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
        System.out.println(filteredNumbers);

        List<Integer> newfilteredNumber = Stream.of(3, -5, 7, 10, -3)
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(newfilteredNumber);

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
        List<User2> verifiedUser = users.stream()
                //.filter(user -> user.isVerified())
                .filter(User2::isVerified)
                .collect(Collectors.toList());

        System.out.println(verifiedUser);

        List<User2> unverifiedUser = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());

        System.out.println(unverifiedUser);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        // Filter Error
        List<Order> errorOrderList = orders.stream()
                .filter(error -> error.getStatus() == Order.OrderStatus.ERROR)
                .collect(Collectors.toList());
        System.out.println(errorOrderList);
    }
}

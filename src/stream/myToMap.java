package stream;

import model.Order;
import model.User2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myToMap {
    public static void main(String[] args) {
//        Map<Integer,String> numberMap = Stream.of(3, 5, -4, 2, 6)
//                .collect(Collectors.toMap(x -> x, x-> "Number is " + x)); // K, V
        Map<Integer,String> numberMap = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(Function.identity(),x-> "Number is " + x)); // K, V
        System.out.println(numberMap.get(3));

        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@kt.com")
                .setFriendUserIds(Arrays.asList(201,202,203,204));
        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@kt.com")
                .setFriendUserIds(Arrays.asList(204,205,206));
        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@kt.com")
                .setFriendUserIds(Arrays.asList(204,205,207));

        List<User2> users = Arrays.asList(user1, user2, user3);

        Map<Integer, User2> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(User2::getId, Function.identity()));
        System.out.println(userIdToUserMap);
        System.out.println(userIdToUserMap.get(103));

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

        Map<Long, Order.OrderStatus> orderIdtoOrderStatus = orders.stream()
                .collect(Collectors.toMap(Order::getId, x -> x.getStatus()));
        System.out.println(orderIdtoOrderStatus);
        System.out.println(orderIdtoOrderStatus.get(1002L));
    }
}

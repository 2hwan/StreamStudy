package stream;

import model.Order;
import model.User2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myMap {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6 ,-4);
        Stream<Integer> numberStream = numberList.stream();
        Stream<Integer> numberStreamX2 = numberStream.map(x -> x*2);
        List<Integer> numberList2 = numberStreamX2.collect(Collectors.toList());
        System.out.println(numberList2);

        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x*2)
                .collect(Collectors.toList());
        System.out.println(numberListX2);

        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "number is " + x);
        List<String> strList = strStream.collect(Collectors.toList());
        System.out.println(strList);

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

//        Stream<User2> userStream = users.stream();
//        Stream<String> userEmailString = userStream.map(User2::getEmailAddress);
//        List<String> userEmailStringList = userEmailString.collect(Collectors.toList());
//        System.out.println(userEmailStringList);
//
//        List<String> userEmailStringList2 = users.stream()
//                .map(User2::getEmailAddress)
//                .collect(Collectors.toList());
//        System.out.println(userEmailStringList2);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> createdByUserIdList = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(createdByUserIdList);
    }
}

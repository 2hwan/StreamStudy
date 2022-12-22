package stream;

import model.Order;
import model.User2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myMinMaxCount {
    public static void main(String[] args) {
//        Optional<Integer> max = Stream.of(5,3,6,2,1)
//                .max((x,y) -> x - y);
        Optional<Integer> max = Stream.of(5,3,6,2,1)
                .max(Integer::compareTo);
        System.out.println(max.get());

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

        User2 firstUser = users.stream()
                .min((u1,u2) -> u1.getName().compareTo(u2.getName()))
                .get();
        System.out.println(firstUser);

        long positiveIntegerCnt = Stream.of(1, -4, 5, -3, 6)
                .filter(x -> x> 0)
                .count();
        System.out.println(positiveIntegerCnt);

        LocalDateTime now =LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        User2 user4 = new User2()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@kt.com")
                .setCreatedAt(now.minusHours(27));
        users = Arrays.asList(user1, user2, user3, user4);

        long unverifiedUserCnt = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();
        System.out.println(unverifiedUserCnt);
        //System.out.println(users.stream().collect(Collectors.toList()));

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

        //Todo find order with highest amount an in Error status
        Order orderMax = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .max((x, y) -> x.getAmount().compareTo(y.getAmount()))
                .get();

        System.out.println(orderMax);

        BigDecimal orderMaxAmount = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO); // default 값 지정

        System.out.println(orderMaxAmount);


    }
}

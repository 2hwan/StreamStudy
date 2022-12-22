package stream;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.OrderLine;
import model.User2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class myReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x,y) -> x +y)
                .get();
        System.out.println(sum);

//        int min = numbers.stream()
//                .reduce((x, y) -> {
//                    if (x < y){
//                        return x;
//                    }
//                    return y;
//                }).get();
        int min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y)
                .get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x,y) -> x*y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x,y) -> x+y);
        System.out.println(sumOfNumberStrList);

        int sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1+num2);
        System.out.println(sumOfNumberStrList2);

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

        int sumOfNumberOfFriends = users.stream()
                .map(User2::getFriendUserIds)
                .map(List::size)
                .reduce(0 , (x,y) -> x+y);
        System.out.println(sumOfNumberOfFriends);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                            .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                            .setAmount(BigDecimal.valueOf(2000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000))
                ));


        List<Order> orders = Arrays.asList(order1, order2, order3);

        //Todo : find sum of amounts
        BigDecimal sumOfAmounts = orders.stream()
                .map(Order::getOrderLines) // Orderline list가 있음
                .flatMap(List::stream) // list 를 stream 으로 바꿈 Stream<OrderLine>
                .map(OrderLine::getAmount) // Sgream<BigDecimal>
        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmounts);

    }
}

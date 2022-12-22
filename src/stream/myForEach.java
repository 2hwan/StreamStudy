package stream;

import model.User2;
import service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class myForEach {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5,2 ,1);
        numbers.stream().forEach(number ->System.out.println("The number is "+number));
        numbers.forEach(number ->System.out.println("The number is "+number)); // stream() 생략가능

        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@kt.com")
                .setFriendUserIds(Arrays.asList(201,202,203,204, 211, 212, 213, 214));
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
                .setFriendUserIds(Arrays.asList(204,205,207, 218));

        List<User2> users = Arrays.asList(user1, user2, user3);

        EmailService emailService = new EmailService();

        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);

        for (int i = 0; i< users.size(); i++){
            User2 user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " +i);
        }

        IntStream.range(0, users.size()) // for loop 함수형 대치
                .forEach(i -> {
                    User2 user = users.get(i);
                    System.out.println("Do an operation on user " + user.getName() + " at index " +i);
                });
    }
}

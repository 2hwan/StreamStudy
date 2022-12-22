package stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import model.User2;
import service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class myParallelStream {
    public static void main(String[] args) {
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
        User2 user4 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("david@kt.com")
                .setFriendUserIds(Arrays.asList(201,202,203,204, 211, 212, 213, 214));
        User2 user5 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("eve@kt.com")
                .setFriendUserIds(Arrays.asList(204,205,206));
        User2 user6 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("frank@kt.com")
                .setFriendUserIds(Arrays.asList(204,205,207, 218));

        List<User2> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime - startTime) + "ms");


        //병렬처리가 이점이 있는지 항상 고민하고 사용해야함
        List<User2> processedUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());

        System.out.println(processedUsers);
    }
}

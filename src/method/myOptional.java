package method;

import model.User2;

import java.util.Optional;

// null 일수도 아닐수도 있는 오브젝트를 담을 때 사용
public class myOptional {
    public static void main(String[] args) {
        User2 user1 = new User2()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);

        User2 user2 = new User2()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("alice@naver.com")
                .setVerified(false);

        //NPE
        //System.out.println("Same? : " + userEqual(user1, user2));

        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty(); // 빈 optional
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail); // null 일수 있고 아닐수 있다.
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail); // null 일수 있고 아닐수 있다.

        String email = maybeEmail.get();
        System.out.println(email);

        if (maybeEmail2.isPresent()){
            System.out.println(maybeEmail2.get());
        }
        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
        String email5 = maybeEmail2.orElseThrow(()-> new RuntimeException("email not present"));

    }

    public static boolean userEqual(User2 u1, User2 u2) {
        return u1.getId() == u2.getId() &&
                u1.getName().equals(u2.getName()) &&
                u1.getEmailAddress().equals(u2.getEmailAddress()) &&
                u1.isVerified() == u2.isVerified();
    }
}

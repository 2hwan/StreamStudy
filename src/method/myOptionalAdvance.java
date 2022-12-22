package method;

import model.User2;

import java.util.Optional;

public class myOptionalAdvance {
    public static void main(String[] args) {
        //false 비어있는
        Optional<User2> maybeUser = Optional.ofNullable(maybeGetUser(true));
        // isPresent 있다면
        maybeUser.ifPresent(user -> System.out.println(user));

        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        maybeId.ifPresent(System.out::println);

        //true The name is Alice, false Name is empty
        String userName = Optional.ofNullable(maybeGetUser(true))
                .map(User2::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName);

        //flatMap 으로 Optional<Optional<String>> -> Optional<String> 으로 만들기
        Optional<String> maybeEmail =  Optional.ofNullable(maybeGetUser(true))
                .flatMap(User2::getEmailAddress);
        maybeEmail.ifPresent(System.out::println);
    }

    public static User2 maybeGetUser(boolean returnUser){
        if(returnUser) {
            return new User2()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@naver.com")
                    .setVerified(false);
        }
        return null;
    }
}

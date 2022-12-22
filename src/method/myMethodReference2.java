package method;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class myMethodReference2 {
    public static void main(String [] args){
        Function<String, Integer> strLength = String::length;
        System.out.println(strLength.apply("Hello World"));

        BiPredicate<String, String> strEqual = String::equals;
        System.out.println(strEqual.test("Hello","World"));
        System.out.println(strEqual.test("Hello","Hello"));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Chal"));
        users.add(new User(5, "Bob"));

        //printUserField(users, (User user)-> user.getId());
        printUserField(users, User::getName);
    }

    public static void printUserField(List<User> users, Function<User, Object> getter){
        for (User user:users){
            System.out.println(getter.apply(user));
        }
    }
}

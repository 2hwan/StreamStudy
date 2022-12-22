package designPattern.templateMethodPattern;

import designPattern.builderPattern.BuilderPatternFunc;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserServiceInFunctionalWay {
    private final Predicate<BuilderPatternFunc> validateUser;
    private final Consumer<BuilderPatternFunc> writeToDB;

    public UserServiceInFunctionalWay(Predicate<BuilderPatternFunc> validateUser, Consumer<BuilderPatternFunc> writeToDB){
        this.validateUser = validateUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(BuilderPatternFunc user){
        if(validateUser.test(user)){
            writeToDB.accept(user);
        } else {
            System.out.println("Cannot create user");
        }
    }
}

package designPattern.templateMethodPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public class UserService extends AbstractUserService{

    @Override
    protected boolean validateUser(BuilderPatternFunc user){
        System.out.println("Validating user " + user.getName());
        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeToDB(BuilderPatternFunc user){
        System.out.println("Writing user " + user.getName() + " to DB");
    }
}

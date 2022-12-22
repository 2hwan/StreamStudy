package designPattern.templateMethodPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public class InternalUserService extends AbstractUserService {
    @Override
    protected boolean validateUser(BuilderPatternFunc user){
        System.out.println("validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDB(BuilderPatternFunc user){
        System.out.println("Writing user " + user.getName() + " to internal DB");
    }
}

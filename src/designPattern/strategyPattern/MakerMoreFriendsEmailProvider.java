package designPattern.strategyPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public class MakerMoreFriendsEmailProvider implements EmailProvider {
    @Override
    public String getEmail(BuilderPatternFunc user){
        return "'Make More Friends' email for " + user.getName();
    }
}

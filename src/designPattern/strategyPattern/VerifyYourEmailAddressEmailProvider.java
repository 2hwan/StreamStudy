package designPattern.strategyPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider {
    @Override
    public String getEmail(BuilderPatternFunc user){
        return "'Verify Your Email Address' email for " + user.getName();
    }
}

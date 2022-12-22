package designPattern.strategyPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public interface EmailProvider {
    String getEmail(BuilderPatternFunc user);
}

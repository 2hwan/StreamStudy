package designPattern.templateMethodPattern;

import designPattern.builderPattern.BuilderPatternFunc;

public abstract class AbstractUserService { //미구현 method 라 abstract , 뼈대
    protected abstract boolean validateUser(BuilderPatternFunc user);

    protected abstract void writeToDB(BuilderPatternFunc user);

    public void createUser(BuilderPatternFunc user){ // 어떤식으로 유저를 검증할지와, DB 에 쓸지는 하위에서 구현
        if(validateUser(user)){
            writeToDB(user);
        } else {
            System.out.println("Cannot create user");
        }
    }
}

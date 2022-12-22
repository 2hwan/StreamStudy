package designPattern.builderPattern;

public class BuilderPatternUsecase {
    public static void main(String[] args) {
        BuilderPattern bp = BuilderPattern.builder(1, "Alice")
                .withEmailAddress("alice@kt.com")
                .withVerified(true)
                .build();
        System.out.println(bp);

        BuilderPatternFunc bpf = BuilderPatternFunc.builder(1,"Alice")
                .with(builder -> {// consumer 로 손쉽게 객체 생성패턴을 가져감
                    builder.emailAddress = "alice@kt.com";
                    builder.isVerified = true;
                })
                .build();
        System.out.println(bpf);
    }
}

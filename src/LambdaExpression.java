import java.util.function.Function;

public class LambdaExpression {

    public static void main(String [] args){
//        Function<Integer, Integer> myAdder = (Integer x) -> {
//            return x + 10;
//        };
        Function<Integer, Integer> myAdder = x ->  x + 10;
        int result = myAdder.apply(4);
        System.out.println("Lambda : " + result);
    }
}

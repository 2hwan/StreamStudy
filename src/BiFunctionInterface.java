import java.util.function.BiFunction;

public class BiFunctionInterface {

    public static void main(String [] args){
        BiFunction<Integer, Integer, Integer> myAdder = (x, y) ->  x + y;
        int result = myAdder.apply(1, 10);
        System.out.println("BiFunc : " + result);
    }
}

package advance;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluation {
    public static void main(String[] args) {
        if (true || returnFalse()){ // returnfalse 실행안됨
            System.out.println("true");
        }

        if (or(returnTrue(), returnFalse())){ // 최적화 x
            System.out.println("ture");
        }

        if (lazyOr(() -> returnTrue(), () -> returnFalse())){
            System.out.println("lazy " + true);
        }

        Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
                .filter(x -> x>0)
                .peek(x -> System.out.println("peeking " + x ))
                .filter(x -> x%2 == 0);
        System.out.println(("before collect"));

        List<Integer> integers = integerStream.collect(Collectors.toList()); // 뒤에가서야 계산함 stream 은 lazy evaluation 을통한 최적화를 진행함
        System.out.println("after collect: " + integers);
    }

    public static boolean or(boolean x, boolean y){
        return x || y;
    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y){ // 최적홯하기
        return x.get() || y.get();
    }

    public static boolean returnTrue(){
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }
}

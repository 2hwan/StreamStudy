package func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// input 만 있음 input 을 소비하는놈
public class myConsumer {
    public static void main(String [] args){
        Consumer<String> myStringConsumer = (String str) -> {
            System.out.println(str);
        };
        myStringConsumer.accept("Hello");
        myStringConsumer.accept("World  ");

        // immutable
        List<Integer> integerInputs = Arrays.asList(4, 2, 3);
        //integerInputs.add(5);
        List<Double> doubleInputs = Arrays.asList(1.1, 23.4, 12.234);

        Consumer<Integer> myIntegerProcessor = x -> System.out.println("Processing integer " + x);
        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> myDifferentIntegerProcessor = x -> System.out.println("Processiong integer different way " +x);
        process(integerInputs, myDifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x -> System.out.println("Processiong double " +x);
        process(doubleInputs, myDoubleProcessor);
    }
    public static <T> void process(List<T> inputs, Consumer<T> processor){
        for (T input : inputs){
            processor.accept(input);
        }
    }
}

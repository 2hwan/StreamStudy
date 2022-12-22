package func;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class myBiConsumer {
    public static void main(String [] args){
        BiConsumer<Integer, Double> myBiDoubleProcessor = (index, input) ->
                System.out.println("Processing " + input + " at index " + index);

        List<Double> inputs = Arrays.asList(1.1, 2.2, 3.3);
        process(inputs, myBiDoubleProcessor);
    }
    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor){
        for (int i=0; i<inputs.size(); i ++){
            processor.accept(i,inputs.get(i));
        }
    }
}

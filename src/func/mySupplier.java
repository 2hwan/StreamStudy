package func;

import java.util.function.Supplier;

// output 만함 공급하는놈
public class mySupplier {
    public static void main(String [] args){
        Supplier<String> myStringSupplier = () -> "Hello world";
        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());

        printRandomDoubles(myRandomDoubleSupplier, 5);
    }
    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i=0; i< count; i++){
            System.out.println(randomSupplier.get());
        }
    }
}

package func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class myPredicate {
    public static void main(String [] args){
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(-10));

        List<Integer> inputs = Arrays.asList(1, -2, 3, -19,2424, 32, 0);
        System.out.println(filter(inputs, isPositive));

        System.out.println("Non-positive num " + filter(inputs,isPositive.negate()));
        System.out.println("or Predicate " +filter(inputs,isPositive.or(x -> x == 0)));
        System.out.println("and Predicate " + filter(inputs, isPositive.and(x -> x % 2 ==0)));
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
        List<T> output = new ArrayList<>();
        for(T input : inputs){
            if(condition.test(input)){
                output.add(input);
            }
        }
        return output;
    }
}

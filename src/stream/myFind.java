package stream;

import java.util.Optional;
import java.util.stream.Stream;

public class myFind {
    public static void main(String[] args) {
         Optional<Integer> findAnyNegativeInteger = Stream.of(3, 2, -5, 6)
                .filter(x -> x<0)
                .findAny();
         System.out.println(findAnyNegativeInteger.get());

         Optional<Integer> findFirstPositiveInteger = Stream.of(3, 2, -5, 6)
                .filter(x -> x>0)
                .findFirst();
        System.out.println(findFirstPositiveInteger.get());
    }
}

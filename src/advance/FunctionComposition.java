package advance;

import advance.processor.OrderLinePriceProcessor;
import advance.processor.TaxPriceProcessor;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2*x;
        Function<Integer, Integer> addTen = x->x+10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen); // andthen 합성
        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))
                ));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(),
                        //(priceProcessors1, priceProcessors2) -> priceProcessors1.andThen(priceProcessors2))
                        Function::andThen);

        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order){
        return Arrays.asList(new OrderLinePriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}

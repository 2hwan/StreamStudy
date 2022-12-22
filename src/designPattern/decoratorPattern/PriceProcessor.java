package designPattern.decoratorPattern;

@FunctionalInterface
public interface PriceProcessor {
    Price process(Price price);

    default PriceProcessor andThen(PriceProcessor next){ // andThen 호출 시 새로운 priceprocessor 를 만들어서 return
        return price -> next.process(process(price));
    }
}

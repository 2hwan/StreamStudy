package designPattern.decoratorPattern;

public class BasicPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price){
        return price;
    }
}

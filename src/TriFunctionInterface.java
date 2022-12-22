import util.TriFunction;

public class TriFunctionInterface {
    public static void main(String [] args){
        TriFunction<Integer, Integer, Integer, Integer> addThreeNum = (x,y,z) -> x+y+z;
        System.out.println("Custom Tri Func " + addThreeNum.apply(1, 2, 3));
    }
}

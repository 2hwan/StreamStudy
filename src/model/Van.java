package model;

// abstract 미구현된 메소드를 가질 수 있음
public class Van extends Car {
    public Van(String name, String brand){
        super(name, brand);
    }
    public void drive(){
        System.out.println("Driving a Van " + name+ " from "+ brand);
    }
}

package model;

// abstract 미구현된 메소드를 가질 수 있음
public class Sedan extends Car {
    public Sedan(String name, String brand){
        super(name, brand);
    }
    public void drive(){
        System.out.println("Driving a Sedan " + name+ " from "+ brand);
    }
}

package model;

// abstract 미구현된 메소드를 가질 수 있음
public abstract class Car {
    //protected 상속받은 객체도 사용 할 수 있음
    protected String name;
    protected String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public abstract void drive();
}

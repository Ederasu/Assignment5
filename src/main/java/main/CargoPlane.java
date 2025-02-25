package main;

public class CargoPlane implements Airplane {
    @Override
    public void fly() {
        System.out.println("Cargo plane is flying with goods.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Cargo plane is refueling.");
    }
}

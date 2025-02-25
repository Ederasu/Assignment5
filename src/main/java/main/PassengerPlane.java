package main;

public class PassengerPlane implements Airplane {
    @Override
    public void fly() {
        System.out.println("Passenger plane is flying with passengers.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Passenger plane is refueling.");
    }
}


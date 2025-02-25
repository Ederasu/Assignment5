package main;

public class PrivateJet implements Airplane {
    @Override
    public void fly() {
        System.out.println("Private jet is flying luxuriously.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Private jet is refueling.");
    }
}

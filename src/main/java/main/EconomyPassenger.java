package main;

public class EconomyPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("Economy passenger checked in.");
    }
    
    @Override
    public void board() {
        System.out.println("Economy passenger boarded the plane.");
    }
}
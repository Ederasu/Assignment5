package main;

public class BusinessPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("Business passenger checked in with priority.");
    }
    
    @Override
    public void board() {
        System.out.println("Business passenger boarded the plane with priority.");
    }
}

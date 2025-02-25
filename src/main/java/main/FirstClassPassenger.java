package main;

public class FirstClassPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("First-class passenger checked in with lounge access.");
    }
    
    @Override
    public void board() {
        System.out.println("First-class passenger boarded the plane with luxury service.");
    }
}

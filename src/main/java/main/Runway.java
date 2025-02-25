package main;

public class Runway implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Runway assigned for takeoff/landing.");
    }
    
    @Override
    public void release() {
        System.out.println("Runway is now available.");
    }
}

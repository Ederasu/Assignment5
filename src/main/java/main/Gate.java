package main;

public class Gate implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Gate assigned to a flight.");
    }
    
    @Override
    public void release() {
        System.out.println("Gate is now available.");
    }
}
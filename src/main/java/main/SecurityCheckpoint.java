package main;

public class SecurityCheckpoint implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Security checkpoint is open for passengers.");
    }
    
    @Override
    public void release() {
        System.out.println("Security checkpoint is now closed.");
    }
}

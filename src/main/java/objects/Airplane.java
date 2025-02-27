
package objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Airplane {
    private String flightNumber;
    private int passengerCapacity;
    private List<Passenger> passengers;

    public Airplane(String flightNumber, int passengerCapacity) {
        this.flightNumber = flightNumber;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public abstract String getType();
}
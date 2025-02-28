package src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import objects.Airplane;
import objects.CargoPlane;
import objects.Passenger;
import objects.PassengerPlane;

public class AirplaneTest {

    @Test
    public void testCargoPlaneType() {
        Airplane plane = new CargoPlane("FLT123");
        assertEquals("Cargo", plane.getType());
    }

    @Test
    public void testPassengerPlaneType() {
        Airplane plane = new PassengerPlane("FLT456");
        assertEquals("Passenger", plane.getType());
    }

    @Test
    public void testAirplaneFlightNumber() {
        Airplane plane = new CargoPlane("FLT789");
        assertEquals("FLT789", plane.getFlightNumber());
    }
    @Test
    public void testPassengerAdditionToPlane(){
        PassengerPlane plane = new PassengerPlane("FLT123");
        Passenger passenger = new Passenger("John Doe", "FLT123");
        plane.addPassenger(passenger);
        assertEquals(1, plane.getPassengers().size());
        assertEquals(passenger, plane.getPassengers().get(0));
    }
}
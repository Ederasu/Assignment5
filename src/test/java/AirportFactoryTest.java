package src.test.java;

import objects.Airplane;
import objects.CargoPlane;
import objects.Gate;
import objects.PassengerPlane;
import static org.junit.jupiter.api.Assertions.*;

import factory.AirportFactory;

public class AirportFactoryTest {

    private final AirportFactory factory = new AirportFactory();

    @Test
    public void testCreateCargoPlane() {
        Airplane plane = factory.createAirplane("Cargo", "FLT123");
        assertNotNull(plane);
        assertTrue(plane instanceof CargoPlane);
        assertEquals("FLT123", plane.getFlightNumber());
    }

    @Test
    public void testCreatePassengerPlane() {
        Airplane plane = factory.createAirplane("Passenger", "FLT456");
        assertNotNull(plane);
        assertTrue(plane instanceof PassengerPlane);
        assertEquals("FLT456", plane.getFlightNumber());
    }

    @Test
    public void testCreateGate() {
        Gate gate = factory.createGate(1);
        assertNotNull(gate);
        assertEquals(1, gate.getGateNumber());
    }

    @Test
    public void testCreateUnknownAirplaneType() {
        Airplane plane = factory.createAirplane("Unknown", "FLT789");
        assertNull(plane);
    }
}
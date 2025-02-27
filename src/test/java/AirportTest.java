package src.test.java;

import factory.AirportFactory;
import objects.Airplane;
import objects.CargoPlane;
import objects.Gate;
import objects.Passenger;
import observer.AirportObserver;
import org.junit.Before;
import org.junit.Test;
import strategy.GateStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AirportTest {

    private Airport airport;
    private List<Gate> gates;

    @Before
    public void setUp() {
        gates = new ArrayList<>();
        gates.add(new Gate(1));
        gates.add(new Gate(2));
        airport = new Airport(gates, new GateStrategy(), new AirportFactory(), 2, 2);
        airport.addObserver(new AirportObserver());
    }

    @Test
    public void testAirplaneArrivesAndDeparts() {
        Airplane plane = new CargoPlane("FLT123");
        airport.airplaneArrives(plane);
        assertEquals(plane, gates.get(0).getAssignedAirplane());
        airport.airplaneDeparts(plane);
        assertNull(gates.get(0).getAssignedAirplane());
    }

    @Test
    public void testAddAndProcessDepartingPassengers() {
        Passenger passenger = new Passenger("John Doe", "FLT123");
        airport.addDepartingPassenger(passenger);
        airport.processDepartingPassengers();
        assertTrue(passenger.isCheckedIn());
        assertTrue(passenger.isSecurityCleared());
    }

    @Test
    public void testAddAndProcessArrivingPassengers() {
        Passenger passenger = new Passenger("Jane Smith", "FLT456");
        airport.addArrivingPassenger(passenger);
        airport.processArrivingPassengers();
        assertTrue(passenger.isBaggageClaimed());
    }
}
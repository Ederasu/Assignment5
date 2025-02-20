package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AirplaneTest {

    @Test
    void testPassengerPlane() {
        Airplane passengerPlane = new PassengerPlane();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        passengerPlane.fly();
        passengerPlane.refuel();
        
        String output = outContent.toString().trim();
        assertTrue(output.contains("Passenger plane is flying with passengers."));
        assertTrue(output.contains("Passenger plane is refueling."));
    }
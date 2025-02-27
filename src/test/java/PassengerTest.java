package src.test.java;

import org.junit.Test;
import objects.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testPassengerAttributes() {
        Passenger passenger = new Passenger("John Doe", "FLT123");
        assertEquals("John Doe", passenger.getName());
        assertEquals("FLT123", passenger.getFlightNumber());
        assertFalse(passenger.isCheckedIn());
        assertFalse(passenger.isSecurityCleared());
        assertFalse(passenger.isBaggageClaimed());
    }

    @Test
    public void testPassengerProcessing() {
        Passenger passenger = new Passenger("Jane Smith", "FLT456");
        passenger.checkIn();
        assertTrue(passenger.isCheckedIn());
        passenger.clearSecurity();
        assertTrue(passenger.isSecurityCleared());
        passenger.claimBaggage();
        assertTrue(passenger.isBaggageClaimed());
    }
}

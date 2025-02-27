package src.test.java;

import org.junit.Test;
import objects.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class GateTest {

    @Test
    public void testGateNumber() {
        Gate gate = new Gate(1);
        assertEquals(1, gate.getGateNumber());
    }

    @Test
    public void testAssignAndClearAirplane() {
        Gate gate = new Gate(1);
        Airplane plane = new CargoPlane("FLT123");
        gate.assignAirplane(plane);
        assertEquals(plane, gate.getAssignedAirplane());
        assertFalse(gate.isAvailable());

        gate.clearGate();
        assertNull(gate.getAssignedAirplane());
        assertTrue(gate.isAvailable());
    }

    @Test
    public void testIsAvailable() {
        Gate gate = new Gate(1);
        assertTrue(gate.isAvailable());
        gate.assignAirplane(new CargoPlane("FLT456"));
        assertFalse(gate.isAvailable());
    }
}
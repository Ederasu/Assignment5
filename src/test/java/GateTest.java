package src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import objects.Airplane;
import objects.CargoPlane;
import objects.Gate;

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
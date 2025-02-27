package src.test.java;

import objects.Airplane;
import objects.CargoPlane;
import objects.Gate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class GateStrategyTest {

    private final GateStrategy strategy = new GateStrategy();

    @Test
    public void testAllocateAvailableGate() {
        List<Gate> gates = new ArrayList<>();
        gates.add(new Gate(1));
        Airplane plane = new CargoPlane("FLT123");
        Gate allocatedGate = strategy.allocateGate(plane, gates);
        assertNotNull(allocatedGate);
        assertEquals(1, allocatedGate.getGateNumber());
    }

    @Test
    public void testAllocateNoAvailableGate() {
        List<Gate> gates = new ArrayList<>();
        Gate gate = new Gate(1);
        gate.assignAirplane(new CargoPlane("FLT456"));
        gates.add(gate);
        Airplane plane = new CargoPlane("FLT789");
        Gate allocatedGate = strategy.allocateGate(plane, gates);
        assertNull(allocatedGate);
    }
}

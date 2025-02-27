
package strategy;

import java.util.List;

import objects.Airplane;
import objects.Gate;

public class GateAllocation implements GateStrategy {
    @Override
    public Gate allocateGate(Airplane airplane, List<Gate> gates) {
        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                return gate;
            }
        }
        return null;
    }
}
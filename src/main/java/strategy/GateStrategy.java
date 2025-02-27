
package strategy;

import java.util.List;

import objects.Airplane;
import objects.Gate;

public interface GateStrategy {
    Gate allocateGate(Airplane airplane, List<Gate> gates);
}

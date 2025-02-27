
package factory;

import objects.Airplane;
import objects.Gate;

public interface AirportInter {
    Airplane createAirplane(String type, String flightNumber);
    Gate createGate(int gateNumber);
}

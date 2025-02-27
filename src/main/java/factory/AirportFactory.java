
package factory;

import objects.Airplane;
import objects.CargoPlane;
import objects.Gate;
import objects.PassengerPlane;

public class AirportFactory implements AirportInter {

    public AirportFactory() {
    }
    @Override
    public Airplane createAirplane(String type, String flightNumber) {
        if ("Cargo".equalsIgnoreCase(type)) {
            return new CargoPlane(flightNumber);
        } else if ("Passenger".equalsIgnoreCase(type)) {
            return new PassengerPlane(flightNumber);
        }
        return null;
    }

    @Override
    public Gate createGate(int gateNumber) {
        return new Gate(gateNumber);
    }
}
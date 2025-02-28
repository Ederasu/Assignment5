
package observer;

import objects.Airplane;
import objects.Gate;
import objects.Passenger;

public interface Observer {

    void updateAirplaneArrival(Airplane airplane, Gate gate);

    void updateAirplaneDeparture(Airplane airplane, Gate gate);

    void updatePassengerCheckIn(Passenger passenger);

    void updatePassengerSecurityClearance(Passenger passenger);
    
    void updatePassengerBaggageClaim(Passenger passenger);
}
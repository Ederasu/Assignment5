
package observer;

import objects.Airplane;
import objects.Gate;
import objects.Passenger;

public class AirportObserver implements Observer {
    
    @Override
    public void updateAirplaneArrival(Airplane airplane, Gate gate) {
        System.out.println("Observer: Airplane " + airplane.getFlightNumber() + " arrived at gate: " + gate.getGateNumber());
    }
    
    @Override
    public void updateAirplaneDeparture(Airplane airplane, Gate gate) {
        System.out.println("Observer: Airplane " + airplane.getFlightNumber() + " departed from gate: " + gate.getGateNumber());
    }
    
    @Override
    public void updatePassengerCheckIn(Passenger passenger) {
        System.out.println("Observer: Passenger " + passenger.getName() + " checked in for flight " + passenger.getFlightNumber());
    }

    @Override
    public void updatePassengerSecurityClearance(Passenger passenger) {
        System.out.println("Observer: Passenger " + passenger.getName() + " cleared security for flight " + passenger.getFlightNumber());
    }

    @Override
    public void updatePassengerBaggageClaim(Passenger passenger) {
        System.out.println("Observer: Passenger " + passenger.getName() + " claimed baggage for flight " + passenger.getFlightNumber());
    }
}

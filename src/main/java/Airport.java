
import java.util.ArrayList;
import java.util.List;

import airportresources.BagClaim;
import airportresources.Resource;
import airportresources.Security;
import factory.AirportFactory;
import objects.Airplane;
import objects.Gate;
import objects.Passenger;
import observer.Observer;
import strategy.GateStrategy;

public class Airport {
    private List<Gate> gates;
    private GateStrategy gateAllocationStrategy;
    private List<Observer> observers;
    private AirportFactory factory;
    private List<Security> securityCheckpoints;
    private List<BagClaim> baggageCarousels;
    private List<Passenger> departingPassengers;
    private List<Passenger> arrivingPassengers;

    public Airport(List<Gate> gates, GateStrategy gateAllocationStrategy, AirportFactory factory, int securityCheckpointCount, int baggageCarouselCount) {
        this.gates = gates;
        this.gateAllocationStrategy = gateAllocationStrategy;
        this.observers = new ArrayList<>();
        this.factory = factory;
        this.securityCheckpoints = new ArrayList<>();
        this.baggageCarousels = new ArrayList<>();
        this.departingPassengers = new ArrayList<>();
        this.arrivingPassengers = new ArrayList<>();

        for (int i = 0; i < securityCheckpointCount; i++) {
            this.securityCheckpoints.add(new Security());
        }
        for (int i = 0; i < baggageCarouselCount; i++) {
            this.baggageCarousels.add(new BagClaim());
        }
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void airplaneArrives(Airplane airplane) {
        Gate gate = gateAllocationStrategy.allocateGate(airplane, gates);
        if (gate != null) {
            gate.assignAirplane(airplane);
            notifyAirplaneArrival(airplane, gate);
        } else {
            System.out.println("Airport Log: No available gates for airplane: " + airplane.getFlightNumber());
        }
    }

    public void airplaneDeparts(Airplane airplane) {
        for (Gate gate : gates) {
            if (gate.getAssignedAirplane() == airplane) {
                gate.clearGate();
                notifyAirplaneDeparture(airplane, gate);
                break;
            }
        }
    }

    public void addDepartingPassenger(Passenger passenger) {
        this.departingPassengers.add(passenger);
    }

    public void addArrivingPassenger(Passenger passenger) {
        this.arrivingPassengers.add(passenger);
    }

    public void processDepartingPassengers() {
        List<Passenger> processedPassengers = new ArrayList<>();
        for (Passenger passenger : departingPassengers) {
            if (!passenger.isCheckedIn()) {
                passenger.checkIn();
                notifyPassengerCheckIn(passenger);
            }
            if (passenger.isCheckedIn() && !passenger.isSecurityCleared()) {
                Security checkpoint = findAvailableResource(securityCheckpoints);
                if (checkpoint != null) {
                    checkpoint.allocate();
                    passenger.clearSecurity();
                    checkpoint.release();
                    notifyPassengerSecurityClearance(passenger);
                }
            }
            if (passenger.isSecurityCleared()) {
                processedPassengers.add(passenger);
            }
        }
        departingPassengers.removeAll(processedPassengers);
    }

    public void processArrivingPassengers() {
        List<Passenger> processedPassengers = new ArrayList<>();
        for (Passenger passenger : arrivingPassengers) {
            if (!passenger.isBaggageClaimed()) {
                BagClaim carousel = findAvailableResource(baggageCarousels);
                if (carousel != null) {
                    carousel.allocate();
                    passenger.claimBaggage();
                    carousel.release();
                    notifyPassengerBaggageClaim(passenger);
                }
            }
            if (passenger.isBaggageClaimed()) {
                processedPassengers.add(passenger);
            }
        }
        arrivingPassengers.removeAll(processedPassengers);
    }

    private <T extends Resource> T findAvailableResource(List<T> resources) {
        for (T resource : resources) {
            if (resource.isAvailable()) {
                return resource;
            }
        }
        System.out.println("Airport Log: No available resource of type: " + resources.get(0).getClass().getSimpleName());
        return null;
    }

    private void notifyAirplaneArrival(Airplane airplane, Gate gate) {
        for (Observer observer : observers) {
            observer.updateAirplaneArrival(airplane, gate);
        }
    }

    private void notifyAirplaneDeparture(Airplane airplane, Gate gate) {
        for (Observer observer : observers) {
            observer.updateAirplaneDeparture(airplane, gate);
        }
    }

    private void notifyPassengerCheckIn(Passenger passenger) {
        for (Observer observer : observers) {
            observer.updatePassengerCheckIn(passenger);
        }
    }

    private void notifyPassengerSecurityClearance(Passenger passenger) {
        for (Observer observer : observers) {
            observer.updatePassengerSecurityClearance(passenger);
        }
    }

    private void notifyPassengerBaggageClaim(Passenger passenger) {
        for (Observer observer : observers) {
            observer.updatePassengerBaggageClaim(passenger);
        }
    }

    public AirportFactory getFactory() {
        return this.factory;
    }
}
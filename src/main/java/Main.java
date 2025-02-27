
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factory.AirportFactory;
import objects.Airplane;
import objects.Gate;
import objects.Passenger;
import observer.AirportObserver;
import strategy.GateAllocation;

public class Main {
    public static void main(String[] args) {
        List<Gate> gates = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            gates.add(new Gate(i));
        }

        Airport airport = new Airport(gates, new GateAllocation(), new AirportFactory(), 3, 2);
        airport.addObserver(new AirportObserver());

        Random random = new Random();

        for (int cycle = 1; cycle <= 10; cycle++) {
            System.out.println("--- Cycle " + cycle + " ---");

            // Generate arriving airplanes and passengers
            if (random.nextDouble() < 0.3) {
                String flightNumber = "ARR" + random.nextInt(1000);
                Airplane airplane = airport.getFactory().createAirplane("Passenger", flightNumber);
                if (airplane != null) {
                    airport.airplaneArrives(airplane);
                    int passengerCount = random.nextInt(10) + 5;
                    for (int j = 0; j < passengerCount; j++) {
                        String passengerName = "Passenger" + random.nextInt(100);
                        Passenger passenger = new Passenger(passengerName, flightNumber);
                        airport.addArrivingPassenger(passenger);
                    }
                }
            }

            // Generate departing airplanes and passengers
            if (random.nextDouble() < 0.2) {
                String flightNumber = "DEP" + random.nextInt(1000);
                Airplane airplane = airport.getFactory().createAirplane("Passenger", flightNumber);
                if (airplane != null) {
                    airport.airplaneArrives(airplane);
                    int passengerCount = random.nextInt(10) + 5;
                    for (int j = 0; j < passengerCount; j++) {
                        String passengerName = "Passenger" + random.nextInt(100);
                        Passenger passenger = new Passenger(passengerName, flightNumber);
                        airport.addDepartingPassenger(passenger);
                    }
                }
            }

            // Process passengers
            airport.processArrivingPassengers();
            airport.processDepartingPassengers();

            System.out.println("End of Cycle " + cycle);
        }
    }
}
package main;

import java.util.*;

public class Simulation {
    private static final int TOTAL_CYCLES = 10;
    private static final int CYCLE_DURATION = 30; // 30 minutes per cycle
    private static final Random random = new Random();
    
    private List<Airplane> airplanes;
    private List<Passenger> passengers;
    private List<AirportResource> resources;
    
    public Simulation() {
        airplanes = new ArrayList<>();
        passengers = new ArrayList<>();
        resources = new ArrayList<>();
    
        initializeSimulation();
    }
    
    private void initializeSimulation() {
        // Create airplanes
        airplanes.add(AirplaneFactory.createAirplane("passenger"));
        airplanes.add(AirplaneFactory.createAirplane("cargo"));
        airplanes.add(AirplaneFactory.createAirplane("private"));
    
        // Create passengers
        passengers.add(PassengerFactory.createPassenger("economy"));
        passengers.add(PassengerFactory.createPassenger("business"));
        passengers.add(PassengerFactory.createPassenger("first class"));
    
        // Create airport resources
        resources.add(AirportResourceFactory.createResource("gate"));
        resources.add(AirportResourceFactory.createResource("runway"));
        resources.add(AirportResourceFactory.createResource("security"));
    }
    
    public void runSimulation() {
        System.out.println("Starting Airport Simulation...");
        for (int cycle = 1; cycle <= TOTAL_CYCLES; cycle++) {
            System.out.println("\n--- Cycle " + cycle + " (" + (cycle * CYCLE_DURATION) + " minutes) ---");
            simulateArrivalsAndDepartures();
            simulatePassengerProcessing();
            simulateResourceManagement();
        }
        System.out.println("\nSimulation Complete.");
    }
    
    private void simulateArrivalsAndDepartures() {
        for (Airplane airplane : airplanes) {
            if (random.nextBoolean()) {
                System.out.println("Arrival: " + airplane.getClass().getSimpleName() + " has arrived and is assigned a gate.");
                allocateResource("gate");
            } else {
                System.out.println("Departure: " + airplane.getClass().getSimpleName() + " is departing.");
                allocateResource("runway");
            }
        }
    }
    
    private void simulatePassengerProcessing() {
        for (Passenger passenger : passengers) {
            passenger.checkIn();
            allocateResource("security");
            passenger.board();
        }
    }
    
    private void simulateResourceManagement() {
        for (AirportResource resource : resources) {
            if (random.nextBoolean()) {
                resource.allocate();
            } else {
                resource.release();
            }
        }
    }
    
    private void allocateResource(String type) {
        for (AirportResource resource : resources) {
            if (resource.getClass().getSimpleName().toLowerCase().contains(type)) {
                resource.allocate();
                return;
            }
        }
    }
}
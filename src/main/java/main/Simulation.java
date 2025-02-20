package main;

class Simulation {
    private int cycles;
    
    public Simulation(int cycles) {
        this.cycles = cycles;
    }
    
    public void run() {
        for (int i = 1; i <= cycles; i++) {
            System.out.println("\n--- Cycle " + i + " (30 minutes) ---");
            
            Airplane airplane = AirplaneFactory.createAirplane("passenger");
            airplane.fly();
            airplane.refuel();
           
            /* Future implementation
            Passenger passenger = PassengerFactory.createPassenger("economy");
            passenger.checkIn();
            passenger.board();
            */
            
            /* Future implementation
            AirportResource gate = AirportResourceFactory.createResource("gate");
            gate.allocate();
            gate.release();
            */
        }
    }
}
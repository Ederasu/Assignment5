package src.main.java.main;

// Airplane.java
public interface Airplane {
    void fly();
    void refuel();
}

// Airplane Implementations

// Passenger Plane
class PassengerPlane implements Airplane {
    @Override
    public void fly() {
        System.out.println("Passenger plane is flying with passengers.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Passenger plane is refueling.");
    }
}

// Cargo Plane
class CargoPlane implements Airplane {
    @Override
    public void fly() {
        System.out.println("Cargo plane is flying with goods.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Cargo plane is refueling.");
    }
}

// Private Jet
class PrivateJet implements Airplane {
    @Override
    public void fly() {
        System.out.println("Private jet is flying luxuriously.");
    }
    
    @Override
    public void refuel() {
        System.out.println("Private jet is refueling.");
    }
}

// Factory Class to Create Airplanes
class AirplaneFactory {
    public static Airplane createAirplane(String type) {
        switch (type.toLowerCase()) {
            case "passenger":
                return new PassengerPlane();
            case "cargo":
                return new CargoPlane();
            case "private":
                return new PrivateJet();
            default:
                throw new IllegalArgumentException("Unknown airplane type: " + type);
        }
    }
}
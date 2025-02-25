package main;

interface Passenger {
    void checkIn();
    void board();
}

// Economy Passenger
class EconomyPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("Economy passenger checked in.");
    }
    
    @Override
    public void board() {
        System.out.println("Economy passenger boarded the plane.");
    }
}

// Business Passenger
class BusinessPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("Business passenger checked in with priority.");
    }
    
    @Override
    public void board() {
        System.out.println("Business passenger boarded the plane with priority.");
    }
}

// First Class Passenger
class FirstClassPassenger implements Passenger {
    @Override
    public void checkIn() {
        System.out.println("First-class passenger checked in with lounge access.");
    }
    
    @Override
    public void board() {
        System.out.println("First-class passenger boarded the plane with luxury service.");
    }
}

// Factory Class to Create Passengers
class PassengerFactory {
    public static Passenger createPassenger(String type) {
        switch (type.toLowerCase()) {
            case "economy" -> {
                return new EconomyPassenger();
            }
            case "business" -> {
                return new BusinessPassenger();
            }
            case "first class" -> {
                return new FirstClassPassenger();
            }
            default -> throw new IllegalArgumentException("Unknown passenger type: " + type);
        }
    }
}
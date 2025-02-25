package main;

public class PassengerFactory {
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

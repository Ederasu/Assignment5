package main;

public class AirplaneFactory {
    public static Airplane createAirplane(String type) {
        switch (type.toLowerCase()) {
            case "passenger" -> {
                return new PassengerPlane();
            }
            case "cargo" -> {
                return new CargoPlane();
            }
            case "private" -> {
                return new PrivateJet();
            }
            default -> throw new IllegalArgumentException("Unknown airplane type: " + type);
        }
    }
}

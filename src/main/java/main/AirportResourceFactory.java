package main;

// Factory Class to Create Airport Resources
public class AirportResourceFactory {
    public static AirportResource createResource(String type) {
        switch (type.toLowerCase()) {
            case "gate" -> {
                return new Gate();
            }
            case "runway" -> {
                return new Runway();
            }
            case "security" -> {
                return new SecurityCheckpoint();
            }
            default -> throw new IllegalArgumentException("Unknown airport resource type: " + type);
        }
    }
}
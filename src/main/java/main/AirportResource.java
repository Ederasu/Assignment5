package main;

interface AirportResource {
    void allocate();
    void release();
}

// Concrete Airport Resources

// Gate
class Gate implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Gate assigned to a flight.");
    }
    
    @Override
    public void release() {
        System.out.println("Gate is now available.");
    }
}

// Runway
class Runway implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Runway assigned for takeoff/landing.");
    }
    
    @Override
    public void release() {
        System.out.println("Runway is now available.");
    }
}

// Security Checkpoint
class SecurityCheckpoint implements AirportResource {
    @Override
    public void allocate() {
        System.out.println("Security checkpoint is open for passengers.");
    }
    
    @Override
    public void release() {
        System.out.println("Security checkpoint is now closed.");
    }
}

// Factory Class to Create Airport Resources
class AirportResourceFactory {
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
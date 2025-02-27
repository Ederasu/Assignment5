
package objects;

public class Passenger {
    private String name;
    private String flightNumber;
    private boolean checkedIn;
    private boolean securityCleared;
    private boolean baggageClaimed;

    public Passenger(String name, String flightNumber) {
        this.name = name;
        this.flightNumber = flightNumber;
        this.checkedIn = false;
        this.securityCleared = false;
        this.baggageClaimed = false;
    }

    public String getName() {
        return name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void checkIn() {
        this.checkedIn = true;
    }

    public void clearSecurity() {
        this.securityCleared = true;
    }

    public void claimBaggage() {
        this.baggageClaimed = true;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public boolean isSecurityCleared() {
        return securityCleared;
    }

    public boolean isBaggageClaimed() {
        return baggageClaimed;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' + ", flightNumber='" + flightNumber + '\'' + '}';
    }
}

package objects;

public class PassengerPlane extends Airplane {
    public PassengerPlane(String flightNumber) {
        super(flightNumber, 200);
    }

    @Override
    public String getType() {
        return "Passenger";
    }
}

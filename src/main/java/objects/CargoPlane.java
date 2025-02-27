
package objects;

public class CargoPlane extends Airplane {
    public CargoPlane(String flightNumber) {
        super(flightNumber,5);
    }

    @Override
    public String getType() {
        return "Cargo";
    }
}

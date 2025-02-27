
package objects;

public class Gate {
    private int gateNumber;
    private Airplane assignedAirplane;

    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
        this.assignedAirplane = null;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public Airplane getAssignedAirplane() {
        return assignedAirplane;
    }

    public void assignAirplane(Airplane airplane) {
        this.assignedAirplane = airplane;
    }

    public void clearGate() {
        this.assignedAirplane = null;
    }

    public boolean isAvailable() {
        return assignedAirplane == null;
    }
}
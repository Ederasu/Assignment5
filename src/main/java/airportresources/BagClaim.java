
package airportresources;

public class BagClaim implements Resource {
    private boolean available;

    public BagClaim() {
        this.available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void allocate() {
        this.available = false;
    }

    @Override
    public void release() {
        this.available = true;
    }
}
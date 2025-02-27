
package airportresources;

public interface Resource {
    boolean isAvailable();
    void allocate();
    void release();
}
package src.test.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import airportresources.Security;

public class SecurityTest {

    @Test
    public void testSecurityCheckpointAvailability() {
        Security checkpoint = new Security();
        assertTrue(checkpoint.isAvailable());
        checkpoint.allocate();
        assertFalse(checkpoint.isAvailable());
        checkpoint.release();
        assertTrue(checkpoint.isAvailable());
    }
}
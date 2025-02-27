package src.test.java;

import org.junit.Test;

import airportresources.Security;

import static org.junit.Assert.*;

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
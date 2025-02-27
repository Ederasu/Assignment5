package src.test.java;

import org.junit.Test;

import airportresources.BagClaim;

import static org.junit.Assert.*;

public class BagClaimTest {

    @Test
    public void testBaggageCarouselAvailability() {
        BagClaim carousel = new BagClaim();
        assertTrue(carousel.isAvailable());
        carousel.allocate();
        assertFalse(carousel.isAvailable());
        carousel.release();
        assertTrue(carousel.isAvailable());
    }
}
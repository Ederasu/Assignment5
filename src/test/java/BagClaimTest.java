package src.test.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import airportresources.BagClaim;

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
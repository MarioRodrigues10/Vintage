package vintage.module.item;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.carrier.Carrier;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class BagTest {
    /**
     * Tests the Bag constructor.
     */
    @Test
    public void bagTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);


        Bag bag = new Bag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(1000), 1, 10, "Cotton", 2018, carrier);

        assertEquals("A nice bag", bag.getDescription());
        assertEquals("Louis Vuitton", bag.getBrand());
        assertEquals(BigDecimal.valueOf(1000), bag.getPrice());
        assertEquals(1, bag.getOwners());
        assertEquals(10, bag.getSize());
        assertEquals("Cotton", bag.getMaterial());
        assertEquals(2018, bag.getRelease());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Bag bag = new Bag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(1000), 1, 10, "Cotton", 2018, carrier);

        assertEquals(BigDecimal.valueOf(900).setScale(2, RoundingMode.HALF_UP), bag.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the item is used.
     */
    @Test
    public void calculatePriceUsedTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);
        Bag bag = new Bag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(1000), 1, 10, "Cotton", 2018, carrier);

        BigDecimal result = BigDecimal.valueOf(1000).multiply(BigDecimal.valueOf(0.9)).setScale(2, RoundingMode.HALF_UP);

        assertEquals(result, bag.calculatePrice());
    }
}

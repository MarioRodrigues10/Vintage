package vintage.module.item;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.PremiumBag;
import vintage.module.item.carrier.Carrier;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class PremiumBagTest {

    public void bagTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Bag bag = new PremiumBag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Leather", 2018, carrier);

        assertEquals("A nice bag", bag.getDescription());
        assertEquals("Louis Vuitton", bag.getBrand());
        assertEquals(BigDecimal.valueOf(100), bag.getPrice());
        assertEquals(0, bag.getOwners());
        assertEquals(2018, bag.getRelease());
        assertEquals("Leather", bag.getMaterial());
        assertEquals(10, bag.getSize());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Bag bag = new PremiumBag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Leather", 2018, carrier);

        assertEquals(BigDecimal.valueOf(150.0), bag.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the item is used.
     */
    @Test
    public void calculatePriceUsedTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Bag bag = new PremiumBag("A nice bag", null, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Leather", 2018, carrier);

        assertEquals(BigDecimal.valueOf(150.0), bag.calculatePrice());
    }
}

package vintage.module.item;

import org.junit.Test;
import vintage.module.item.PremiumShoes;
import vintage.module.item.Shoes;
import vintage.module.item.carrier.Carrier;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PremiumShoesTest {
    public void shoesTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Shoes shoes = new PremiumShoes("A nice pair of shoes", null, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, carrier);

        assertEquals("A nice pair of shoes", shoes.getDescription());
        assertEquals("Nike", shoes.getBrand());
        assertEquals(BigDecimal.valueOf(100), shoes.getPrice());
        assertEquals(0, shoes.getOwners());
        assertEquals("Black", shoes.getColor());
        assertEquals(2018, shoes.getRelease());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Shoes shoes = new PremiumShoes("A nice pair of shoes", null, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, carrier);

        assertEquals(BigDecimal.valueOf(150.0), shoes.calculatePrice());
    }
}

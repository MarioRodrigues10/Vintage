package vintage.module.item;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.PremiumBag;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class PremiumBagTest {

    public void bagTest() {
        Bag bag = new PremiumBag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(100));
        bag.setOwners(0);
        bag.setMaterial("Leather");
        bag.setSize(10);
        bag.setRelease(2018);
        bag.setMaterial("Leather");

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
        Bag bag = new PremiumBag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(100));
        bag.setOwners(0);
        bag.setMaterial("Leather");
        bag.setRelease(2023);

        assertEquals(BigDecimal.valueOf(100.0), bag.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the item is used.
     */
    @Test
    public void calculatePriceUsedTest() {
        Bag bag = new PremiumBag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(100));
        bag.setOwners(1);
        bag.setMaterial("Leather");
        bag.setRelease(2018);

        assertEquals(BigDecimal.valueOf(150.0), bag.calculatePrice());
    }
}

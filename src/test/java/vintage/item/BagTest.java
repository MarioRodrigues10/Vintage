package vintage.item;

import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class BagTest {
    /**
     * Tests the Bag constructor.
     */
    @Test
    public void bagTest() {
        Bag bag = new Bag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(1000));
        bag.setOwners(0);
        bag.setSize(10);
        bag.setMaterial("Cotton");
        bag.setRelease(2018);

        assertEquals("A nice bag", bag.getDescription());
        assertEquals("Louis Vuitton", bag.getBrand());
        assertEquals(BigDecimal.valueOf(1000), bag.getPrice());
        assertEquals(0, bag.getOwners());
        assertEquals(10, bag.getSize());
        assertEquals("Cotton", bag.getMaterial());
        assertEquals(2018, bag.getRelease());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Bag bag = new Bag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(1000));
        bag.setOwners(0);
        bag.setSize(10);
        bag.setMaterial("Cotton");
        bag.setRelease(2018);

        assertEquals(BigDecimal.valueOf(1000), bag.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the item is used.
     */
    @Test
    public void calculatePriceUsedTest() {
        Bag bag = new Bag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(1000));
        bag.setOwners(1);
        bag.setEvaluation(10);
        bag.setSize(10);
        bag.setMaterial("Cotton");
        bag.setRelease(2018);

        BigDecimal result = BigDecimal.valueOf(1000).multiply(BigDecimal.valueOf(0.9)).setScale(2, RoundingMode.HALF_UP);

        assertEquals(result, bag.calculatePrice());
    }
}

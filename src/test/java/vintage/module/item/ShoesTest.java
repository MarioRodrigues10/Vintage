package vintage.module.item;

import org.junit.Test;
import vintage.module.item.Shoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class ShoesTest {
    /**
     * Tests the Shoes constructor.
     */
    @Test
    public void shoesTest() {
        Shoes shoes = new Shoes("A nice pair of shoes", null, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, null);

        assertEquals("A nice pair of shoes", shoes.getDescription());
        assertEquals("Nike", shoes.getBrand());
        assertEquals(BigDecimal.valueOf(100), shoes.getPrice());
        assertEquals(1, shoes.getOwners());
        assertEquals("Black", shoes.getColor());
        assertEquals(2018, shoes.getRelease());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Shoes shoes = new Shoes("A nice pair of shoes", null, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, null);

        assertEquals(BigDecimal.valueOf(90).setScale(2, RoundingMode.HALF_UP), shoes.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the item is used.
     */
    @Test
    public void calculatePriceUsedTest() {
        Shoes shoes = new Shoes("A nice pair of shoes", null, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, null);

        assertEquals(BigDecimal.valueOf(90.00).setScale(2, RoundingMode.HALF_UP), shoes.calculatePrice());
    }
}

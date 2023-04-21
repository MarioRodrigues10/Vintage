package vintage.item;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PremiumShoesTest {
    public void shoesTest() {
        Shoes shoes = new PremiumShoes();
        shoes.setDescription("A nice pair of shoes");
        shoes.setBrand("Nike");
        shoes.setPrice(BigDecimal.valueOf(100));
        shoes.setOwners(0);
        shoes.setSize(10);
        shoes.setLaces(true);
        shoes.setColor("Black");
        shoes.setRelease(2018);

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
        Shoes shoes = new PremiumShoes();
        shoes.setDescription("A nice pair of shoes");
        shoes.setBrand("Nike");
        shoes.setPrice(BigDecimal.valueOf(100));
        shoes.setOwners(0);
        shoes.setSize(10);
        shoes.setLaces(true);
        shoes.setColor("Black");
        shoes.setRelease(2018);

        assertEquals(BigDecimal.valueOf(150.0), shoes.calculatePrice());
    }
}

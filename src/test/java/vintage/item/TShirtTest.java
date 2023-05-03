package vintage.item;

import org.junit.Test;
import vintage.module.item.TShirt;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class TShirtTest {
    /**
     * Tests the constructor.
     */
    @Test
    public void tShirtTest() {
        TShirt tShirt = new TShirt();
        tShirt.setDescription("A nice t-shirt");
        tShirt.setBrand("Adidas");
        tShirt.setPrice(BigDecimal.valueOf(100));
        tShirt.setOwners(0);
        tShirt.setSize(TShirt.Size.L);
        tShirt.setPattern(TShirt.Pattern.SOLID);

        assertEquals("A nice t-shirt", tShirt.getDescription());
        assertEquals("Adidas", tShirt.getBrand());
        assertEquals(BigDecimal.valueOf(100), tShirt.getPrice());
        assertEquals(0, tShirt.getOwners());
        assertEquals(TShirt.Size.L, tShirt.getSize());
        assertEquals(TShirt.Pattern.SOLID, tShirt.getPattern());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        TShirt tShirt = new TShirt();
        tShirt.setDescription("A nice t-shirt");
        tShirt.setBrand("Adidas");
        tShirt.setPrice(BigDecimal.valueOf(100));
        tShirt.setOwners(0);
        tShirt.setSize(TShirt.Size.L);
        tShirt.setPattern(TShirt.Pattern.SOLID);

        assertEquals(BigDecimal.valueOf(100), tShirt.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the tshirt is solid.
     */
    @Test
    public void calculatePriceUsedTest() {
        TShirt tShirt = new TShirt();
        tShirt.setDescription("A nice t-shirt");
        tShirt.setBrand("Adidas");
        tShirt.setPrice(BigDecimal.valueOf(100));
        tShirt.setOwners(1);
        tShirt.setEvaluation(10);
        tShirt.setSize(TShirt.Size.L);
        tShirt.setPattern(TShirt.Pattern.SOLID);

        assertEquals(BigDecimal.valueOf(100), tShirt.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the tshirt is palm.
     */
    @Test
    public void calculatePriceUsedPalmTest() {
        TShirt tShirt = new TShirt();
        tShirt.setDescription("A nice t-shirt");
        tShirt.setBrand("Adidas");
        tShirt.setPrice(BigDecimal.valueOf(100));
        tShirt.setOwners(1);
        tShirt.setEvaluation(10);
        tShirt.setSize(TShirt.Size.L);
        tShirt.setPattern(TShirt.Pattern.PALM);

        assertEquals(BigDecimal.valueOf(50.0), tShirt.calculatePrice());
    }
}

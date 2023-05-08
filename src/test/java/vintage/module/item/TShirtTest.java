package vintage.module.item;

import org.junit.Test;
import vintage.module.item.TShirt;
import vintage.module.item.carrier.Carrier;
import vintage.module.user.User;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class TShirtTest {
    /**
     * Tests the constructor.
     */
    @Test
    public void tShirtTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        TShirt tShirt = new TShirt("A nice t-shirt", null, "Adidas", 10,
                BigDecimal.valueOf(100), 1, TShirt.Size.L, TShirt.Pattern.SOLID, carrier);

        assertEquals("A nice t-shirt", tShirt.getDescription());
        assertEquals("Adidas", tShirt.getBrand());
        assertEquals(BigDecimal.valueOf(100), tShirt.getPrice());
        assertEquals(1, tShirt.getOwners());
        assertEquals(TShirt.Size.L, tShirt.getSize());
        assertEquals(TShirt.Pattern.SOLID, tShirt.getPattern());
    }

    /**
     * Tests the calculatePrice method for when the item is new.
     */
    @Test
    public void calculatePriceTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        TShirt tShirt = new TShirt("A nice t-shirt", null, "Adidas", 10,
                BigDecimal.valueOf(100), 1, TShirt.Size.L, TShirt.Pattern.SOLID, carrier);

        assertEquals(BigDecimal.valueOf(100), tShirt.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the tshirt is solid.
     */
    @Test
    public void calculatePriceUsedTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        TShirt tShirt = new TShirt("A nice t-shirt", null, "Adidas", 10,
                BigDecimal.valueOf(100), 1, TShirt.Size.L, TShirt.Pattern.SOLID, carrier);

        assertEquals(BigDecimal.valueOf(100), tShirt.calculatePrice());
    }

    /**
     * Tests the calculatePrice method for when the tshirt is palm.
     */
    @Test
    public void calculatePriceUsedPalmTest() {
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        TShirt tShirt = new TShirt("A nice t-shirt", null, "Adidas", 10,
                BigDecimal.valueOf(100), 1, TShirt.Size.L, TShirt.Pattern.SOLID, carrier);

        assertEquals(BigDecimal.valueOf(100), tShirt.calculatePrice());
    }
}

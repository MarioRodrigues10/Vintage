package vintage;

import org.junit.Test;
import vintage.item.Shoes;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShoesTest {
    @Test
    public void shoesTest() {
        Shoes shoes = new Shoes();
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
}

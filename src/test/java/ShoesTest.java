import org.junit.Test;
import vintage.item.Shoes;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShoesTest {
    @Test
    public void testShoes() {
        Shoes shoes = new Shoes();
        shoes.setDescription("A nice pair of shoes");
        shoes.setBrand("Nike");
        shoes.setPrice(BigDecimal.valueOf(100));
        shoes.setCorrection(0);
        

        assertEquals("Shoes", shoes.getName());
    }
}

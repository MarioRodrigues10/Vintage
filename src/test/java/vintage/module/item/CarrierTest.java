package vintage.module.item;

import org.junit.Test;
import vintage.module.item.carrier.Carrier;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class CarrierTest {
    @Test
    public void carrierTest() {
        Carrier carrier = new Carrier("UPS", BigDecimal.valueOf(1), false, 3);

        assertEquals("UPS", carrier.getName());
        assertEquals(BigDecimal.valueOf(1), carrier.getProfit());
        assertFalse(carrier.isPremium());
    }

    @Test
    public void calculateProfitTest() {
        Carrier carrier = new Carrier("UPS", BigDecimal.valueOf(1), false, 3);

        assertEquals(BigDecimal.valueOf(4.95).setScale(3, RoundingMode.HALF_UP), carrier.calculateShippingCost(1));
    }
}

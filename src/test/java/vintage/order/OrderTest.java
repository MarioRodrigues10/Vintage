package vintage.order;

import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderTest {
    @Test
    public void orderTest() {
        Order order = new Order();
        order.setOrderId(1);
        order.setCustomerId(1);
        order.setShippingCost(BigDecimal.valueOf(1));
        order.setTotalCost(BigDecimal.valueOf(1));
        order.setShippingAddress("123 Main St");
        order.setShippingCity("New York");
        order.setShippingState("NY");
        order.setShippingZip("10001");
        order.setShippingCountry("USA");
        order.setBillingAddress("123 Main St");
        order.setBillingCity("New York");
        order.setBillingState("NY");
        order.setBillingZip("10001");
        order.setBillingCountry("USA");
        order.setOrderStatus("Processing");
        order.setOrderDate("2018-01-01");
        order.setOrderTime("12:00:00");
        order.setOrderItems(null);

        assertEquals(1, order.getOrderId());
        assertEquals(1, order.getCustomerId());
        assertEquals(BigDecimal.valueOf(1), order.getShippingCost());
        assertEquals(BigDecimal.valueOf(1), order.getTotalCost());
        assertEquals("123 Main St", order.getShippingAddress());
        assertEquals("New York", order.getShippingCity());
        assertEquals("NY", order.getShippingState());
        assertEquals("10001", order.getShippingZip());
        assertEquals("USA", order.getShippingCountry());
        assertEquals("123 Main St", order.getBillingAddress());
        assertEquals("New York", order.getBillingCity());
        assertEquals("NY", order.getBillingState());
        assertEquals("10001", order.getBillingZip());
        assertEquals("USA", order.getBillingCountry());
        assertEquals("Processing", order.getOrderStatus());
        assertEquals("2018-01-01", order.getOrderDate());
        assertEquals("12:00:00", order.getOrderTime());
        assertNull(order.getOrderItems());
    }
}

package vintage.order;

import org.junit.Test;
import vintage.item.Bag;
import vintage.item.Carrier;
import vintage.item.Item;
import vintage.item.Shoes;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void orderTest() {
        Carrier carrier = new Carrier();
        Item item1 = new Shoes("Nike", "Air Max", 10, BigDecimal.valueOf(100), 9, 0, false, "", 2000, carrier);
        Item item2 = new Bag("Nike", "Air Max", 10, BigDecimal.valueOf(100), 0, 9, "", 2000, carrier);

        Order order = new Order();
        order.setPrice(BigDecimal.valueOf(100));
        order.setState(Order.State.PENDING);

        order.addItem(item1);
        assertEquals(Order.Size.SMALL, order.getSize());
        order.addItem(item2);
        assertEquals(Order.Size.MEDIUM, order.getSize());

        assertEquals(BigDecimal.valueOf(100), order.getPrice());
        assertEquals(Order.State.PENDING, order.getState());
    }
}

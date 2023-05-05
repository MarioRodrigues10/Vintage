package vintage.module.order;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.carrier.Carrier;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.others.Address;
import vintage.module.user.User;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void orderTest() {
        Carrier carrier = new Carrier();
        User user = new User();
        Item item1 = new Shoes("Nike", user, "Air Max", 10, BigDecimal.valueOf(100), 9, 0, false, "", 2000, carrier);
        Item item2 = new Bag("Nike", user, "Air Max", 10, BigDecimal.valueOf(100), 0, 9, "", 2000, carrier);

        Order order = new Order(user);
        order.setAddress(new Address("123 Main St", "New York", "NY", "10001"));

        order.addItem(item1);
        assertEquals(Order.Size.SMALL, order.getSize());
        order.addItem(item2);
        assertEquals(Order.Size.MEDIUM, order.getSize());

        assertEquals(BigDecimal.valueOf(200), order.getPrice());
        assertEquals(Order.State.PENDING, order.getState());
        assertEquals((new Address("123 Main St", "New York", "NY", "10001")), order.getAddress());
    }
}

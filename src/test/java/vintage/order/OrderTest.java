package vintage.order;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.carrier.Carrier;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void orderTest() {
        User user = new User("John Doe","johndoe@mail.com",new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"),"123456789",new ArrayList<Receipt>(),new ArrayList<Item>());

        Carrier carrier = new Carrier("Carrier 1", BigDecimal.valueOf(10.0), false,3);
        Item item1 = new Shoes("Nike", user, "Air Max", 10, BigDecimal.valueOf(100), 9, 0, false, "", 2000, carrier);
        Item item2 = new Bag("Nike", user, "Air Max", 10, BigDecimal.valueOf(100), 0, 9, "", 2000, carrier);

        Order order = user.getPendingOrder();
        order.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order.setBuyer(user);

        order.addItem(item1);
        assertEquals(Order.Size.SMALL, order.getSize());
        order.addItem(item2);
        assertEquals(Order.Size.MEDIUM, order.getSize());

        assertEquals(BigDecimal.valueOf(200), order.getPrice());
        assertEquals(Order.State.PENDING, order.getState());
        assertEquals((new Address("123 Main St", "New York", "NY", "10001")), order.getAddress());
        assertEquals(user, order.getBuyer());
    }
}

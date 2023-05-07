package vintage.module.others;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.item.carrier.Carrier;
import vintage.module.order.Order;
import vintage.module.order.OrderListings;
import vintage.module.order.receipt.Receipt;
import vintage.module.user.User;
import vintage.module.time.Time;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TimeTest {
    @Test
    public void TimeTest() throws Exception {
        Time time = Time.getInstance();
        time.addObserver(OrderListings.getInstance());

        User user = new User("John Doe", "johndoe@mail.com",
                new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"),
                "123456789", new ArrayList<Receipt>());
        User seller = new User("Magic Mike", "magicmike@mail.com",
                new Address("USA", "Los Angeles", "Hollywood", "4710-000"),
                "123456789", new ArrayList<Receipt>());

        Carrier ups = new Carrier("UPS", BigDecimal.valueOf(1), false, 3);

        Item item1 = new Bag("A nice bag", seller, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Cotton", 2018, ups);
        Item item2 = new Shoes("A nice pair of shoes", seller, "Nike", 10,
                BigDecimal.valueOf(100), 1, 10, true, "Black", 2018, ups);

        Order order = user.getPendingOrder();
        order.addItem(item1);
        order.addItem(item2);

        assertEquals(Order.State.PENDING, user.getPendingOrder().getState());

        order.finishOrder();
        assertEquals(Order.State.FINISHED, order.getState());

        time.jumpDays(2);
        assertEquals(Order.State.FINISHED, order.getState());

        time.jumpDays(1);
        assertEquals(Order.State.DELIVERED, order.getState());
    }
}

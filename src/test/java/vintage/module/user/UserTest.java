package vintage.module.user;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.Item;
import vintage.module.item.carrier.Carrier;
import vintage.module.order.Order;
import vintage.module.order.OrderListings;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UserTest {
    /**
     * Tests the User constructor.
     */
    @Test
    public void userTest() {
        User user = new User("John Doe", "johndoe@mail.com",
                new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"),
                "123456789", null, new ArrayList<Item>());

        assertEquals("John Doe", user.getName());
        assertEquals("johndoe@mail.com", user.getEmail());
        assertEquals(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"), user.getResidence());
        assertEquals("123456789", user.getTaxNumber());
    }

    /**
     * Tests the order interface methods in the User class.
     */
    @Test
    public void createOrderTest() throws Exception {
        User user = new User("John Doe", "johndoe@mail.com",
                new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"),
                "123456789", new ArrayList<Receipt>(), new ArrayList<Item>());
        User seller = new User("Mike Doe", "mikedoe@mail.com",
                new Address("Portugal", "New York", "Rua dos Bares", "4710-000"),
                "123456789", new ArrayList<Receipt>(), new ArrayList<Item>());

        OrderListings orderListings = OrderListings.getInstance();
        Carrier carrier = new Carrier("DHL", BigDecimal.valueOf(0.1), false, 1);

        Item bag1 = new Bag("A nice bag", seller, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Cotton", 2018, carrier);
        Item bag2 = new Bag("A nice bag", seller, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Cotton", 2018, carrier);
        Item bag3 = new Bag("A nice bag", seller, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Cotton", 2018, carrier);
        Item bag4 = new Bag("A nice bag", seller, "Louis Vuitton", 10,
                BigDecimal.valueOf(100), 1, 10, "Cotton", 2018, carrier);

        Order order = user.getPendingOrder();
        order.addItem(bag1);

        // Check if the user tries to create another order it returns the already existing pending one

        Order currentOrder = orderListings.getUserPendingOrder(user);
        assertEquals(Order.State.PENDING, currentOrder.getState());
        assertEquals(Order.Size.SMALL, currentOrder.getSize());

        order.addItem(bag2);
        order.addItem(bag3);
        order.addItem(bag4);
        assertEquals(Order.Size.MEDIUM, currentOrder.getSize());


        currentOrder.finishOrder();
        assertEquals(Order.State.FINISHED, currentOrder.getState());
    }
}

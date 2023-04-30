package vintage.user;

import org.junit.Test;
import vintage.item.Bag;
import vintage.item.Item;
import vintage.order.Order;
import vintage.order.OrderListings;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class UserTest {
    /**
     * Tests the User constructor.
     */
    @Test
    public void userTest() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");

        assertEquals("John Doe", user.getName());
        assertEquals("johndoe@mail.com", user.getEmail());
        assertEquals(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"), user.getResidence());
        assertEquals("123456789", user.getTaxNumber());
    }

    /**
     * Tests the order interface methods in the User class.
     */
    @Test
    public void createOrderTest() {
        User user = new User();
        User seller = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");

        OrderListings orderListings = new OrderListings();

        Item bag1 = new Bag();
        bag1.setOwner(seller);
        Item bag2 = new Bag();
        bag2.setOwner(seller);
        Item bag3 = new Bag();
        bag3.setOwner(seller);
        Item bag4 = new Bag();
        bag4.setOwner(seller);

        user.createOrder(orderListings);
        user.addItemToOrder(orderListings, bag1);

        Order currentOrder = orderListings.getUserPendindOrder(user);
        assertEquals(Order.State.PENDING, currentOrder.getState());
        assertEquals(Order.Size.SMALL, currentOrder.getSize());

        user.addItemToOrder(orderListings, bag2);
        user.addItemToOrder(orderListings, bag3);
        user.addItemToOrder(orderListings, bag4);

        assertEquals(Order.Size.MEDIUM, currentOrder.getSize());

        user.finishPendingOrder(orderListings);
        assertEquals(Order.State.FINISHED, currentOrder.getState());
    }
}

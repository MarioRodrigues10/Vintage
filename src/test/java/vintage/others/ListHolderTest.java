package vintage.others;

import org.junit.Test;
import vintage.item.Bag;
import vintage.item.ItemListings;
import vintage.order.Order;
import vintage.order.OrderListings;
import vintage.others.ListHolder;

import java.math.BigDecimal;
import java.util.Map;
import vintage.user.Address;
import vintage.user.User;
import vintage.user.UserList;

import static org.junit.Assert.assertEquals;

public class ListHolderTest {
    @Test
    public void ListHolderTest(){
        ListHolder.init();

        UserList users = vintage.others.ListHolder.getUsers();
        User user = new User();
        User seller = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");
        users.addUser(user);

        ItemListings items = vintage.others.ListHolder.getItems();
        Bag bag = new Bag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(1000));
        bag.setOwners(0);
        bag.setSize(10);
        bag.setMaterial("Cotton");
        bag.setRelease(2018);
        items.addItem(bag.getId(), bag);

        OrderListings orders = vintage.others.ListHolder.getOrders();
        Order order = new Order(user);
        order.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        orders.addOrder(user.getId(), order);

        assertEquals(true, ListHolder.getUsers().checkUser("johndoe@mail.com"));
        assertEquals(1, ListHolder.getOrders().getAllOrders().size());
        assertEquals(1, ListHolder.getItems().getAllItems().size());

        ListHolder.getUsers().deleteUser("johndoe@mail.com");
        assertEquals(false, ListHolder.getUsers().checkUser("johndoe@mail.com"));

    }

}

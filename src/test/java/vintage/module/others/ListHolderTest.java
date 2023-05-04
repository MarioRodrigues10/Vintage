package vintage.module.others;

import org.junit.Test;
import vintage.module.item.Bag;
import vintage.module.item.ItemListings;
import vintage.module.order.Order;
import vintage.module.order.OrderListings;

import java.math.BigDecimal;

import vintage.module.user.Address;
import vintage.module.User;
import vintage.module.UserList;

import static org.junit.Assert.assertEquals;

public class ListHolderTest {
    @Test
    public void ListHolderTest(){
        ListHolder.init();

        UserList users = vintage.module.others.ListHolder.getUsers();
        User user = new User();
        User seller = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");
        users.addUser(user);

        ItemListings items = vintage.module.others.ListHolder.getItems();
        Bag bag = new Bag();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setPrice(BigDecimal.valueOf(1000));
        bag.setOwners(0);
        bag.setSize(10);
        bag.setMaterial("Cotton");
        bag.setRelease(2018);
        items.addItem(bag.getId(), bag);

        OrderListings orders = vintage.module.others.ListHolder.getOrders();
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

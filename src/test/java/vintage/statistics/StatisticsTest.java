package vintage.statistics;

import vintage.item.Bag;
import vintage.item.Shoes;
import vintage.item.TShirt;
import vintage.order.Order;
import vintage.user.Address;
import vintage.user.User;
import vintage.order.OrderListings;
import vintage.item.Item;
import vintage.receipt.Receipt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static vintage.others.Statistics.biggestBuyersByProducts;

public class StatisticsTest {

    @Test
    public void testBiggestBuyersByProducts() {
        // create test users
        User user1 = new User();
        user1.setName("Alice");
        user1.setEmail("alice@example.com");
        user1.setResidence(new Address("USA", "New York", "123 Main St", "10001"));
        user1.setTaxNumber("12394934983948");

        User user2 = new User();
        user2.setName("Bob");
        user2.setEmail("bob@example.com");
        user2.setResidence(new Address("USA", "Los Angeles", "456 Avenue", "90001"));
        user2.setTaxNumber("987654321");

        User user3 = new User();
        user3.setName("Charlie");
        user3.setEmail("charlie@example.com");
        user3.setResidence(new Address("USA","Chicago","789 Street", "68582"));
        user3.setTaxNumber("19291291829");


        Item item1 = new Bag();
        item1.setOwner(user1);
        item1.setBrand("Brand 1");
        item1.setDescription("Item 1");
        item1.setEvaluation(7);
        item1.setPrice(BigDecimal.valueOf(50.0));
        item1.setOwners(0);

        Item item2 = new Shoes();
        item2.setOwner(user1);
        item2.setDescription("Item 2");
        item2.setBrand("Brand 2");
        item2.setEvaluation(7);
        item2.setPrice(BigDecimal.valueOf(25.0));


        Item item3 = new TShirt();
        item3.setOwner(user2);
        item3.setDescription("Item3");
        item3.setBrand("Brand 3");
        item3.setEvaluation(9);
        item3.setPrice(BigDecimal.valueOf(100.0));

        Item item4 = new Bag();
        item4.setOwner(user1);
        item4.setBrand("Brand 1");
        item4.setDescription("Item 1");
        item4.setEvaluation(7);
        item4.setPrice(BigDecimal.valueOf(50.0));
        item4.setOwners(0);

        Item item5= new Bag();
        item5.setOwner(user1);
        item5.setBrand("Brand 1");
        item5.setDescription("Item 1");
        item5.setEvaluation(7);
        item5.setPrice(BigDecimal.valueOf(50.0));
        item5.setOwners(0);


        Order order1 = new Order();
        order1.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order1.setPrice(BigDecimal.valueOf(100));
        order1.setBuyer(user3);
        order1.addItem(item1);

        Order order2 = new Order();
        order2.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order2.setPrice(BigDecimal.valueOf(100));
        order2.setBuyer(user1);
        order2.addItem(item2);
        order2.addItem(item3);

        Order order3 = new Order();
        order3.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order3.setPrice(BigDecimal.valueOf(100));
        order3.setBuyer(user1);
        order3.addItem(item3);

        Receipt receipt1 = new Receipt(Receipt.Type.PURCHASE, user3, BigDecimal.valueOf(100.0), new ArrayList<Item>(), LocalDate.now());
        receipt1.getItems().add(item1);

        Receipt receipt2= new Receipt(Receipt.Type.PURCHASE, user1, BigDecimal.valueOf(200.0), new ArrayList<Item>(), LocalDate.now());
        receipt2.getItems().add(item2);
        receipt2.getItems().add(item3);

        user1.getPurchaseReceipts().add(receipt2);
        user3.getPurchaseReceipts().add(receipt1);

        // test biggestBuyersByProducts method
        ArrayList<User> result = biggestBuyersByProducts();
        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
    }

}

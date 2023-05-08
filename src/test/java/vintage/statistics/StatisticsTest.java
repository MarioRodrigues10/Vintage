package vintage.statistics;

import vintage.module.item.Bag;
import vintage.module.item.Shoes;
import vintage.module.item.TShirt;
import vintage.module.item.carrier.Carrier;
import vintage.module.order.Order;
import vintage.module.order.receipt.Receipt;
import vintage.module.order.receipt.SellerReceipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.item.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import vintage.module.user.UserListings;

import static org.junit.Assert.assertEquals;
import static vintage.module.others.Statistics.*;

public class StatisticsTest {

    @Test
    public void testBiggestBuyersByProducts() {
        // create empty receipts
        ArrayList<Receipt> receipts1 = new ArrayList<Receipt>();
        ArrayList<Receipt> receipts2 = new ArrayList<Receipt>();
        ArrayList<Receipt> receipts3 = new ArrayList<Receipt>();

        // create empty items
        ArrayList<Item> items1 = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();
        ArrayList<Item> items3 = new ArrayList<Item>();

        // create users
        User user1 = new User("Alice","alice@example.com", new Address("USA", "New York", "123 Main St", "10001"),"12394934983948", receipts1, items1);
        User user2 = new User("Bob","bob@example.com",new Address("USA", "Los Angeles", "456 Avenue", "90001"),"987654321", receipts2, items2);
        User user3 = new User("Charlie","charlie@example.com",new Address("USA","Chicago","789 Street", "68582"),"19291291829", receipts3,items3);

        // create carriers
        Carrier carrier1 = new Carrier("Carrier 1", BigDecimal.valueOf(10.0), false,3);
        Carrier carrier2 = new Carrier("Carrier 2", BigDecimal.valueOf(15.0), false,2);
        Carrier carrier3 = new Carrier("Carrier 3", BigDecimal.valueOf(20.0), false,1);

        // create items
        Item item1 = new Bag("Description Brand 1", user1,"Brand 1",7,BigDecimal.valueOf(50.0),0,3, "Material 1", 2023,carrier1);
        Item item2 = new Shoes("Description Brand 2",user1,"Brand 2",7,BigDecimal.valueOf(25.0), 0, 37.5, true, "Color 2", 2023,carrier2);
        Item item3 = new TShirt("Description Brand 3", user2,"Brand 3",9, BigDecimal.valueOf(100.0),0, TShirt.Size.M, TShirt.Pattern.SOLID,carrier3);

        // addItemToOrder, de um user
        Order order_user3 = user3.getPendingOrder();
        order_user3.addItem(item1);
        order_user3.addItem(item2);
        Order order_user1 = user1.getPendingOrder();
        order_user1.addItem(item3);

        order_user1.finishOrder();
        order_user3.finishOrder();
      ;

        UserListings users = UserListings.getInstance();
        users.addUser(user1);
        users.addUser(user2);
        users.addUser(user3);



        List<User> usersBiggestBuyers = new ArrayList<User>();
        usersBiggestBuyers.add(user1);
        usersBiggestBuyers.add(user3);
        assertEquals(usersBiggestBuyers, biggestBuyersByProducts(users));
    }

    @Test
    public void testBiggestSellersByProducts() {
        // create empty receipts
        ArrayList<Receipt> receipts1 = new ArrayList<Receipt>();
        ArrayList<Receipt> receipts2 = new ArrayList<Receipt>();
        ArrayList<Receipt> receipts3 = new ArrayList<Receipt>();

        // create empty items
        ArrayList<Item> items1 = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();
        ArrayList<Item> items3 = new ArrayList<Item>();

        // create users
        User user1 = new User("Alice","alice@example.com", new Address("USA", "New York", "123 Main St", "10001"),"12394934983948", receipts1, items1);
        User user2 = new User("Bob","bob@example.com",new Address("USA", "Los Angeles", "456 Avenue", "90001"),"987654321", receipts2, items2);
        User user3 = new User("Charlie","charlie@example.com",new Address("USA","Chicago","789 Street", "68582"),"19291291829", receipts3,items3);

        // create carriers
        Carrier carrier1 = new Carrier("Carrier 1", BigDecimal.valueOf(10.0), false,3);
        Carrier carrier2 = new Carrier("Carrier 2", BigDecimal.valueOf(15.0), false,2);
        Carrier carrier3 = new Carrier("Carrier 3", BigDecimal.valueOf(20.0), false,1);

        // create items
        Item item1 = new Bag("Description Brand 1", user1,"Brand 1",7,BigDecimal.valueOf(50.0),0,3, "Material 1", 2023,carrier1);
        Item item2 = new Shoes("Description Brand 2",user1,"Brand 2",7,BigDecimal.valueOf(25.0), 0, 37.5, true, "Color 2", 2023,carrier2);
        Item item3 = new TShirt("Description Brand 3", user2,"Brand 3",9, BigDecimal.valueOf(100.0),0, TShirt.Size.M, TShirt.Pattern.SOLID,carrier3);



        Order order1 = new Order(user3);
        order1.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order1.setPrice(BigDecimal.valueOf(100));
        order1.addItem(item1);

        Order order2 = new Order(user1);
        order2.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order2.setPrice(BigDecimal.valueOf(100));
        order2.addItem(item2);

        Order order3 = new Order(user1);
        order3.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order3.setPrice(BigDecimal.valueOf(100));
        order3.addItem(item3);

        Receipt receipt1 = new SellerReceipt(order1);
        Receipt receipt2 = new SellerReceipt(order2);
        Receipt receipt3 = new SellerReceipt(order3);

        ArrayList<Receipt> receiptsUser1 = new ArrayList<Receipt>();
        receiptsUser1.add(receipt2);
        receiptsUser1.add(receipt3);

        ArrayList<Receipt> receiptsUser3 = new ArrayList<Receipt>();
        receiptsUser3.add(receipt1);

        user3.setReceipts(receiptsUser3);
        user1.setReceipts(receiptsUser1);

        UserList users = new UserList();
        users.addUser(user1);
        users.addUser(user3);

        List<User> usersBiggestBuyers = new ArrayList<User>();
        usersBiggestBuyers.add(user1);
        usersBiggestBuyers.add(user3);

        assertEquals(usersBiggestBuyers, biggestSellersByProducts(users));
    }


    @Test
    public void testBiggestSellersByMoney() {
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



        Order order1 = new Order(user3);
        order1.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order1.setPrice(BigDecimal.valueOf(100));
        order1.addItem(item1);

        Order order2 = new Order(user1);
        order2.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order2.setPrice(BigDecimal.valueOf(100));
        order2.addItem(item2);

        Order order3 = new Order(user1);
        order3.setAddress(new Address("123 Main St", "New York", "NY", "10001"));
        order3.setPrice(BigDecimal.valueOf(100));
        order3.addItem(item3);

        Receipt receipt1 = new SellerReceipt(order1);
        Receipt receipt2 = new SellerReceipt(order2);
        Receipt receipt3 = new SellerReceipt(order3);

        ArrayList<Receipt> receiptsUser1 = new ArrayList<Receipt>();
        receiptsUser1.add(receipt2);
        receiptsUser1.add(receipt3);

        ArrayList<Receipt> receiptsUser3 = new ArrayList<Receipt>();
        receiptsUser3.add(receipt1);

        user3.setReceipts(receiptsUser3);
        user1.setReceipts(receiptsUser1);

        UserList users = new UserList();
        users.addUser(user1);
        users.addUser(user2);

        List<User> usersBiggestBuyers = new ArrayList<User>();
        usersBiggestBuyers.add(user1);

        assertEquals(usersBiggestBuyers, biggestSellersByMoney(users));
    }



}

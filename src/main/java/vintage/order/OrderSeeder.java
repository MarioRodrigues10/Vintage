package vintage.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import vintage.item.*;
import vintage.user.*;
import java.util.Random;

public class OrderSeeder {

    public static List<Order> seedOrder(int n) {
        List<Order> orders = new ArrayList<Order>();
        Random random = new Random();
        ItemSeeder itemSeeder = new ItemSeeder();

        for(int i=0; i< n ; i++) {

            User buyer = UserSeeder.seedUsers(1).get(0);
            Order order = new Order(buyer);
            order.setSize(Order.Size.MEDIUM);
            order.setPrice(new BigDecimal("249.97"));
            order.setAddress(new Address("123 Main St", "Anytown", "Anystate", "12345"));
            order.setExpeditionDate(LocalDate.now().plusDays(14));

            Map<Item, Order.State> items = new HashMap<>();

            int numItems = random.nextInt(3,5);
            List<Item> items_generated = itemSeeder.generateItems(numItems);
            for(Item item : items_generated) {
                items.put(item, Order.State.PENDING);
            }
            order.setItems(items);
            orders.add(order);
        }

        return orders;
    }
}

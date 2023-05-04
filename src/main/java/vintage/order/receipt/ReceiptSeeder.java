package vintage.order.receipt;

import vintage.item.*;
import vintage.order.Order;
import vintage.order.OrderSeeder;
import vintage.user.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceiptSeeder {

    /**
     * Generates seed data for a list of buyer receipts
     * @param n the number of receipts to generate
     * @return a list of buyer receipts
     */
    public static List<BuyerReceipt> generateBuyerReceipts(int n) {
        List<BuyerReceipt> receipts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<User> sellers = UserSeeder.seedUsers(3);
            BigDecimal totalPrice = BigDecimal.valueOf(Math.random() * 1000);
            ItemSeeder itemSeeder = new ItemSeeder();
            OrderSeeder orderSeeder = new OrderSeeder();
            User buyer = UserSeeder.seedUsers(1).get(0);
            Order order = orderSeeder.seedOrder(1).get(0);
            List<Item> items = itemSeeder.generateItems(3);
            LocalDate emissionDate = LocalDate.now();
            BuyerReceipt receipt = new BuyerReceipt(sellers, totalPrice, items,  emissionDate, order);
            receipts.add(receipt);
        }
        return receipts;
    }

    /**
     * Generates seed data for a list of seller receipts
     * @param n the number of receipts to generate
     * @return a list of seller receipts
     */
    public static List<SellerReceipt> generateSellerReceipts(int n) {
        List<SellerReceipt> receipts = new ArrayList<>();
        UserSeeder userSeeder = new UserSeeder();
        ItemSeeder itemSeeder = new ItemSeeder();
        OrderSeeder orderSeeder = new OrderSeeder();

        for (int i = 0; i < n; i++) {

            User buyer = userSeeder.seedUsers(1).get(0);
            BigDecimal totalPrice = BigDecimal.valueOf(Math.random() * 1000);

            List<Item> items = itemSeeder.generateItems(3);

            Order order = orderSeeder.seedOrder(1).get(0);

            LocalDate emissionDate = LocalDate.now();
            SellerReceipt receipt = new SellerReceipt(buyer, totalPrice, items, emissionDate, order);

            receipts.add(receipt);
        }
        return receipts;
    }
}

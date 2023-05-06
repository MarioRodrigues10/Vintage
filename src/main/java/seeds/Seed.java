package seeds;

import java.util.List;

import vintage.item.carrier.Carrier;
import vintage.order.receipt.BuyerReceipt;
import vintage.order.receipt.SellerReceipt;
import vintage.order.Order;
import vintage.item.Item;
import vintage.user.User;

public class Seed {

    public static void main(String[] args) {
        ItemSeeder itemSeeder = new ItemSeeder();
        List<User> users = UserSeeder.seedUsers(5);
        List<Carrier> carriers = CarrierSeeder.seedCarriers(5);
        List<Item> items = itemSeeder.generateItems(5);
        List<Order> orders = OrderSeeder.seedOrder(5);
        List<BuyerReceipt> buyerReceipts = ReceiptSeeder.generateBuyerReceipts(5);
        List<SellerReceipt> sellerReceipts = ReceiptSeeder.generateSellerReceipts(5);

        System.out.println("Seed data generated successfully!");
    }
}

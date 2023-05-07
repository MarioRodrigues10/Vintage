package seeds;

import java.util.List;

import vintage.module.item.carrier.Carrier;
import vintage.module.order.receipt.BuyerReceipt;
import vintage.module.order.receipt.SellerReceipt;
import vintage.module.order.Order;
import vintage.module.item.Item;
import vintage.module.user.User;

public class Seed {

    public static void main(String[] args) {
        ItemSeeder itemSeeder = new ItemSeeder();
        List<Carrier> carriers = CarrierSeeder.seedCarriers(5);
        List<Item> items = itemSeeder.generateItems(5);
        List<Order> orders = OrderSeeder.seedOrder(5);
        List<BuyerReceipt> buyerReceipts = ReceiptSeeder.generateBuyerReceipts(5);
        List<SellerReceipt> sellerReceipts = ReceiptSeeder.generateSellerReceipts(5);

        System.out.println("Seed data generated successfully!");
    }
}

package seeds;

import java.util.ArrayList;
import java.util.List;

import seeds.ReceiptSeeder;
import vintage.module.order.receipt.*;
import vintage.module.others.Address;
import vintage.module.user.User;
public class UserSeeder{

    public static List<User> seedUsers(int numUsers) {
        List<User> users = new ArrayList<>();
        ArrayList<Receipt> receipts = new ArrayList<>();
        for (int i = 0; i < numUsers; i++) {
            User user = new User("User " + i, "user" + i + "@example.com", new Address("123 Main St", "Anytown", "Anystate", "12345"), "123-45-6789", receipts);
            ReceiptSeeder receiptSeeder = new ReceiptSeeder();
            List<BuyerReceipt> buyerReceipts = receiptSeeder.generateBuyerReceipts(3);
            List<SellerReceipt> sellerReceipts = receiptSeeder.generateSellerReceipts(3);
            users.add(user);
        }
        return users;
    }
}

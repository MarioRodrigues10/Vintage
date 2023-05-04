package vintage.user;

import java.util.ArrayList;
import java.util.List;
import vintage.order.receipt.*;
public class UserSeeder{

    public static List<User> seedUsers(int numUsers) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numUsers; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setEmail("user" + i + "@example.com");
            user.setResidence(new Address("123 Main St", "Anytown", "Anystate", "12345"));
            user.setTaxNumber("123-45-6789");
            ReceiptSeeder receiptSeeder = new ReceiptSeeder();
            List<BuyerReceipt> buyerReceipts = receiptSeeder.generateBuyerReceipts(3);
            List<SellerReceipt> sellerReceipts = receiptSeeder.generateSellerReceipts(3);
            users.add(user);
        }
        return users;
    }
}

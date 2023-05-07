package seeds;

import java.util.ArrayList;
import java.util.List;

import seeds.ReceiptSeeder;
import vintage.module.order.receipt.*;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;

public class UserSeeder{

    public static List<User> seedUsers(int numUsers) {
        List<User> users = new ArrayList<>();
        ArrayList<Receipt> receipts = new ArrayList<>();
        UserListings userListings = new UserListings();
        for (int i = 0; i < numUsers; i++) {
            List<BuyerReceipt> buyerReceipts = ReceiptSeeder.generateBuyerReceipts(3);
            List<SellerReceipt> sellerReceipts = ReceiptSeeder.generateSellerReceipts(3);
            receipts.addAll(buyerReceipts);
            receipts.addAll(sellerReceipts);
            User user = new User("User " + i, "user" + i + "@example.com", new Address("123 Main St", "Anytown", "Anystate", "12345"), "123-45-6789", receipts);
            users.add(user);
            userListings.addUser(user);
        }
        return users;
    }
}

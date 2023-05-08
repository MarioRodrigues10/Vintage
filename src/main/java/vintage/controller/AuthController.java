package vintage.controller;

import vintage.module.item.Item;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.AuthView;

import java.util.ArrayList;
import java.util.Map;

public class AuthController {
    public static void login() {
        Map<String, String> userMap = AuthView.login();

        User user = UserListings.getInstance().getUser(userMap.get("email"));

        UserController.menu(user);
    }

    public static void signUp() {
        Map <String, String> userMap = AuthView.signUp();

        User user = registerUser(userMap);

        UserController.menu(user);
    }

    private static User registerUser(Map<String, String> user) {
        if (UserListings.getInstance().checkUser(user.get("email"))) return null;

        Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        ArrayList<Item> items = new ArrayList<Item>();

        User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts, items);
        UserListings.getInstance().addUser(newUser);

        return newUser;
    }
}

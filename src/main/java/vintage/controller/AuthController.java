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
    private static AuthController instance = null;

    public static AuthController getInstance() {
        if (instance == null) {
            instance = new AuthController();
        }
        return instance;
    }

    public void login() {
        Map<String, String> userMap = AuthView.getInstance().login();

        User user = UserListings.getInstance().getUser(userMap.get("email"));

        UserController.getInstance().menu(user);
    }

    public void signUp() {
        Map <String, String> userMap = AuthView.getInstance().signUp();

        User user = registerUser(userMap);

        UserController.getInstance().menu(user);
    }

    private User registerUser(Map<String, String> user) {
        if (UserListings.getInstance().checkUser(user.get("email"))) return null;

        Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        ArrayList<Item> items = new ArrayList<Item>();

        User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts, items);
        UserListings.getInstance().addUser(newUser);

        return newUser;
    }
}

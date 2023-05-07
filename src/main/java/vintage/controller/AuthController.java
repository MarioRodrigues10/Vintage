package vintage.controller;

import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.view.AuthView;

import java.util.ArrayList;
import java.util.Map;

public class AuthController {

    public static User loginController() {
        Map<String, String> user = AuthView.loginMenu();

        return UserListings.getInstance().getUser("email");
    }

    public static User signUpController() {
        Map<String, String> user = AuthView.signUpMenu();

        if (UserListings.getInstance().checkUser("email")) return null;
        Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();

        User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts);
        UserListings.getInstance().addUser(newUser);

        return newUser;
    }

    public static User authMenuController() {
        User user;
        Integer option = AuthView.authMenu();

        if (option == 1) {
            user = loginController();
        }
        else {
            user = signUpController();
        }
        return user;
    }
}

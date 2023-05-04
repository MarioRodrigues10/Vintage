package vintage.controller;

import vintage.module.User;
import vintage.module.UserList;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.ListHolder;
import vintage.module.user.Address;
import vintage.view.AuthView;

import java.util.ArrayList;
import java.util.Map;

public class AuthController {

    public static User loginController() {
        Map<String, String> user = AuthView.loginMenu();

        return ListHolder.getUsers().getUser("email");
    }

    public static User signUpController() {
        Map<String, String> user = AuthView.signUpMenu();

        if (ListHolder.getUsers().checkUser("email")) return null;
        Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();

        User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts);
        ListHolder.getUsers().addUser(newUser);

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

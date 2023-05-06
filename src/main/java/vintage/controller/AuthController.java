package vintage.controller;

import vintage.module.user.User;
import vintage.module.user.UserHolder;
import vintage.module.user.UserListings;
import vintage.view.AuthView;

import java.util.Map;

public class AuthController {

    public static User loginController() {
        Map<String, String> user = AuthView.loginMenu();

        User newUser = UserListings.getInstance().getUser("email");
        UserHolder.setUser(newUser);

        return newUser;
    }

    public static User signUpController() {
        Map<String, String> user = AuthView.signUpMenu();

        User newUser = UserController.registerUser(user);
        UserHolder.setUser(newUser);

        return newUser;
    }

    public static User init() {
        User user;
        Integer option = AuthView.menu();

        if (option == 1) {
            user = loginController();
        }
        else {
            user = signUpController();
        }
        return user;
    }
}

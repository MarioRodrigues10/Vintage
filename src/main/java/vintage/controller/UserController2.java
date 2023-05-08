package vintage.controller;

import vintage.module.user.User;
import vintage.view.UserView2;

public class UserController2 {
    public static void menu(User user) {
        int option = UserView2.menu();

        switch (option) {
            case 1:
                ItemController.marketplace(user);
                break;
            case 2:
                // TODO: my cart
                break;
            case 3:
                ItemController.userItems(user);
                break;
            case 4:
                ReceiptsController.userReceipts(user);
                break;
            case 5:
                MenuController.menu();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}

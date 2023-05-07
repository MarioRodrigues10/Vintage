package vintage.controller;

import vintage.Main;
import vintage.module.user.User;
import vintage.view.MainMenuView;
import vintage.view.UserView;

public class MainMenuController {

    public static void init(User user) {
        Integer option = MainMenuView.menu();

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                UserController.showUserItems(user);
                break;
            case 4:
                UserController.showUserReceipts(user);
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}

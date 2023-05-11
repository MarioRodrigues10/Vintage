package vintage.controller;

import vintage.module.user.User;
import vintage.view.UserView;

public class UserController {
    private static UserController instance = null;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void menu(User user) {
        int option = UserView.getInstance().menu();

        switch (option) {
            case 1:
                ItemController.getInstance().marketplace(user);
                break;
            case 2:
                OrderController.getInstance().userPendingOrder(user);
                break;
            case 3:
                ItemController.getInstance().userItems(user);
                break;
            case 4:
                ReceiptsController.getInstance().userReceipts(user);
                break;
            case 5:
                MenuController.getInstance().menu();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}

package vintage.controller;

import vintage.module.item.Item;
import vintage.module.order.Order;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.ItemView;
import vintage.view.UserView;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class UserController {
    public static void menu(User user) {
        int option = UserView.menu();

        switch (option) {
            case 1:
                ItemController.marketplace(user);
                break;
            case 2:
                OrderController.userPendingOrder(user);
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

    public static void listUsers() {
        Map<String, User> usersMap = UserListings.getInstance().getUsers();
        List<String> userString = new ArrayList<String>();

        for (Map.Entry<String, User> user : usersMap.entrySet()) userString.add(user.toString());

        UserView.listUsers(userString);

        AdminController.menu();
    }
}

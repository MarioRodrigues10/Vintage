package vintage.controller;

import java.util.List;

import vintage.module.order.Order;
import vintage.module.order.OrderListings;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.MainMenuView;
import vintage.view.Util;

public class MainMenuController {

    public static void init(User user) {
        Integer option = MainMenuView.menu();

        switch (option) {
            case 1:
                buyItems(user);
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

    public static void buyItems(User user) {
        /*Filters the Items depending on the category selected*/
        Integer option = MainMenuView.itemCategories();
        List<String> items = UserController.getItemStringsByCategory(UserListings.getInstance().getUsers(), option);

        Integer pageNumber = 1;
        while (pageNumber != 0) {
            /*Displays the items and selects the option*/
            Integer itemOption = MainMenuView.buyItems(Util.getPage(items, pageNumber), pageNumber);

            Order order = OrderListings.getInstance().getUserPendingOrder(user);

            /*Depending on the option, the user can buy an item, go to the next page or go back*/
            if (itemOption < 6) {
                /*Buys the selected item*/
                order.addItem(UserListings.getInstance().getAllItems().get(itemOption - 1 + (pageNumber-1)*5));
                pageNumber = 0;
            }
            else if (itemOption == 6) pageNumber--;
            else {
                /*Handles the exception to having no items*/
                if (items.size()==0) pageNumber = 1;
                else{
                    pageNumber++;
                    /*Handles the situation where it its the last page*/
                    if (pageNumber > Math.ceil(items.size() / 5)) pageNumber = (int) Math.ceil(items.size() / 5);
                }
            }
        }
    }
}

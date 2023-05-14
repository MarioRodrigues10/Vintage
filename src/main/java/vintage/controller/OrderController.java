package vintage.controller;

import vintage.module.item.Item;
import vintage.module.order.Order;
import vintage.module.order.OrderListings;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.OrderView;
import vintage.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderController {
    public static void userPendingOrder(User user) {
        Order pendingOrder = user.getPendingOrder();
        List<Item> items = pendingOrder.getItemsList();
        List<String> itemStrings = new ArrayList<String>();

        for (Item item : items) {
            itemStrings.add(item.toString());
        }

        int option = OrderView.displayUserPendingOrder(itemStrings);

        if (option == 1) {
            if (items.size() == 0) {
                OrderView.noItemsErros();
                userPendingOrder(user);
            }

            pendingOrder.finishOrder();
            ReceiptsController.userReceipts(user);
        }
        else if (option == 2) {
            if (items.size() == 0) {
                OrderView.noItemsErros();
                userPendingOrder(user);
            }

            UUID itemId = UUID.fromString(OrderView.deletePendingOrderItem());
            pendingOrder.removeItemById(itemId);
            userPendingOrder(user);
        }
        else {
            UserController.menu(user);
        }
    }

    public static void listOrders() {
        List<Order> ordersList = OrderListings.getInstance().getAllOrders();
        List<String> orderString = new ArrayList<String>();

        for (Order order : ordersList) orderString.add(order.toString());

        OrderView.listOrders(orderString);

        AdminController.menu();
    }
}

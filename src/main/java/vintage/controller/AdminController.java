package vintage.controller;

import vintage.view.AdminView;

public class AdminController {

    public static void menu() {
        int option = AdminView.menu();

        switch (option) {
            case 1:
                TimeController.jumpTime();
                break;
            case 2:
                UserController.listUsers();
            case 3:
                OrderController.listOrders();
                break;
            case 4:
                CarrierController.menu();
                break;
            case 5:
                SerializationController.save();
                break;
            case 6:
                SerializationController.load();
                break;
            case 7:
                StatisticsController.menu();
                break;
            case 8:
                MenuController.menu();
                break;
        }
    }
}

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
                CarrierController.menu();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                MenuController.menu();
                break;
        }
    }
}

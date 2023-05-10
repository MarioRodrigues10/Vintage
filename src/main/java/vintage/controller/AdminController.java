package vintage.controller;

import vintage.view.AdminView;

public class AdminController {
    private static AdminController instance = null;

    public static AdminController getInstance() {
        if (instance == null) {
            instance = new AdminController();
        }
        return instance;
    }

    public void menu() {
        int option = AdminView.getInstance().menu();

        switch (option) {
            case 1:
                TimeController.getInstance().jumpTime();
                break;
            case 2:
                CarrierController.getInstance().menu();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                MenuController.getInstance().menu();
                break;
        }
    }
}

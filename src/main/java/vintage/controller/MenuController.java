package vintage.controller;

import vintage.view.MenuView;

public class MenuController {
    private static MenuController instance = null;

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }

    public void menu() {
        int option = MenuView.getInstance().menu();

        switch (option) {
            case 1:
                AuthController.getInstance().login();
                break;
            case 2:
                AuthController.getInstance().signUp();
                break;
            case 3:
                break;
        }
    }
}

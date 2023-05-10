package vintage.controller;

import vintage.view.MenuView;

public class MenuController {
    public static void menu() {
        int option = MenuView.menu();

        switch (option) {
            case 1:
                AuthController.login();
                break;
            case 2:
                AuthController.signUp();
                break;
            case 3:
                AdminController.menu();
                break;
            case 4:
                System.exit(0);
        }
    }
}

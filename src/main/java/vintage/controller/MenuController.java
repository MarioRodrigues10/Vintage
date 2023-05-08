package vintage.controller;

import vintage.view.MenuView;

public class MenuController {
    public static void menu() {
        int option = MenuView.menu();

        switch (option) {
            case 1:
                AuthController2.login();
                break;
            case 2:
                AuthController2.signUp();
                break;
            case 3:
                break;
        }
    }
}

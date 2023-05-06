package vintage.controller;

import vintage.Main;
import vintage.view.MainMenuView;

public class MainMenuController {

    public static void init() {
        Integer option = MainMenuView.menu();

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}

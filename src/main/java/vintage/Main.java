package vintage;

import vintage.controller.MenuController;
import vintage.module.user.User;
import vintage.module.user.UserHolder;
import vintage.view.MenuView;

import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) {
        //User user = vintage.controller.AuthController.init();

        //while (true) {
            //vintage.view.Util.clearScreen();
            //vintage.controller.MainMenuController.init(user);
            // save changes
        //}
        MenuController.getInstance().menu();
    }
}
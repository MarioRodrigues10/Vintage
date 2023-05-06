package vintage;

import vintage.module.user.User;
import vintage.module.user.UserHolder;

import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) {
        User user = vintage.controller.AuthController.init();

        while (true) {
            vintage.view.Util.clearScreen();
            vintage.controller.MainMenuController.init();
            // save changes
        }
    }
}
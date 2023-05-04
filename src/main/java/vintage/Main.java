package vintage;

import vintage.controller.*;
import vintage.module.User;

public class Main {
    public static void main(String[] args) {
        vintage.module.others.ListHolder.init();

        User user = AuthController.authMenuController();
    }
}
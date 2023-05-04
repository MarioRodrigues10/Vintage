package vintage;

import vintage.controller.*;
import vintage.module.User;
import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) {
        vintage.module.others.ListHolder.init();

        User user = AuthController.authMenuController();
    }
}
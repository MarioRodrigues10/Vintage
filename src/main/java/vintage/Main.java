package vintage;

import vintage.controller.*;
import vintage.module.user.User;
import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) {
        User user = AuthController.authMenuController();
    }
}
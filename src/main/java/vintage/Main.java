package vintage;

import vintage.view.*;
import vintage.module.User;
import vintage.module.user.User;

public class Main {
    public static void main(String[] args) {
        vintage.module.others.ListHolder.init();

        User user = Auth.authMenu();
    }
}
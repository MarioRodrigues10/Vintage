package vintage;

import vintage.frontend.*;
import vintage.user.User;

public class Main {
    public static void main(String[] args) {
        vintage.others.ListHolder.init();

        User user = Auth.authMenu();
    }
}
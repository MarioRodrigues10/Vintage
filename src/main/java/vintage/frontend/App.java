package vintage.frontend;

import vintage.user.User;

public class App {

    public static void main(String[] args) {

        vintage.others.ListHolder.init();

        User user = Auth.authMenu();

    }



}

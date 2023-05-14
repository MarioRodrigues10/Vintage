package vintage.view;

import java.util.List;

import vintage.view.Util;

public class UserView {

    public static Integer menu() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nMENU\n");
        Util.println  ("[1] Buy Items");
        Util.println  ("[2] My Cart");
        Util.println  ("[3] My Items");
        Util.println  ("[4] My Receipts");
        Util.println  ("[5] Logout");
        Util.println  ("[6] Exit\n");

        Integer option = Util.inputOption(6);

        return option;
    }

    public static void listUsers(List<String> userStrings) {
        int pageNumber = 1, option = 1;
        while (option > 0) {
            Util.clearScreen();
            Util.printHeader();
            Util.println("\nList of Users:\n");

            List<String> currentUsers = Util.getPage(userStrings, pageNumber);

            Util.println("====================================");
            for(String user : currentUsers) {
                Util.println(user);
                Util.println("====================================");
            }

            Util.println("\n[1] <-");
            Util.println  ("[2] ->");
            Util.println  ("[3] Back");

            option = Util.inputOption(3);

            if (option == 1 && pageNumber > 1) {
                pageNumber--;
            } else if (option == 1 && userStrings.size() > pageNumber * 5) {
                pageNumber++;
            }
            else if (option == 3){
                break;
            }
        }
    }
}

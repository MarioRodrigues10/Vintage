package vintage.view;

public class MainMenuView {

    public static Integer menu() {
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
}

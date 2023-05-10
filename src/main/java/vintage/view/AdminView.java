package vintage.view;

public class AdminView {
    private static AdminView instance = null;

    public static AdminView getInstance() {
        if (instance == null) {
            instance = new AdminView();
        }
        return instance;
    }

    public Integer menu() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nADMIN MENU\n");
        Util.println  ("[1] Jump in Time");
        Util.println  ("[2] Carriers");
        Util.println  ("[3] Save Program");
        Util.println  ("[4] Load Program");
        Util.println  ("[5] Back\n");

        Integer option = Util.inputOption(5);

        return option;
    }
}

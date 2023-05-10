package vintage.view;

public class AdminView {

    public static Integer menu() {
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

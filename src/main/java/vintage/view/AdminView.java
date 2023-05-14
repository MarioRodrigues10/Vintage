package vintage.view;

public class AdminView {

    public static Integer menu() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nADMIN MENU\n");
        Util.println  ("[1] Jump in Time");
        Util.println  ("[2] List of Users");
        Util.println  ("[3] List of Orders");
        Util.println  ("[4] Carriers");
        Util.println  ("[5] Save Program");
        Util.println  ("[6] Load Program");
        Util.println  ("[7] Statistics");
        Util.println  ("[8] Back\n");

        Integer option = Util.inputOption(7);

        return option;
    }
}

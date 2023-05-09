package vintage.view;

public class MenuView {
    public static int menu () {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\n[1] LOGIN");
        Util.println("[2] SIGNUP");
        Util.println("[3] ADMIN");
        Util.println("[4] Exit");

        return Util.inputOption(4);
    }
}

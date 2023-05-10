package vintage.view;

public class MenuView {
    private static MenuView instance = null;
    public static MenuView getInstance() {
        if (instance == null) {
            instance = new MenuView();
        }
        return instance;
    }

    public int menu () {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\n[1] LOGIN");
        Util.println("[2] SIGNUP");
        Util.println("[3] ADMIN");

        return Util.inputOption(3);
    }
}

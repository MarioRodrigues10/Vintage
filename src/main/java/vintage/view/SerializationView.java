package vintage.view;

public class SerializationView {

    public static String save() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nSave Program");

        Util.println("\nSaving in this program works by saving three files (Users, Orders and Carriers) in a folder with a name of your choice (The folder needs to exist).");

        String folderName = Util.input("\nIndicate the name of the folder you want to save this program state: ");

        return folderName;
    }

    public static void saved() {
        Util.println("\nProgram saved successfully!");
        Util.input("Press enter to go back");
    }

    public static String load() {
        Util.clearScreen();
        Util.printHeader();

        Util.println("\nLoad Program");

        Util.println("\nLoading in this program works by loading three files (Users, Orders and Carriers) from a folder with a name of your choice.");

        String folderName = Util.input("\nIndicate the name of the folder with the program state you want to load: ");

        return folderName;
    }

    public static void loaded() {
        Util.println("\nProgram loaded successfully!");
        Util.input("Press enter to go back");
    }
}

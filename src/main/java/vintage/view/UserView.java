package vintage.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserView {
    public static void showReceipts(List<String> receiptStrings) {
        Util.clearScreen();
        Util.printHeader();
        System.out.println("Your receipts are: ");
        System.out.println("====================================");
        for (String receiptString : receiptStrings) {
            System.out.println(receiptString);
            System.out.println("====================================");
        }
        Util.input("Press enter to go back to main menu.");
    }

    public static int showItems(List<String> itemStrings) {
        printItemsList(itemStrings);

        System.out.println("[1] Add new item for sale");
        System.out.println("[2] Remove item");
        System.out.println("[3] Go back");

        return Util.inputOption(3);
    }

    public static String deleteItem() {
        return Util.input("Enter item id to delete: ");
    }

    private static void printItemsList(List<String> itemStrings) {
        Util.clearScreen();
        Util.printHeader();
        System.out.println("Your items are: ");
        System.out.println("====================================");
        for (String itemString : itemStrings) {
            System.out.println(itemString);
            System.out.println("====================================");
        }
    }

    public static Map<String, String> createUserItem() {
        Util.clearScreen();
        Util.printHeader();

        System.out.println("What type of item do you want to create?");
        System.out.println("[1] T-Shirt");
        System.out.println("[2] Bag");
        System.out.println("[3] Shoes");
        int type = Util.inputOption(3);

        if (type == 1) {
            return createTShirt();
        }
        else if (type == 2) {
            return createBag();
        }
        else {
            return createShoes();
        }
    }

    private static Map<String, String> createTShirt() {
        Map<String, String> newItem = new HashMap<String, String>();

        newItem.put("type", "tshirt");
        newItem.put("brand", Util.input("Brand: "));
        newItem.put("description", Util.input("Description: "));
        newItem.put("owners", Util.input("Number of previous owners: "));
        newItem.put("size", Util.inputSize());
        newItem.put("color", Util.input("Color: "));
        newItem.put("price", Util.inputPrice());
        newItem.put("evaluation", Util.inputEvaluation());
        newItem.put("pattern", Util.input("Pattern [solid/stripped/palm]: "));

        return newItem;
    }

    private static Map<String, String> createBag() {
        Map<String, String> newItem = new HashMap<String, String>();

        newItem.put("type", "bag");
        newItem.put("brand", Util.input("Brand: "));
        newItem.put("description", Util.input("Description: "));
        newItem.put("owners", Util.input("Number of previous owners: "));
        newItem.put("size", Util.input("Size: "));
        newItem.put("price", Util.inputPrice());
        newItem.put("evaluation", Util.inputEvaluation());
        newItem.put("material", Util.input("Material: "));
        newItem.put("release", Util.input("Release year: "));

        return newItem;
    }

    private static Map<String, String> createShoes() {
        Map<String, String> newItem = new HashMap<String, String>();

        newItem.put("type", "shoes");
        newItem.put("brand", Util.input("Brand: "));
        newItem.put("description", Util.input("Description: "));
        newItem.put("owners", Util.input("Number of previous owners: "));
        newItem.put("size", Util.input("Size: "));
        newItem.put("color", Util.input("Color: "));
        newItem.put("price", Util.inputPrice());
        newItem.put("evaluation", Util.inputEvaluation());
        newItem.put("laces", Util.inputLaces());
        newItem.put("release", Util.input("Realease year: "));

        return newItem;
    }
}

package vintage.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemView {
    private static ItemView instance = null;

    public static ItemView getInstance() {
        if (instance == null) {
            instance = new ItemView();
        }
        return instance;
    }

    public int marketplace(List<String> itemStrings) {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nMarketplace");

        int pageNumber = 1;
        int option = buyItems(itemStrings, pageNumber);

        while (option > 5) {
            if (option == 6 && pageNumber > 1) {
                pageNumber--;
            } else if (option == 7 && itemStrings.size() > pageNumber * 5) {
                pageNumber++;
            }
            else if (option == 8){
                return -1;
            }

            option = buyItems(itemStrings, pageNumber);
        }

        return pageNumber * 5 - 5 + option;
    }

    public int displayUserItems(List<String> itemStrings) {
        Util.clearScreen();
        Util.printHeader();
        System.out.println("\nYour items: ");
        System.out.println("====================================");
        for (String itemString : itemStrings) {
            System.out.println(itemString);
            System.out.println("====================================");
        }
        Util.println("[1] Create Item");
        Util.println("[2] Delete Item");
        Util.println("[3] Back");

        return Util.inputOption(3);
    }


    public Integer buyItems(List<String> items, Integer pageNumber) {
        Integer i = 1;
        for(String item : items){
            Util.print("[" + i + "] " + items.get(i-1));
            System.out.println("\n====================================");
            i++;
        }
        Util.println("[6] <-");
        Util.println("[7] ->");
        Util.println("[8] Back");
        Integer option = Util.inputOption(8);
        return option;
    }

    public String deleteUserItem() {
        return Util.input("Enter item id to delete: ");
    }

    public Map<String, String> createUserItem() {
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

    private Map<String, String> createTShirt() {
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

    private Map<String, String> createBag() {
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

    private Map<String, String> createShoes() {
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

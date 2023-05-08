package vintage.view.trash;

import vintage.view.Util;

import java.util.List;

public class MainMenuView {

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

    public static Integer itemCategories() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nItem Categories\n");
        Util.println  ("[1] T-Shits");
        Util.println  ("[2] Shoes");
        Util.println  ("[3] Bags");
        Util.println  ("[4] Exit\n");

        Integer option = Util.inputOption(4);

        return option;
    }

    public static Integer buyItems(List<String> items, Integer pageNumber) {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nBuy Item");
        Integer i = 1;
        for(String item : items){
            Util.print("[" + i + "] " + items.get(i-1));
            System.out.println("\n====================================");
            i++;
        }
        Util.println("[6] Back");
        Util.println("[7] Next");
        Integer option = Util.inputOption(7);
        return option;
    }

}

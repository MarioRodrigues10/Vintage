package vintage.view;

import java.util.List;

public class OrderView {
    private static OrderView instance = null;

    public static OrderView getInstance() {
        if (instance == null) {
            instance = new OrderView();
        }
        return instance;
    }

    public int displayUserPendingOrder(List<String> itemStrings) {
        Util.clearScreen();
        Util.printHeader();

        System.out.println("\nYour pending order:");
        System.out.println("====================================");
        for (String itemString : itemStrings) {
            System.out.println(itemString);
            System.out.println("====================================");
        }

        System.out.println("\n[1] Finish Order");
        System.out.println("[2] Remove Item");
        System.out.println("[3] Back");

        return Util.inputOption(3);
    }

    public String deletePendingOrderItem() {
        return Util.input("Enter item id to delete: ");
    }

    public void noItemsErros() {
        System.out.println("You have no items in your pending order.");
        Util.input("Press enter.");
    }
}

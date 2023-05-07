package vintage.view;

import java.util.List;

public class UserView {
    public static void showReceipts(List<String> receiptStrings) {
        Util.clearScreen();
        System.out.println("Your receipts are: ");
        System.out.println("====================================");
        for (String receiptString : receiptStrings) {
            System.out.println(receiptString);
            System.out.println("====================================");
        }
        Util.input("Press enter to go back to main menu.");
    }
}

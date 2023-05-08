package vintage.view;

import java.util.List;

public class ReceiptsView {
    public static void displayUserReceipts(List<String> receiptStrings) {
        System.out.println("Your receipts:");
        for (String receiptString : receiptStrings) {
            System.out.println(receiptString);
        }

        Util.input("Press enter to go back to main menu.");
    }
}

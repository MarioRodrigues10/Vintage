package vintage.view;

import java.util.List;

public class ReceiptsView {
    private static ReceiptsView instance = null;

    public static ReceiptsView getInstance() {
        if (instance == null) {
            instance = new ReceiptsView();
        }
        return instance;
    }

    public void displayUserReceipts(List<String> receiptStrings) {
        System.out.println("Your receipts:");
        for (String receiptString : receiptStrings) {
            System.out.println(receiptString);
        }

        Util.input("Press enter to go back to main menu.");
    }
}

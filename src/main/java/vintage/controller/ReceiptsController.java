package vintage.controller;

import vintage.module.order.receipt.Receipt;
import vintage.module.user.User;
import vintage.view.ReceiptsView;

import java.util.ArrayList;
import java.util.List;

public class ReceiptsController {
    public static void userReceipts(User user) {
        List<Receipt> receipts = user.getReceipts();
        List<String> receiptStrings = new ArrayList<String>();

        for (Receipt receipt : receipts) {
            receiptStrings.add(receipt.toString());
        }

        ReceiptsView.displayUserReceipts(receiptStrings);

        UserController.menu(user);
    }
}

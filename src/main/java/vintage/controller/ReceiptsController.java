package vintage.controller;

import vintage.module.order.receipt.Receipt;
import vintage.module.user.User;
import vintage.view.ReceiptsView;

import java.util.ArrayList;
import java.util.List;

public class ReceiptsController {
    private static ReceiptsController instance = null;

    public static ReceiptsController getInstance() {
        if (instance == null) {
            instance = new ReceiptsController();
        }
        return instance;
    }

    public void userReceipts(User user) {
        List<Receipt> receipts = user.getReceipts();
        List<String> receiptStrings = new ArrayList<String>();

        for (Receipt receipt : receipts) {
            receiptStrings.add(receipt.toString());
        }

        ReceiptsView.getInstance().displayUserReceipts(receiptStrings);

        UserController.getInstance().menu(user);
    }
}

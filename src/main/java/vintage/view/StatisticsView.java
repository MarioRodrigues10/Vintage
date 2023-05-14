package vintage.view;

import vintage.controller.AdminController;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Statistics;
import vintage.module.user.User;
import vintage.module.user.UserListings;

import java.util.List;

public class StatisticsView {

    public static int menu(){
        Util.clearScreen();
        Util.printHeader();
        Util.println("\n[1] Get Seller Orders");
        Util.println("[2] Biggest Seller By Products");
        Util.println("[3] Biggest Sellers By Products");
        Util.println("[4] Biggest Sellers By Money");
        Util.println("[5] Biggest Buyers By Products");
        Util.println("[6] Exit");
        int option = Util.inputOption(6);
        return option;
    }

    public static void printStatistics(int option){
        UserListings userListings = UserListings.getInstance();
        switch (option) {
            case 1:
                String name = Util.input("Enter the name of the user: ");
                User user = UserListings.getInstance().getUserByName(name);
                if (user == null) {
                    Util.println("User not found.");
                } else {
                    List<Receipt> receipts = Statistics.getSellerOrders(user);
                    viewStatistics(receipts);
                }
                AdminController.menu();
                break;
            case 2:
                User user2 = Statistics.biggestSellerByProducts(userListings);
                if (user2 == null) {
                    Util.println("No orders found.");
                    AdminController.menu();
                    break;
                } else{
                    Util.println("Biggest Seller By Products: ");
                    Util.println(user2.toString());
                }
                AdminController.menu();
                break;
            case 3:
                List<User> users3 = Statistics.biggestSellersByProducts(userListings);
                if(users3.isEmpty()){
                    Util.println("No orders found.");
                }
                else {
                    for (User user3 : users3) {
                        Util.println(user3.toString());
                    }
                }
                AdminController.menu();
                break;
            case 4:
                List<User> users4 = Statistics.biggestSellersByMoney(userListings);
                if(users4.isEmpty()){
                    Util.println("No orders found.");
                }
                else {
                    for (User user4 : users4) {
                        Util.println(user4.toString());
                    }
                }
                AdminController.menu();
                break;
            case 5:
                List<User> users5 = Statistics.biggestBuyersByProducts(userListings);
                if(users5.isEmpty()){
                    Util.println("No orders found.");
                }
                else {
                    for (User user5 : users5) {
                        Util.println(user5.toString());
                    }
                }
                AdminController.menu();
                break;
            case 6:
                AdminController.menu();
                break;
        }
    }

    public static void viewStatistics(List<Receipt> receipts) {
        if(receipts == null) {
            Util.println("No orders found.");
            return;
        }
        {
            Util.clearScreen();
            Util.printHeader();
            Util.println("\nList of Orders:\n");

            Util.println("====================================");
            for (Receipt receipt : receipts) {
                Util.println(receipt.toString());
                Util.println("====================================");
            }
        }
    }

}

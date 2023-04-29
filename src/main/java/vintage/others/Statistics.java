package vintage.others;

import vintage.item.*;
import vintage.item.carrier.Carrier;
import vintage.receipt.Receipt;
import vintage.user.User;
import vintage.order.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    /**
     * Returns all the orders of a specific seller.
     * @param user
     * @return ArrayList<Order>
     */
    public static List<Receipt> getSellerOrders(User user) {
        return user.getSaleReceipts();
    }

    /**
     * Returns the biggest seller by number of products sold.
     * @return User
     */
    public static User biggestSellerByProducts(){
        return biggestSellersByProducts().get(0);
    }


    /**
     * Returns the list of biggests sellers by number of products sold.
     * @return ArrayList<User>
     */
    public static ArrayList<User> biggestSellersByProducts(){
            ItemListings listings = new ItemListings();
            ArrayList<User> users = new ArrayList<User>(); /* List of users who have sold items */
            for (Item item : listings.getAllItems()) {
                if (!users.contains(item.getOwner())) {
                    users.add(item.getOwner());
                }
            }

            ArrayList<User> biggestSellers = new ArrayList<User>(); /* List of users who have sold the most items */
            int max = 0;
            for (User user : users) {
                int count = 0;
                for(Receipt receipt: user.getSaleReceipts())
                    count += receipt.getItems().size();
                if (count > max) {
                    max = count;
                    biggestSellers.clear();
                    biggestSellers.add(user);
                } else if (count == max) {
                    biggestSellers.add(user);
                }
            }
            return biggestSellers;
    }

    /**
     * Returns the list of biggest buyers by number of products bought.
     * @return ArrayList<User>
     */
    public static ArrayList<User> biggestBuyersByProducts(){
        OrderListings orderListings = new OrderListings();
        ArrayList<User> users = new ArrayList<User>(); /* List of users who have bought items */
        for (Order order : orderListings.getAllOrders()) {
            if (!users.contains(order.getBuyer())) {
                users.add(order.getBuyer());
            }
        }

        ArrayList<User> biggestBuyers = new ArrayList<>(); /* List of users who have bought the most items */
        int max = 0;
        for (User user : users) {
            int count = 0;
            for(Receipt receipt: user.getPurchaseReceipts())
                count += receipt.getItems().size();

            if (count > max) {
                max = count;
                biggestBuyers.clear();
                biggestBuyers.add(user);
            } else if (count == max) {
                biggestBuyers.add(user);
            }
        }
        return biggestBuyers;
    }

    /**
     * Returns the biggest seller by money earned.
     * @return User
     */
    public static ArrayList<User> biggestSellerByMoney(){
        ItemListings listings = new ItemListings();
        ArrayList<User> users = new ArrayList<User>(); /* List of users who have sold items */
        for (Item item : listings.getAllItems()) {
            if (!users.contains(item.getOwner())) {
                users.add(item.getOwner());
            }
        }

        ArrayList<User> biggestSellers = new ArrayList<User>(); /* List of users who have sold the most items */
        BigDecimal max = BigDecimal.valueOf(0);
        for (User user : users) {
            BigDecimal count = BigDecimal.valueOf(0);
            for(Receipt receipt: user.getSaleReceipts())
                count = count.add(receipt.getTotalPrice());

            if (count.compareTo(max) > 0) {
                max = count;
                biggestSellers.clear();
                biggestSellers.add(user);
            } else if (count == max) {
                biggestSellers.add(user);
            }
        }
        return biggestSellers;
    }
}

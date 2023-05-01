package vintage.others;

import vintage.item.*;
import vintage.item.carrier.Carrier;
import vintage.receipt.Receipt;
import vintage.user.User;
import vintage.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Statistics {

    /**
     * Returns all the orders of a specific seller.
     * @param user
     * @return List<Order>
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
     * @return List<User>
     */
    public static List<User> biggestSellersByProducts() {
        ItemListings listings = new ItemListings();
        Set<User> sellers = new HashSet<>(); // Set of users who have sold items
        for (Item item : listings.getAllItems()) {
            sellers.add(item.getOwner());
        }

        Map<User, Integer> itemsSoldByUser = new HashMap<>(); // Map of users to number of items sold
        for (User seller : sellers) {
            int count = 0;
            for (Receipt receipt : seller.getSaleReceipts()) {
                count += receipt.getItems().size();
            }
            itemsSoldByUser.put(seller, count);
        }

        List<User> biggestSellers = new ArrayList<>(); // List of users who have sold the most items
        int maxItemsSold = 0;
        for (User seller : itemsSoldByUser.keySet()) {
            int itemsSold = itemsSoldByUser.get(seller);
            if (itemsSold > maxItemsSold) {
                maxItemsSold = itemsSold;
                biggestSellers.clear();
                biggestSellers.add(seller);
            } else if (itemsSold == maxItemsSold) {
                biggestSellers.add(seller);
            }
        }
        return biggestSellers;
    }

    /**
     * Returns the list of the biggest buyers by number of products bought.
     * @return List<User>
     */
    public static List<User> biggestBuyersByProducts() {
        OrderListings orderListings = new OrderListings();
        Set<User> buyers = new HashSet<>(); // Set of users who have bought items
        for (Order order : orderListings.getAllOrders()) {
            buyers.add(order.getBuyer());
        }

        Map<User, Integer> itemsBoughtByUser = new HashMap<>(); // Map of users to number of items bought
        for (User buyer : buyers) {
            int count = 0;
            for (Receipt receipt : buyer.getPurchaseReceipts()) {
                count += receipt.getItems().size();
            }
            itemsBoughtByUser.put(buyer, count);
        }

        List<User> biggestBuyers = new ArrayList<>(); // List of users who have bought the most items
        int maxItemsBought = 0;
        for (User buyer : itemsBoughtByUser.keySet()) {
            int itemsBought = itemsBoughtByUser.get(buyer);
            if (itemsBought > maxItemsBought) {
                maxItemsBought = itemsBought;
                biggestBuyers.clear();
                biggestBuyers.add(buyer);
            } else if (itemsBought == maxItemsBought) {
                biggestBuyers.add(buyer);
            }
        }
        return biggestBuyers;
    }

    /**
     * Returns the biggest sellers by money earned.
     * @return ArrayList<User>
     */
    public static ArrayList<User> biggestSellersByMoney(){
        ItemListings listings = new ItemListings();
        Map<User, BigDecimal> earnings = new HashMap<>(); // Map of each user's earnings
        for (Item item : listings.getAllItems()) {
            User user = item.getOwner();
            if (!earnings.containsKey(user)) {
                earnings.put(user, BigDecimal.ZERO);
            }
            BigDecimal price = item.getPrice();
            earnings.put(user, earnings.get(user).add(price));
        }

        // Find the user(s) with the highest earnings
        ArrayList<User> biggestSellers = new ArrayList<>();
        BigDecimal maxEarnings = Collections.max(earnings.values());
        for (User user : earnings.keySet()) {
            BigDecimal userEarnings = earnings.get(user);
            if (userEarnings.equals(maxEarnings)) {
                biggestSellers.add(user);
            }
        }
        return biggestSellers;
    }
}

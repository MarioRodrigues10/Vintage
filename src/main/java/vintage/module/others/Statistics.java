package vintage.module.others;

import vintage.module.item.*;
import vintage.module.order.receipt.Receipt;
import vintage.module.user.User;
import vintage.module.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import vintage.module.user.UserListings;

public class Statistics {
    private static Statistics instance = null;

    public static Statistics getInstance() {
        if (instance == null) {
            instance = new Statistics();
        }
        return instance;
    }

    /**
     * Returns all the orders of a specific seller.
     * @param user
     * @return List<Order>
     */
    public List<Receipt> getSellerOrders(User user) {
        return user.getSaleReceipts();
    }

    /**
     * Returns the biggest seller by number of products sold.
     * @return User
     */
    public User biggestSellerByProducts(UserListings listings){
        return biggestSellersByProducts(listings).get(0);
    }


    /**
     * Returns the list of biggests sellers by number of products sold.
     * @return List<User>
     */
    public List<User> biggestSellersByProducts(UserListings listings) {

        Map<String, User> usersMap = listings.getUsers(); // Map of users where the key is the user ID
        Set<User> sellers = new HashSet<>(usersMap.values()); // Extract the Set of users from the Map

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
                biggestSellers.add(0,seller);
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
    public List<User> biggestBuyersByProducts(UserListings listings) {
        Map<String, User> usersMap = listings.getUsers(); // Map of users where the key is the user ID
        Set<User> buyers = new HashSet<>(usersMap.values()); // Extract the Set of users from the Map


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
                biggestBuyers.add(0,buyer);
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
    public ArrayList<User> biggestSellersByMoney(UserListings listings){
        Map<String, User> usersMap = listings.getUsers(); // Map of users where the key is the user ID
        Set<User> sellers = new HashSet<>(usersMap.values()); // Extract the Set of users from the Map

        Map<User, BigDecimal> earnings = new HashMap<>(); // Map of users to earnings

        for (User seller : sellers){
            for (Receipt receipt : seller.getSaleReceipts()){
                for (Item item : receipt.getItems()){
                    if (!earnings.containsKey(seller)){
                        earnings.put(seller, BigDecimal.ZERO);
                    }
                    BigDecimal price = item.getPrice();
                    earnings.put(seller, earnings.get(seller).add(price));
                }
            }
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

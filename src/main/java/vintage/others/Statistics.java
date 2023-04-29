package vintage.others;

import vintage.item.*;
import vintage.item.carrier.Carrier;
import vintage.user.User;
import vintage.order.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
public class Statistics {

    /**
     * Returns all the orders of a specific seller.
     * @param user
     * @return ArrayList<Order>
     */
    public static ArrayList<Order> getSellerOrders(User user) {
        OrderListings orderListings = new OrderListings();
        ItemListings listings = new ItemListings();
        ArrayList<Item> items = new ArrayList<Item>();
        for (Item item : listings.getAllItems()) {
            if (item.getOwner().equals(user)) {
                items.add(item);
            }
        }

        ArrayList<Order> orders = new ArrayList<Order>();
        for (Order order : orderListings.getAllOrders()) {
            for (Item item : items) {
                if(order.getItems().containsKey(item)) {
                    orders.add(order);
                }
            }
        }
        return orders;
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
          OrderListings orderListings = new OrderListings();
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
                for (Order order : orderListings.getAllOrders()) {
                    if (order.getBuyer().equals(user)) {
                        count++;
                    }
                }
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

        ArrayList<User> biggestBuyers = new ArrayList<User>(); /* List of users who have bought the most items */
        int max = 0;
        for (User user : users) {
            int count = 0;
            for (Order order : orderListings.getAllOrders()) {
                if (order.getBuyer().equals(user)) {
                    count++;
                }
            }
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
    public static User biggestSellerByMoney(){
        OrderListings orderListings = new OrderListings();
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
            for (Item item : listings.getAllItems()) {
                if(item.getOwner().equals(user)) {
                    count = count.add(item.getPrice());
                }
            }
            if (count.compareTo(max) > 0) {
                max = count;
                biggestSellers.clear();
                biggestSellers.add(user);
            } else if (count == max) {
                biggestSellers.add(user);
            }
        }
        return biggestSellers.get(0);
    }


    /**
     * Returns the biggest carrier by number of products.
     * @return Carrier
     */
    public static Carrier biggestCarrier(){
        OrderListings orderListings = new OrderListings();
        ArrayList<Carrier> carriers = new ArrayList<Carrier>(); /* List of carriers who have delivered items TIVE QUE IR BUSCAR ISTO AO CU DO JUDAS */
        for (Order order : orderListings.getAllOrders()) {
            for(Item item : order.getItems().keySet()) {
                if (!carriers.contains(item.getCarrier())) {
                    carriers.add(item.getCarrier());
                }
            }
        }

        ArrayList<Carrier> biggestCarriers = new ArrayList<Carrier>(); /* List of carriers who have delivered the most items */
        int max = 0;
        for (Carrier carrier : carriers) {
            int count = 0;
            for (Order order : orderListings.getAllOrders()) {
                for(Item item : order.getItems().keySet()) {
                    if (item.getCarrier().equals(carrier)) {
                        count++;
                    }
                }
            }
            if (count > max) {
                max = count;
                biggestCarriers.clear();
                biggestCarriers.add(carrier);
            } else if (count == max) {
                biggestCarriers.add(carrier);
            }
        }
        return biggestCarriers.get(0);
    }
}

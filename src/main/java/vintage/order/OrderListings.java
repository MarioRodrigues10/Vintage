package vintage.order;

import vintage.order.Order;
import vintage.user.User;

import java.time.LocalDate;
import java.util.UUID;
import java.util.*;
import java.util.stream.Collectors;


public class OrderListings {
    private final Map<UUID, List<Order>> orders; /* ! Map of orders, where the key is the buyer user ID */

    /**
     * Creates a new empty Listings object with the specified properties.
     */
    public OrderListings() {
        this.orders = new HashMap<>();
    }

    /**
     * Creates a new Listings object with the specified properties.
     *
     * @param orders a Map of orders, where the key is the user ID
     */
    public OrderListings(Map<UUID, List<Order>> orders) {
        this.orders = orders;
    }

    /**
     * Returns a List of orders of a specific user.
     *
     * @param user a User object containing the user
     * @return a List of orders of a specific user
     */
    public List<Order> getUserOrders(User user) {
        return this.orders.get(user.getId());
    }

    /**
     * Returns a List of orders of a specific user.
     *
     * @param userId a UUID object containing the user ID
     * @return a List of orders of a specific user
     */
    public void addOrder(UUID userId, Order order) {
        List<Order> userOrders = this.orders.get(userId);
        if (userOrders == null) {
            userOrders = new ArrayList<>();
        }
        userOrders.add(order);
        this.orders.put(userId, userOrders);
    }

    /**
     * Removes an order from a user's list of orders.
     *
     * @param userId a UUID object containing the user ID
     * @param order an Order object containing the order
     */
    public void removeOrder(UUID userId, Order order) {
        List<Order> userOrders = this.orders.get(userId);
        if (userOrders != null) {
            userOrders.remove(order);
            this.orders.put(userId, userOrders);
        }
    }

    /**
     * Returns a List of all orders.
     *
     * @return a List of all orders
     */
    public List<Order> getAllOrders() {
        return this.orders.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    /**
     * Updates the state of all orders in the program.
     * @param currentDate
     */
    public void updateOrdersState(LocalDate currentDate) {
        for (List<Order> userOrders : this.orders.values()) {
            for (Order order : userOrders) {
                if (order.getState() == Order.State.PENDING) {
                    order.updateDeliveryState(currentDate);
                }
            }
        }
    }
}

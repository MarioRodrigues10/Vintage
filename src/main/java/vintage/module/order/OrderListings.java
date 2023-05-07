package vintage.module.order;

import vintage.module.others.Time;
import vintage.module.user.User;
import vintage.module.order.Order;

import java.time.LocalDate;
import java.util.UUID;
import java.util.*;
import java.util.stream.Collectors;
import java.io.Serializable;

public class OrderListings implements Serializable {
    private static OrderListings instance = null;
    private Map<UUID, List<Order>> orders; /* ! Map of orders, where the key is the buyer user ID */

    public static OrderListings getInstance() {
        if (instance == null) {
            instance = new OrderListings();
        }
        return instance;
    }

    /**
     * Creates a new OrderListings object with default properties.
     */
    private OrderListings() {
        this.orders = new HashMap<UUID, List<Order>>();
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
     * Returns the pending order of a user.
     *
     * @param user a User object containing the user
     * @return the pending order of a user
     */
    public Order getUserPendindOrder(User user) {
        List<Order> userOrders = this.orders.get(user.getId());
        if (userOrders == null) {
            return null;
        }
        for (Order order : userOrders) {
            if (order.getState() == Order.State.PENDING) {
                return order;
            }
        }
        return null;
    }

    /**
     * Returns the finished order of a user with given ID.
     *
     * @param user a User object containing the user
     * @param orderId a UUID object containing the order ID
     * @return the finished order of a user
     */
    public Order getUserFinishedOrder(User user, UUID orderId) {
        List<Order> userOrders = this.orders.get(user.getId());
        if (userOrders == null) {
            return null;
        }
        for (Order order : userOrders) {
            if (order.getState() == Order.State.FINISHED && order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    /**
     * Returns a List of finished orders of a specific user.
     *
     * @param user a User object containing the user
     * @return a List of finished orders of a specific user
     */
    public List<Order> getUserFinishedOrders(User user) {
        List<Order> userOrders = this.orders.get(user.getId());
        if (userOrders == null) {
            return null;
        }
        List<Order> finishedOrders = new ArrayList<>();
        for (Order order : userOrders) {
            if (order.getState() == Order.State.FINISHED) {
                finishedOrders.add(order);
            }
        }
        return finishedOrders;
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
     */
    public void updateOrdersState() {
        LocalDate currentDatePlusOne = Time.getInstance().getCurrentDate();

        for (List<Order> userOrders : this.orders.values()) {
            for (Order order : userOrders) {
                if (order.getState() == Order.State.PENDING) {
                    order.updateDeliveryState();
                }
            }
        }
    }
}

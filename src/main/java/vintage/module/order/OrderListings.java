package vintage.module.order;

import vintage.module.item.Item;
import vintage.module.time.Time;
import vintage.module.user.User;
import vintage.module.time.TimeObserver;
import vintage.module.user.UserListings;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.*;
import java.util.stream.Collectors;

public class OrderListings implements Serializable, TimeObserver {
    private static OrderListings instance = null;
    private final Map<UUID, List<Order>> orders; /* ! Map of orders, where the key is the buyer user ID */

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
    public Order getUserPendingOrder(User user) {
        List<Order> userOrders = this.orders.getOrDefault(user.getId(), new ArrayList<Order>());

        for (Order order : userOrders) {
            if (order.getState() == Order.State.PENDING) {
                return order;
            }
        }
        Order newPendingOrder = new Order(user, new HashMap<Item, Order.State>(), Order.Size.SMALL, Order.State.PENDING,
                new BigDecimal(0), user.getResidence());

        this.addOrder(user.getId(), newPendingOrder);

        return newPendingOrder;
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
    @Override
    public void update() {
        LocalDate currentDatePlusOne = Time.getInstance().getCurrentDate();

        for (List<Order> userOrders : this.orders.values()) {
            for (Order order : userOrders) {
                if (order.getState() == Order.State.FINISHED) {
                    order.updateDeliveryState();
                }
            }
        }
    }

    public void saveOrders(String folderName) {
        try {
            File file = new File("saves/" + folderName + "/orders.ser");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fileOut = new FileOutputStream("saves/" + folderName + "/orders.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadOrders(String folderName) {
        try (FileInputStream fileIn = new FileInputStream("saves/" + folderName + "/orders.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            OrderListings orderListings = (OrderListings) in.readObject();
            instance = orderListings;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

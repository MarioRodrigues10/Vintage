package vintage.user;

import vintage.item.Item;
import vintage.order.Order;
import vintage.order.OrderListings;
import vintage.order.receipt.BuyerReceipt;
import vintage.order.receipt.Receipt;
import vintage.order.receipt.SellerReceipt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id; /* ! ID of a User */
    private String name; /* ! Name of a User */
    private String email; /* ! Email of a User */
    private Address residence; /* ! Residence of a User */
    private String taxNumber; /* ! Tax number of a User */
    private List<Receipt> receipts = new ArrayList<Receipt>();

    /**
     * Creates a new User object with the specified properties.
     *
     * @param name a String containing the name of the user
     * @param email a String containing the email of the user
     * @param residence a Residence object containing the residence of the user
     * @param taxNumber a String containing the tax number of the user
     */
    public User(String name, String email, Address residence, String taxNumber, ArrayList<Receipt> receipts) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.residence = residence;
        this.taxNumber = taxNumber;
        this.receipts = receipts;
    }

    /**
     * Creates a new empty User object.
     */
    public User() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.email = "";
        this.residence = new Address();
        this.taxNumber = "";
        this.receipts = new ArrayList<Receipt>();
    }

    /**
     * Creates a new User object with the specified user.
     *
     * @param user a User object containing the user
     */
    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.residence = user.getResidence();
        this.taxNumber = user.getTaxNumber();
        this.receipts = user.getReceipts();
    }

    /**
     * Returns the ID of a User.
     *
     * @return the ID of a User
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns the name of a User.
     *
     * @return the name of a User
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of a User.
     *
     * @param name a String containing the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email of a User.
     *
     * @return the email of a User
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of a User.
     *
     * @param email a String containing the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the residence of a User.
     *
     * @return the residence of a User
     */
    public Address getResidence() {
        return this.residence;
    }

    /**
     * Sets the residence of a User.
     *
     * @param residence a Residence object containing the residence of the user
     */
    public void setResidence(Address residence) {
        this.residence = residence;
    }

    /**
     * Returns the tax number of a User.
     *
     * @return the tax number of a User
     */
    public String getTaxNumber() {
        return this.taxNumber;
    }

    /**
     * Sets the tax number of a User.
     *
     * @param taxNumber a String containing the tax number of the user
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Sets bills of a User.
     *
     * @return the User's Bill's list.
     */
    public List<Receipt> getReceipts() { return List.copyOf(receipts); }

    /**
     * Returns the sale receipts of a User.
     *
     * @return the sale receipts of a User
     */
    public List<Receipt> getSaleReceipts() {
        List<Receipt> sellReceipts = new ArrayList<Receipt>();
        for (Receipt receipt : receipts) {
            if (receipt instanceof SellerReceipt) {
                sellReceipts.add(((SellerReceipt) receipt).clone());
            }
        }
        return sellReceipts;
    }

    /**
     * Returns the purchase receipts of a User.
     *
     * @return the User's purchase receipts.
     */
    public List<Receipt> getPurchaseReceipts() {
        List<Receipt> purchaseReceipts = new ArrayList<Receipt>();
        for (Receipt receipt : receipts) {
            if (receipt instanceof BuyerReceipt) {
                purchaseReceipts.add(((BuyerReceipt) receipt).clone());
            }
        }
        return purchaseReceipts;
    }


    /**
     * Sets the receipts of a User.
     *
     * @param receipts a Bill's ArrayList containing the receipts of the user
     */
    public void setReceipts(ArrayList<Receipt> receipts) { this.receipts = receipts; }

    /**
     * Adds a Receipt to a Receipt List
     * @param receipt
     */
    public void addReceipt(Receipt receipt) { this.receipts.add(receipt); }

    /**
     * Removes a Receipt to a Receipt List
     * @param receipt
     */
    public void removeReceipt(Receipt receipt) {
        receipts.remove(receipt);
    }

    /**
     * Returns a boolean indicating whether the user is equal to another user.
     * To check if a user is equal to another user, it is only necessary to check if the email is equal.
     *
     * @param user
     * @return boolean
     */
    public boolean equals(User user) {
        return this.email.equals(user.getEmail());
    }

    /**
     * Returns the Receipt of a specific order.
     *
     * @return a Receipt object containing the receipt of the order
     */
    public Receipt getOrderIdReceipt(UUID orderId) {
        for (Receipt receipt : receipts) {
            if (receipt.getOrderID().equals(orderId)) {
                return receipt;
            }
        }
        return null;
    }

    /**
     * Creates a new order for a user if it doesn't exist a pending one already.
     * @param orderListings
     * @return the ID of the order
     */
    public UUID createOrder(OrderListings orderListings) {
        Order currentOrder = orderListings.getUserPendindOrder(this);
        if (currentOrder == null) {
            currentOrder = new Order(this);
            orderListings.addOrder(this.id, currentOrder);
        }

        return currentOrder.getId();
    }

    /**
     * Adds an item to the order of a user.
     *
     * @param orderListings
     * @param item
     * @return the order with the added item
     */
    public Order addItemToOrder(OrderListings orderListings, Item item) {
        Order currentOrder = orderListings.getUserPendindOrder(this);
        if (currentOrder == null) {
            return null;
        }
        currentOrder.addItem(item);
        return currentOrder;
    }

    /**
     * Finishes the pending order of a user.
     * @param orderListings
     * @return the finished order
     */
    public Order finishPendingOrder(OrderListings orderListings) {
        Order currentOrder = orderListings.getUserPendindOrder(this);
        if (currentOrder != null) {
            currentOrder.finishOrder();
            return currentOrder;
        }

        return null;
    }

    /**
     * Returns the pending order of a user.
     * @param orderListings
     * @return the pending order
     */
    public Order getPendingOrder(OrderListings orderListings) {
        return orderListings.getUserPendindOrder(this);
    }

    /**
     * Returns the finished orders of a user.
     * @param orderListings
     * @return a list of orders
     */
    public List<Order> getFinishedOrders(OrderListings orderListings) {
        return orderListings.getUserFinishedOrders(this);
    }

    /**
     * Returns a finished order of a user.
     * @param orderListings
     * @param orderId
     * @return the order with the given id
     */
    public Order getFinishedOrder(OrderListings orderListings, UUID orderId) {
        return orderListings.getUserFinishedOrder(this, orderId);
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        for (Receipt receipt : receipts) {
            items.addAll(receipt.getItems());
        }
        return items;
    }
}
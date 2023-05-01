package vintage.receipt;

import vintage.item.Item;
import vintage.user.User;
import vintage.order.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

/**
 * Defines a Receipt
 */
public class Receipt {

    public enum Type {
        PURCHASE,
        SALE
    }
    private UUID id; /* ! ID of a Receipt */
    private Type type; /* ! Type of Receipt */
    private User buyer; /* ! Buyer of a Receipt's Order */
    private UUID orderID; /* ! ID of a Receipt's Order */
    private BigDecimal totalPrice; /* ! Total price of a Receipt */
    private List<Item> items; /* ! Items in a Receipt's Order */
    private LocalDate emissionDate; /* ! Date of emission of a Receipt */

    /**
     * Creates a new Receipt object with the default properties.
     */
    public Receipt() {
        this.id = UUID.randomUUID();
        this.type = null;
        this.buyer = null;
        this.orderID = null;
        this.totalPrice = BigDecimal.valueOf(0);
        this.items = new ArrayList<Item>();
        this.emissionDate = LocalDate.now();
    }

    /**
     * Creates a new Receipt object with the specified properties.
     *
     * @param type
     * @param buyer
     * @param totalPrice
     * @param items
     */
    public Receipt(Type type, User buyer, BigDecimal totalPrice, List<Item> items, LocalDate emissionDate, Order order) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.buyer = buyer;
        this.orderID = order.getId();
        this.totalPrice = totalPrice;
        this.items = items;
        this.emissionDate = emissionDate;
    }

    /**
     * Creates a new Receipt out of an Order.
     *
     * @param order
     */
    public Receipt(Order order) {
        this.id = UUID.randomUUID();
        this.type = Type.PURCHASE;
        this.buyer = order.getBuyer();
        this.orderID = order.getId();
        this.totalPrice = order.getPrice();
        this.items = new ArrayList<Item>(order.getItems().keySet());
        this.emissionDate = order.getExpeditionDate();
    }
    /**
     * Creates a new Receipt out of an Order and a seller
     *
     * @param order
     * @param seller
     */
    public Receipt(Order order, User seller) {
        ArrayList<Item> allItems = new ArrayList<Item>(order.getItems().keySet());
        ArrayList<Item> sellerItems = new ArrayList<Item>();
        BigDecimal price = BigDecimal.valueOf(0);

        for(Item item : allItems)
            if(item.getUser().equals(seller)) {
                sellerItems.add(item);
                price.add(item.getPrice());
            }

        this.id = UUID.randomUUID();
        this.type = Type.SALE;
        this.buyer = order.getBuyer();
        this.orderID = order.getId();
        this.totalPrice = price;
        this.items = sellerItems;
        this.emissionDate = order.getExpeditionDate();

    }

    /**
     * Creates a new Receipt object based on another Receipt object.
     *
     * @param receipt
     */
    public Receipt(Receipt receipt) {
        this.id = receipt.getId();
        this.type = receipt.getType();
        this.buyer = receipt.getBuyer();
        this.orderID = receipt.orderID;
        this.totalPrice = receipt.getTotalPrice();
        this.items = receipt.getItems();
        this.emissionDate = receipt.getEmissionDate();
    }

    /**
     * Returns the ID of the Receipt.
     * @return ID
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns the buyer of the Receipt.
     * @return User
     */
    public User getBuyer() { return this.buyer; }

    /**
     * Returns the ID of the Receipt's Order.
     * @return ID
     */
    public UUID getOrderID() { return this.orderID; }

    /**
     * Returns the Total Price of the Receipt.
     * @return BigDecimal
     */
    public BigDecimal getTotalPrice() { return totalPrice; }

    /**
     * Returns the List of Items of the Receipt.
     * @return ArrayList<Item>
     */
    public List<Item> getItems() { return this.items; }

    /**
     * Returns the Type of the Receipt.
     * @return Type
     */
    public Type getType() { return type; }

    /**
     * Returns the Date of emission of a Receipt.
     * @return LocalDate
     */
    public LocalDate getEmissionDate() { return emissionDate; }

    /**
     * Sets the Type of Receipt
     * @param type Type of Receipt
     */
    public void setType(Type type) { this.type = type; }

    /**
     * Sets the buyer of a Receipt
     * @param buyer User representing the buyer of a Receipt
     */
    public void setBuyer(User buyer) { this.buyer = buyer; }

    /**
     * Sets the ID of a Receipt's Order
     * @param orderID ID of a Receipt's Order
     */
    public void setOrderID(UUID orderID) { this.orderID = orderID; }

    /**
     * Sets the Total Price of a Receipt
     * @param totalPrice ID of a Receipt
     */
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    /**
     * Sets the Items List of a Receipt
     * @param items Items of a Receipt
     */
    public void setItems(List<Item> items) { this.items = items; }

    /**
     * Method that turns the Receipt into a String
     * @return a String representing the Receipt
     */
    @Override
    public String toString() {
        return "Receipt{" +
                "\nid=" + id +
                "\nemissionDate=" + emissionDate +
                "\ntype=" + type +
                "\nbuyer=" + buyer.getName() +
                "\n---------------------" +
                "\nitems=" + items +
                "\n---------------------" +
                "\ntotalPrice=" + totalPrice +
                "\nVintage" +
                '}';
    }

    /**
     * Clone method
     */
    public Receipt clone() {
        return new Receipt(this);
    }

    /**
     * Adds an Item to the Receipt
     * @param item Item to be added
     */
    public void addItem(Item item) {
        this.items.add(item);
        this.totalPrice.add(item.getPrice());
    }
}

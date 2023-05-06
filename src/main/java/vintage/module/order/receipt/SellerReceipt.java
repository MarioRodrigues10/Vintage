package vintage.module.order.receipt;

import vintage.module.user.User;
import vintage.module.item.Item;
import vintage.module.order.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SellerReceipt implements Receipt {
    private UUID id; /* ! ID of a Receipt */
    private User buyer; /* ! Buyer of a Receipt's Order */
    private UUID orderID; /* ! ID of a Receipt's Order */
    private BigDecimal totalPrice; /* ! Total price of a Receipt */
    private List<Item> items; /* ! Items in a Receipt's Order */
    private LocalDate emissionDate; /* ! Date of emission of a Receipt */

    /**
     * Creates a new Receipt object with the specified properties.
     *
     * @param buyer
     * @param totalPrice
     * @param items
     */
    public SellerReceipt(User buyer, BigDecimal totalPrice, List<Item> items, LocalDate emissionDate, Order order) {
        this.id = UUID.randomUUID();
        this.buyer = buyer;
        this.orderID = order.getId();
        this.totalPrice = totalPrice;
        this.items = items;
        this.emissionDate = emissionDate;
    }

    /**
     * Creates a new Receipt object based on another Receipt object.
     *
     * @param receipt
     */
    public SellerReceipt(SellerReceipt receipt) {
        this.id = receipt.getId();
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
    @Override
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
    @Override
    public UUID getOrderID() { return this.orderID; }

    /**
     * Returns the Total Price of the Receipt.
     * @return BigDecimal
     */
    @Override
    public BigDecimal getTotalPrice() { return this.totalPrice; }

    /**
     * Returns the List of Items of the Receipt.
     * @return ArrayList<Item>
     */
    @Override
    public List<Item> getItems() { return this.items; }

    /**
     * Returns the Date of emission of a Receipt.
     * @return LocalDate
     */
    @Override
    public LocalDate getEmissionDate() { return this.emissionDate; }

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
    @Override
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    /**
     * Sets the Items List of a Receipt
     * @param items Items of a Receipt
     */
    @Override
    public void setItems(List<Item> items) { this.items = items; }

    @Override
    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    /**
     * Method that turns the Receipt into a String
     * @return a String representing the Receipt
     */
    @Override
    public String toString() {
        return "Receipt{" +
                "\nid=" + id +
                "\nemissionDate=" + emissionDate +
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
    public SellerReceipt clone() {
        return new SellerReceipt(this);
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

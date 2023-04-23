package vintage.order;

import vintage.item.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Defines an Order
 */
public class Order {
    /*
     * Enumerates the sizes of an Order
     */
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    /*
     * Enumerates the states of an Order
     */
    public enum State {
        PENDING, FINISHED, SENT, DELIVERED
    }

    private final UUID id; /* ! ID of an Order */
    private List<Item> items; /* ! Items of an Order */
    private Size size; /* ! Size of an Order */
    private State state; /* ! State of an Order */
    private BigDecimal price; /* ! Price of an Order */

    /**
     * Creates a new Order object with the specified properties.
     * @param items
     * @param size
     * @param state
     * @param price
     */
    public Order(List<Item> items, Size size, State state, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.items = items;
        this.size = size;
        this.state = state;
        this.price = price;
    }

    /**
     * Creates a new Order object with default properties.
     */
    public Order() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
        this.size = Size.MEDIUM;
        this.state = State.PENDING;
        this.price = BigDecimal.valueOf(0);
    }

    public Order(Order order) {
        this.id = order.getId();
        this.items = order.getItems();
        this.size = order.getSize();
        this.state = order.getState();
        this.price = order.getPrice();
    }

    /**
     * Returns the ID of the order.
     * @return id
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns an ArrayList of Items.
     * @return items
     */
    public List<Item> getItems() {
        return List.copyOf(items);
    }

    /**
     * Sets the items of the order.
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns the size of the order.
     * @return size
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * Sets the size of the order.
     * @param size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Returns the state of the order.
     * @return state
     */
    public State getState() {
        return this.state;
    }

    /**
     * Sets the state of the order.
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Returns the price of the order.
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the order.
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Adds an Item to an Order
     * @param item
     */
    public Order addItem(Item item) {
        items.add(item);
        return new Order(items, size, state, price);
    }

    /**
     * Calculates the price of an order
     *
     * @return price
     */
    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(0);
        for (Item item : items) {
            if(item.isUsed()) {
                price = price.add(item.getPrice()).add(BigDecimal.valueOf(0.25));
            }
            else {
                price = price.add(item.getPrice()).add(BigDecimal.valueOf(0.5));
            }
        }
        return price;
    }

    /**
     * Removes an Item from an Order
     *
     * @return Order
     */
    public Order removeItemFromOrder(Item item) {
        items.remove(item);
        return new Order(items, size, state, price);
    }
}
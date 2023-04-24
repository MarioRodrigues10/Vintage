package vintage.order;

import vintage.item.Item;
import vintage.user.Address;
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
    private Address address; /* ! Address of an Order */

    /**
     * Creates a new Order object with the specified properties.
     * @param items
     * @param size
     * @param state
     * @param price
     */
    public Order(List<Item> items, Size size, State state, BigDecimal price, Address address) {
        this.id = UUID.randomUUID();
        this.items = items;
        if (this.items.size() == 1) {
            this.size = Size.SMALL;
        } else if (this.items.size() <= 5) {
            this.size = Size.MEDIUM;
        } else {
            this.size = Size.LARGE;
        }
        this.size = size;
        this.state = state;
        this.price = price;
        this.address = address;
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
        this.address = new Address();
    }

    public Order(Order order) {
        this.id = order.getId();
        this.items = order.getItems();
        this.size = order.getSize();
        this.state = order.getState();
        this.price = order.getPrice();
        this.address = order.getAddress();
    }


    /**
     * Returns the address of the order.
     * @return address
     */
    public Address getAddress() {
        return this.address;
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
     * Sets the address of the order.
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the price of the order.
     * @return price
     */
    public BigDecimal getPrice() {
        return this.price;
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
        if (items.size() == 1) {
            size = Size.SMALL;
        } else if (items.size() <= 5) {
            size = Size.MEDIUM;
        } else {
            size = Size.LARGE;
        }
        return this.clone();
    }

    /**
     * Calculates the price of an order
     *
     * @return price
     */
    // TODO: calculate total price of an order (base price + carrier)
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
        return this.clone();
    }

    public Order clone() {
        return new Order(this);
    }
}
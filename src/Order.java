import java.math.BigDecimal;
import java.util.ArrayList;

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

    private ArrayList <Item> items; /* ! Items of an Order */
    private Size size; /* ! Size of an Order */
    private State state; /* ! State of an Order */
    private BigDecimal price; /* ! Price of an Order */


    /**
     * Creates a new Order object with default properties.
     */
    public Order() {
        this.items = new ArrayList<>();
        this.size = Size.MEDIUM;
        this.state = State.PENDING;
        this.price = BigDecimal.valueOf(0);
    }

    /**
     * Creates a new Order object with the specified properties.
     * @param items
     * @param size
     * @param state
     * @param price
     */
    public Order(ArrayList<Item> items, Size size, State state, BigDecimal price) {
        this.items = items;
        this.size = size;
        this.state = state;
        this.price = price;
    }

    /**
     * Returns an ArrayList of Items.
     * @return items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Sets the items of the order.
     * @param items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Returns the size of the order.
     * @return size
     */
    public Size getSize() {
        return size;
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
        return state;
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
     * Creates a new Order object with the specified properties.
     *
     * @return Order
     */
    public Order createOrder() {
        return new Order(items, size, state, price);
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

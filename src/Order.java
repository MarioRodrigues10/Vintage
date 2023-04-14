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

    protected ArrayList <Item> items; /* ! Items of an Order */
    protected Size size; /* ! Size of an Order */
    protected State state; /* ! State of an Order */
    protected BigDecimal price; /* ! Price of an Order */

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
     * Adds an item to an Order
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }


    /**
     * Removes an item from an Order
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Calculates the price of an order
     *
     * @return price
     */
    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(0);
        for (Item item : items) {
            price = price.add(item.getPrice());
        }
        return price;
    }
}

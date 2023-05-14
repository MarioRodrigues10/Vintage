package vintage.module.order;

import vintage.module.item.Item;
import vintage.module.order.receipt.BuyerReceipt;
import vintage.module.order.receipt.*;
import vintage.module.order.receipt.SellerReceipt;
import vintage.module.time.Time;
import vintage.module.user.User;
import vintage.module.others.Address;
import vintage.module.user.UserListings;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;

/**
 * Defines an Order
 */
public class Order implements Serializable {
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
        PENDING, FINISHED, DELIVERED
    }

    private final UUID id; /* ! ID of an Order */
    private User buyer; /* ! Buyer of the Order */
    private Map<Item, State> items; /* ! Items of an Order */
    private Size size; /* ! Size of an Order */
    private State state; /* ! State of an Order */
    private BigDecimal price; /* ! Price of an Order */
    private Address address; /* ! Address of an Order */
    private LocalDate expeditionDate; /* ! Expedition date of an Order */

    /**
     * Creates a new Order object with the specified properties.
     * @param buyer
     * @param items
     * @param size
     * @param state
     * @param price
     */
    public Order(User buyer,Map <Item, State> items, Size size, State state, BigDecimal price, Address address) {
        this.id = UUID.randomUUID();
        this.buyer = buyer;
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
     * Creates a new Order object based on another Order object.
     * @param order
     */
    public Order(Order order) {
        this.id = order.getId();
        this.buyer = order.getBuyer();
        this.items = order.getItems();
        this.size = order.getSize();
        this.state = order.getState();
        this.price = order.getPrice();
        this.address = order.getAddress().clone();
    }


    /**
     * Sets the buyer of the order.
     * @param buyer
     */
    public void setBuyer(User buyer) { this.buyer = buyer; }

    /**
     * Sets the size of the order.
     * @param size
     */
    public void setSize(Size size) { this.size = size; }

    /**
     * Returns the expeditionDate of the order.
     * @return LocalDate
     */
    public LocalDate getExpeditionDate() { return expeditionDate; }

    /**
     * Sets the expeditionDate of the order.
     * @param expeditionDate
     */
    public void setExpeditionDate(LocalDate expeditionDate) { this.expeditionDate = expeditionDate; }

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
     * Returns a User representing the buyer of the order.
     * @return User
     */
    public User getBuyer() {
        return this.buyer;
    }

    /**
     * Returns a Map of Items and their states.
     * @return items
     */
    public Map<Item, State> getItems() {
        // turn the map into a list
        return Map.copyOf(this.items);

    }

    /**
     * Returns an ArrayList of Items.
     * @return items
     */
    public List<Item> getItemsList() {
        List<Item> itemsList = new ArrayList<Item>();
        for (Map.Entry<Item, State> entry : this.items.entrySet()) {
            itemsList.add(entry.getKey());
        }
        return itemsList;
    }

    /**
     * Sets the items of the order.
     * @param items
     */
    public void setItems(Map<Item, State> items) {
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
     * Returns the number of items in the order.
     * @return numItems
     */
    public int getNumItems() {
        return this.items.size();
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
    private void setState(State state) {
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
     * Gets the list of sellers of the order
     *
     * @return sellers list of the order
     */
    public List<User> getOrderSellersList() {
        List<User> sellers = new ArrayList<User>();
        for (Item item : this.getItemsList()) {
            if (!sellers.contains(item.getOwner())) {
                sellers.add(item.getOwner());
            }
        }

        return sellers;
    }

    /**
     * Adds an Item to an Order
     *
     * @param item item to be added
     */
    public void addItem(Item item) {
        if (this.state != State.PENDING) {
            throw new IllegalArgumentException("Cannot add item to order that is not pending");
        }

        this.items.put(item, State.PENDING);
        if (items.size() == 1) {
            size = Size.SMALL;
        } else if (items.size() <= 5) {
            size = Size.MEDIUM;
        } else {
            size = Size.LARGE;
        }

        this.price = this.price.add(item.getPrice());
    }

    /**
     * Calculates the price of an order
     *
     * @return price
     */
    // TODO: calculate total price of an order (base price + carrier)
    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(0);
        for (Item item : items.keySet()) {
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
    public Order removeItem(Item item) {
        items.remove(item);
        return this.clone();
    }

    /**
     * Removes an Item from an Order
     * @param itemId
     */
     public void removeItemById(UUID itemId) {
         for (Map.Entry<Item, State> entry : items.entrySet()) {
             if (entry.getKey().getId().equals(itemId)) {
                 items.remove(entry.getKey());
                 break;
             }
         }
     }

    public Order clone() {
        return new Order(this);
    }

    /**
     * Updates the state of an Order
     * If all items are delivered, the order is delivered
     */
    public void updateDeliveryState() {
        LocalDate currentDate = Time.getInstance().getCurrentDate();

        int deliveredItems = 0;
        int totalItems = 0;
        for (Map.Entry<Item, State> entry : items.entrySet()) {
            ++totalItems;

            if (entry.getValue() == State.PENDING) {
                Item item = entry.getKey();
                int deliveryTime = item.getCarrier().getDeliveryTime();
                LocalDate deliveryDate = this.expeditionDate.plusDays(deliveryTime);

                if (currentDate.isAfter(deliveryDate) || currentDate.isEqual(deliveryDate)) {
                    entry.setValue(State.DELIVERED);
                    ++deliveredItems;
                }
            }
            else if (entry.getValue() == State.DELIVERED) {
                ++deliveredItems;
            }
        }

        if (deliveredItems == totalItems && totalItems != 0) {
            this.setState(State.DELIVERED);
        }
    }

    /**
     * Sets the state of an order to finish
     */
    public void finishOrder() {
        if (this.state != State.PENDING) {
            throw new IllegalStateException("Order is not pending");
        }

        this.setState(State.FINISHED);
        this.expeditionDate = Time.getInstance().getCurrentDate();

        Receipt buyerReceipt = new BuyerReceipt(this.getOrderSellersList(), this.price, List.copyOf(this.getItemsList()), this.expeditionDate, this);
        this.buyer.addReceipt(buyerReceipt);

        // send receipts to all the sellers
        for (Map.Entry<Item, State> entry : items.entrySet()) {
            Item item = entry.getKey();
            User seller = item.getOwner();
            // get receipt from seller
            Receipt sellerReceipt = seller.getOrderIdReceipt(this.id);
            if (sellerReceipt == null) {
                ArrayList<Item> items = new ArrayList<Item>();
                sellerReceipt = new SellerReceipt(this.buyer, BigDecimal.valueOf(0), new ArrayList<Item>(),
                        this.expeditionDate, this);

                ((SellerReceipt) sellerReceipt).setBuyer(this.buyer);
                sellerReceipt.setEmissionDate(this.expeditionDate);
                sellerReceipt.setOrderID(this.id);
            }
            sellerReceipt.addItem(item);
            UserListings.getInstance().getUser(item.getOwner().getEmail()).removeItem(item);
        }
    }
}
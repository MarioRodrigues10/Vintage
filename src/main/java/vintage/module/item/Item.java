package vintage.module.item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import vintage.module.item.carrier.Carrier;
import vintage.module.user.User;


/**
 * Defines a Item
 */
public abstract class Item implements Serializable {
    private final UUID id; /* ! ID of an Item */
    private User owner; /* ! Owner of the item */
    private String description; /* ! Description of an Item */
    private String brand; /* ! Brand of an Item */
    private int evaluation; /*! Defines the evaluation of an Item, in a scale from 1 to 10 */
    private BigDecimal price; /* ! Price of an Item */
    private int owners; /* ! Number of previous owners of an Item */
    private Carrier carrier;


    /**
     * Creates a new Item object with the specified properties.
     *
     * @param description a String containing a brief description of the item
     * @param owner       a User object representing item's owner
     * @param brand       a String containing the brand or manufacturer of the item
     * @param evaluation  an integer value representing the degree of correction needed for the item
     * @param price       a BigDecimal object containing the price of the item
     * @param owners      an integer value representing the number of previous owners of the item
     * @param carrier     a Carrier object containing the carrier of the item
     */
    public Item(String description, User owner, String brand, int evaluation, BigDecimal price, int owners, Carrier carrier) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.description = description;
        this.brand = brand;
        this.evaluation = evaluation;
        this.price = price;
        this.owners = owners;
        this.carrier = new Carrier(carrier);
    }

    /**
     * Returns a String containing a brief description of the item.
     *
     * @return a String containing a brief description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a User object representing item's owner.
     *
     * @return a User object representing item's owner
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * Returns a String containing the brand or manufacturer of the item.
     *
     * @return a String containing the brand or manufacturer of the item
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns a String containing a unique identifier for the item.
     *
     * @return a String containing a unique identifier for the item
     */
    public UUID getId() {
        return id;
    }

    /**
     * Returns an integer value representing the degree of correction needed for the item.
     *
     * @return an integer value representing the degree of correction needed for the item
     */
    public int getEvaluation() {
        return evaluation;
    }

    /**
     * Returns a BigDecimal object containing the price of the item.
     *
     * @return a BigDecimal object containing the price of the item
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns an integer value representing the number of previous owners of the item.
     *
     * @return an integer value representing the number of previous owners of the item
     */
    public int getOwners() {
        return owners;
    }

    /**
     * Returns a User object representing item's owner.
     *
     * @return User
     */
    public User getUser() {
        return owner;
    }

    /**
     * Returns a Carrier object containing the carrier of the item.
     *
     * @return a Carrier object containing the carrier of the item
     */
    public Carrier getCarrier() {
        return this.carrier;
    }

    /**
     * Returns a boolean value representing if the item is used or not.
     *
     * @return a boolean value representing if the item is used or not
     */
    public boolean isUsed() {
        return (owners > 0);
    }


    /**
     * Sets the price of the item.
     *
     * @param price a BigDecimal object containing the price of the item
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Sets the number of previous owners of the item.
     *
     * @param owners an integer value representing the number of previous owners of the item
     */
    public void setOwners(int owners) {
        this.owners = owners;
    }

    /**
     * Sets the owner of the item.
     *
     * @param owner a User representing the item's owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    ;

    /**
     * Sets the evaluation of the item.
     *
     * @param evaluation an integer value representing the evaluation of the item
     */
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    /**
     * Sets the description of the item.
     *
     * @param description a String containing a brief description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the brand of the item.
     *
     * @param brand a String containing the brand or manufacturer of the item
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Sets the carrier of the item.
     *
     * @param carrier a Carrier object containing the carrier of the item
     */
    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }


    /**
     * Returns a String containing a brief description of the item.
     *
     * @return a String containing a brief description of the item
     */
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", evaluation=" + evaluation +
                ", price=" + price +
                ", owners=" + owners +
                ", carrier=" + carrier +
                '}';
    }

    /**
     * Returns a boolean value representing if the item is equal to another item.
     *
     * @param obj an Object representing the item to be compared
     * @return a boolean value representing if the item is equal to another item
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Item artigo = (Item) obj;
        return artigo.id.equals(this.id);
    }

    /**
     * Returns a BigDecimal object containing the price of the item.
     *
     * @return a BigDecimal object containing the price of the item
     */
    public abstract BigDecimal calculatePrice();

    public abstract Item clone();
}

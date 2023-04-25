package vintage.receipt;

import vintage.item.Item;

import java.util.Objects;
import java.util.UUID;

/**
 * Defines a Receipt
 */
public abstract class Receipt {

    private UUID id; /* ! ID of a Receipt */


    /**
     * Creates a new Receipt object with the default properties.
     */
    public Receipt() {
        this.id = UUID.randomUUID();
    }

    /**
     * Creates a new Receipt object with the specified properties.
     *
     * @param id
     */
    public Receipt(UUID id) {
        this.id = id;
    }

    /**
     * Creates a new Receipt object based on another Receipt object.
     *
     * @param receipt
     */
    public Receipt(Receipt receipt) {
        this.id = receipt.getId();
    }

    /**
     * Returns the ID of the order.
     * @return ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the ID of a Receipt
     * @param id ID of a Receipt
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Method that turns the Receipt into a String
     * @return a String representing the Receipt
     */
    public abstract String toString();

    /**
     * Method that clones a Receipt
     * @return Receipt
     */
    public abstract Receipt clone();

}


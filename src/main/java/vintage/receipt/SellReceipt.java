package vintage.receipt;

import vintage.item.Item;

/**
 * Defines a Sell Receipt
 */
public class SellReceipt extends Receipt {

    private Item item; /* ! Item of a SellReceipt */

    /**
     * Creates a new SellReceipt object with the specified properties.
     *
     * @param item
     */
    public SellReceipt(vintage.item.Item item) {

        super();
        this.item = item;

    }

    /**
     * Creates a new SellReceipt object based on another SellReceipt object.
     *
     * @param receipt
     */
    public SellReceipt(SellReceipt receipt) {

        super();
        this.item = receipt.getItem();

    }

    /**
     * Returns the Item of the SellReceipt.
     * @return Item
     */
    public Item getItem() { return item; }

    /**
     * Sets the Item of a SellReceipt
     * @param item Item of the SellReceipt
     */
    public void setItem(Item item) { this.item = item; }

    /**
     * Method that turns the SellReceipt into a String
     * @return a String representing the SellReceipt
     */
    @Override
    public String toString() {
        return "SellReceipt{" +
                "id=" + this.getId() +
                "item=" + item +
                '}';
    }

    /**
     * Method that clones a SellReceipt
     * @return SellReceipt
     */
    public SellReceipt clone() { return new SellReceipt(this); }
}

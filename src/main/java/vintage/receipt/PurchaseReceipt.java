package vintage.receipt;

import vintage.order.Order;

/**
 * Defines a Purchase Receipt
 */
public class PurchaseReceipt extends Receipt{

    private vintage.order.Order order; /* ! Order of a Receipt */

    /**
     * Creates a new PurchaseReceipt object with the specified properties.
     *
     * @param order
     */
    public PurchaseReceipt(vintage.order.Order order) {

        super();
        this.order = order;

    }

    /**
     * Creates a new PurchaseReceipt object based on another PurchaseReceipt object.
     *
     * @param receipt
     */
    public PurchaseReceipt(PurchaseReceipt receipt) {

        super();
        this.order = receipt.getOrder();

    }

    /**
     * Returns the Order of the PurchaseReceipt.
     * @return Order
     */
    public Order getOrder() { return order; }

    /**
     * Sets the Order of a PurchaseReceipt
     * @param order Order of the PurchaseReceipt
     */
    public void setOrder(Order order) { this.order = order; }

    /**
     * Method that turns the PurchaseReceipt into a String
     * @return a String representing the PurchaseReceipt
     */
    @Override
    public String toString() {
        return "PurchaseReceipt{" +
                "id=" + this.getId() +
                "order=" + order +
                '}';
    }

    /**
     * Method that clones a PurchaseReceipt
     * @return PurchaseReceipt
     */
    public PurchaseReceipt clone() { return new PurchaseReceipt(this); }

}

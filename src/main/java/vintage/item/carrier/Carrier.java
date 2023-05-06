package vintage.item.carrier;

import java.math.BigDecimal;

public class Carrier {
    public static BigDecimal SMALL = new BigDecimal("5.0"); // !< Small orders price
    public static BigDecimal MEDIUM = new BigDecimal("10.0"); // !< Medium orders price
    public static BigDecimal LARGE = new BigDecimal("15.0"); // !< Large orders price
    public static BigDecimal tax = new BigDecimal("0.1"); // !< Tax rate
    private String name; // !< Name of the carrier
    private BigDecimal profit; // !< Profit of the carrier in percentage of the shipping base price
    private int deliveryTime; // !< Delivery time of the carrier
    private boolean premium; // !< Premium status of the carrier

    /**
     * Creates a new Carrier object with the specified properties.
     *
     * @param name a String containing the name of the carrier
     * @param profit a BigDecimal object containing the profit of the carrier
     * @param premium a boolean value representing the premium status of the carrier
     */
    public Carrier(String name, BigDecimal profit, boolean premium, int deliveryTime) {
        this.name = name;
        this.profit = profit;
        this.deliveryTime = deliveryTime;
        this.premium = premium;
    }

    /**
     * Creates a new Carrier object based on another Carrier object.
     *
     * @param carrier a Carrier object
     */
    public Carrier(Carrier carrier) {
        this.name = carrier.getName();
        this.profit = carrier.getProfit();
        this.deliveryTime = carrier.getDeliveryTime();
        this.premium = carrier.isPremium();
    }

    /**
     * Creates a new Carrier object with default properties.
     */
    public Carrier() {
        this.name = "";
        this.profit = new BigDecimal("0.0");
        this.deliveryTime = 3;
        this.premium = false;
    }

    /**
     * Sets the price of a small order.
     *
     * @param SMALL a BigDecimal object containing the price of a small order
     */
    public void setSMALL(BigDecimal SMALL) {
        Carrier.SMALL = SMALL;
    }

    /**
     * Sets the price of a medium order.
     *
     * @param MEDIUM a BigDecimal object containing the price of a medium order
     */
    public void setMEDIUM(BigDecimal MEDIUM) {
        Carrier.MEDIUM = MEDIUM;
    }

    /**
     * Sets the price of a large order.
     *
     * @param LARGE a BigDecimal object containing the price of a large order
     */
    public void setLARGE(BigDecimal LARGE) {
        Carrier.LARGE = LARGE;
    }

    /**
     * Sets the tax rate.
     *
     * @param tax a BigDecimal object containing the tax rate
     */
    public void setTax(BigDecimal tax) {
        Carrier.tax = tax;
    }

    /**
     * Returns a String containing the name of the carrier.
     *
     * @return a String containing the name of the carrier
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a BigDecimal object containing the profit of the carrier.
     *
     * @return a BigDecimal object containing the profit of the carrier
     */
    public BigDecimal getProfit() {
        return profit;
    }

    /**
     * Returns an integer value representing the delivery time of the carrier.
     *
     * @return an integer value representing the delivery time of the carrier
     */
    public int getDeliveryTime() {
        return this.deliveryTime;
    }

    /**
     * Returns a boolean value representing the premium status of the carrier.
     *
     * @return a boolean value representing the premium status of the carrier
     */
    public boolean isPremium() {
        return this.premium;
    }

    /**
     * Sets the name of the carrier.
     *
     * @param name a String containing the name of the carrier
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the profit of the carrier.
     *
     * @param profit a BigDecimal object containing the profit of the carrier
     */
    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    /**
     * Sets the premium status of the carrier.
     *
     * @param premium a boolean value representing the premium status of the carrier
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    /**
     * Sets the delivery time of the carrier.
     *
     * @param deliveryTime an integer value representing the delivery time of the carrier
     */
    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * Returns a String representation of the Carrier object.
     *
     * @return a String representation of the Carrier object
     */
    @Override
    public String toString() {
        return "Carrier{" +
                "name='" + name + '\'' +
                ", profit=" + profit +
                ", premium=" + premium +
                '}';
    }

    public Carrier clone(Carrier carrier) {
        return new Carrier(this);
    }

    /**
     * Calculates the shipping cost of an order.
     *
     * @param size an int containing the size of the order
     * @return a BigDecimal object containing the shipping cost of the order
     */
    // TODO: fix the shipping cost calculation
    public BigDecimal calculateShippingCost(int size) {
        BigDecimal basePrice = new BigDecimal("0.0");
        if (size == 1) {
            basePrice = SMALL;
        } else if (size <= 5) {
            basePrice = MEDIUM;
        } else {
            basePrice = LARGE;
        }

        return basePrice.multiply(profit).multiply(tax.add(BigDecimal.valueOf(1.0))).multiply(BigDecimal.valueOf(0.9));
    }

    /**
     * Calculates the shipping cost of an order premium.
     *
     * @param size an int containing the size of the order
     * @return a BigDecimal object containing the shipping cost of the order
     */
    public BigDecimal calculateShippingCostPremium(int size) {
        BigDecimal basePrice = new BigDecimal("0.0");
        if (size == 1) {
            basePrice = SMALL;
        } else if (size <= 5) {
            basePrice = MEDIUM;
        } else {
            basePrice = LARGE;
        }

        return basePrice.multiply(profit).multiply(tax.add(BigDecimal.valueOf(1.0)));
    }
}

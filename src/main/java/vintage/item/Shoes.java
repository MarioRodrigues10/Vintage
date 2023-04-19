package vintage.item;

import java.math.BigDecimal;
import java.time.Year;

/**
 * Defines a Shoes
 */
public class Shoes extends Item {
    private double size; /* ! Size of a Shoes */
    private boolean laces; /* ! Laces of a Shoes */
    private String color; /* ! Color of a Shoes */
    private int release; /* ! Release Year of a Shoes */

    /**
     * Creates a new Shoes object with the specified properties.
     *
     * @param description a String containing a brief description of the item
     * @param brand a String containing the brand or manufacturer of the item
     * @param price a BigDecimal object containing the price of the item
     * @param owners an integer value representing the number of previous owners of the item
     * @param size an integer value representing the size of the shoes
     * @param laces a boolean value representing the laces of the shoes
     * @param color a String containing the color of the shoes
     * @param release an integer value representing the release year of the shoes
     */
    public Shoes(String description, String brand, BigDecimal price, boolean used, int owners, double size, boolean laces, String color, int release) {
        super(description, brand, price, owners, used);
        this.size = size;
        this.laces = laces;
        this.color = color;
        this.release = release;
    }
    public Shoes(Shoes shoes) {
        super(shoes.getDescription(), shoes.getBrand(), shoes.getPrice(), shoes.getOwners(), shoes.isUsed());
        this.size = shoes.getSize();
        this.laces = shoes.isLaces();
        this.color = shoes.getColor();
        this.release = shoes.getRelease();
    }

    /**
     * Returns an integer value representing the size of the shoes.
     *
     * @return an integer value representing the size of the shoes
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the size of the shoes.
     *
     *  @param size an integer value representing the size of the shoes
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Returns a boolean value representing the laces of the shoes.
     *
     * @return a boolean value representing the laces of the shoes
     */
    public boolean isLaces() {
        return laces;
    }

    /**
     * Sets the laces of the shoes.
     *
     * @param laces a boolean value representing if the shoes has laces
     */
    public void setLaces(boolean laces) {
        this.laces = laces;
    }

    /**
     * Returns a String containing the color of the shoes.
     *
     * @return a String containing the color of the shoes
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the shoes.
     *
     * @param color a String containing the color of the shoes
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns an integer value representing the release year of the shoes.
     *
     * @return an integer value representing the release year of the shoes
     */
    public int getRelease() {
        return release;
    }

    /**
     * Sets the release year of the shoes.
     *
     * @param release an integer value representing the release year of the shoes
     */
    public void setRelease(int release) {
        this.release = release;
    }

    /**
     * Returns a String containing a brief description of the item.
     *
     * @return a String containing a brief description of the item
     */
    public String toString() {
        return "Shoes [description=" + getDescription() + ", brand=" + getBrand() + ", id=" + getId() + ", Base price=" + getPrice() + ", Price=" + calculatePrice() + ", used=" + isUsed() + ", owners=" + getOwners() + ", size=" + getSize() + ", laces=" + laces + ", color=" + color + ", release=" + release + "]";
    }

    /**
     * A utility class that provides a method for calculating the price of a BAG based on its base
     * price, number of owners, and utilization state.
     */
    public class PricingCalculator {

        /**
         * Calculates the price of SHOES, taking into account the base price, number of owners,
         * and utilization state.
         *
         * @param basePrice a BigDecimal object containing the base price of the SHOES
         * @param numberOfOwners an integer value representing the number of previous owners of the SHOES
         * @param utilizationState an integer value representing the utilization state of the SHOES
         * @return the price of the SHOES
         */
        public static BigDecimal calculatePrice(BigDecimal basePrice, int numberOfOwners, int utilizationState) {
            BigDecimal owners = new BigDecimal(numberOfOwners);
            BigDecimal divisor = owners.multiply(new BigDecimal(utilizationState));
            BigDecimal factor = basePrice.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal price = basePrice.subtract(factor);
            return price;
        }
    }

    /**
     * Calculates the price of an Item, taking into account the base price, number of owners,
     * utilization state, and any additional criteria.
     *
     * @return the price of the Item
     */
    public BigDecimal calculatePrice() {
        BigDecimal price = getPrice();
        if (isUsed() || getSize() > 45 || getRelease() > Year.now().getValue()) {
            price =  PricingCalculator.calculatePrice(getPrice(), getOwners(), getEvaluation());
        }
        return price;
    }

    /**
     * Returns a deep clone of the Shoes.
     *
     * @return a clone of the Shoes
     */
    public Shoes clone() {
        return new Shoes(this);
    }
}
import java.math.BigDecimal;
import java.time.Year;

/**
 * Defines a Bag
 */
public class Bag extends Item{
    private int size; /* ! Size of a Bag */
    private String material; /* ! Material of a Bag */
    private int release; /* ! Release Year of a Bag */

    /**
     * Creates a new Bag object with the specified properties.
     *
     * @param description a String containing a brief description of the item
     * @param brand a String containing the brand or manufacturer of the item
     * @param id a String containing a unique identifier for the item
     * @param price a BigDecimal object containing the price of the item
     * @param correction an integer value representing the discount for an item
     * @param owners an integer value representing the number of previous owners of the item
     * @param size an integer value representing the size of the bag
     * @param material a String containing the material of the bag
     * @param release an integer value representing the release year of the bag
     */
    public Bag(String description, String brand, String id, BigDecimal price, int correction, boolean used , int owners, int size, String material, int release) {
        super(description, brand, id, price, correction, owners, used);
        this.size = size;
        this.material = material;
        this.release = release;
    }

    /**
     * Returns an integer value representing the size of the bag.
     *
     * @return an integer value representing the size of the bag
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the bag.
     *
     * @param size an integer value representing the size of the bag
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns a String containing the material of the bag.
     *
     * @return a String containing the material of the bag
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material of the bag.
     *
     * @param material a String containing the material of the bag
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Returns an integer value representing the release year of the bag.
     *
     * @return an integer value representing the release year of the bag
     */
    public int getRelease() {
        return release;
    }

    /**
     * Sets the release year of the bag.
     *
     * @param release an integer value representing the release year of the bag
     */
    public void setRelease(int release) {
        this.release = release;
    }

    /**
     * Returns a String containing a brief description of the Bag.
     *
     * @return a String containing a brief description of the Bag
     */
    public String toString() {
        return "Bag [description=" + getDescription() + ", brand=" + getBrand() + ", id=" + getId() + ", price=" + getPrice() + ", correction=" + getCorrection() + ", used=" + isUsed() + ", owners=" + getOwners() + ", size=" + getSize() + ", material=" + getMaterial() + ", release=" + getRelease() + "]";
    }

    /**
     * A utility class that provides a method for calculating the price of a BAG based on its base
     * price, number of owners, and utilization state.
     */
    public class PricingCalculator {

        /**
         * Calculates the price of a BAG, taking into account the base price, number of owners,
         * and utilization state.
         *
         * @param basePrice a BigDecimal object containing the base price of the BAG
         * @param numberOfOwners an integer value representing the number of previous owners of the BAG
         * @param utilizationState an integer value representing the utilization state of the BAG
         * @return the price of the BAG
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
}
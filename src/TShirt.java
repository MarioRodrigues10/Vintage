import java.math.BigDecimal;

/**
 * Defines a TShirt
 */
public class TShirt extends Item{

    /**
     * Enumerates the sizes of a TShirt
     */
    public enum Size {
        S, M, L, XL
    }

    /**
     * Enumerates the patterns of a TShirt
     */
    public enum Pattern {
       SOLID, STRIPPED, PALM
    }

    private Size size; /* ! Size of a TShirt */
    private Pattern pattern; /* ! Pattern of a TShirt */

    /**
     * Creates a new TShirt object with the specified properties.
     *
     * @param description a String containing a brief description of the item
     * @param brand a String containing the brand or manufacturer of the item
     * @param id a String containing a unique identifier for the item
     * @param price a BigDecimal object containing the price of the item
     * @param correction an integer value representing the discount for an item
     * @param owners an integer value representing the number of previous owners of the item
     * @param size an integer value representing the size of the TShirt
     * @param pattern a String containing the pattern of the TShirt
     */
    public TShirt(String description, String brand, String id, BigDecimal price, int correction, boolean used , int owners, Size size, Pattern pattern) {
        super(description, brand, id, price, correction, owners, used);
        this.size = size;
        this.pattern = pattern;
    }

    /**
     * Returns an integer value representing the size of the TShirt.
     *
     * @return an integer value representing the size of the TShirt
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the size of the TShirt.
     *
     * @param size an integer value representing the size of the TShirt
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Returns a String containing the pattern of the TShirt.
     *
     * @return a String containing the pattern of the TShirt
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern of the TShirt.
     *
     * @param pattern a String containing the pattern of the TShirt
     */
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Returns a String representation of the TShirt object.
     *
     * @return a String representation of the TShirt object
     */
    public String toString() {
        return "TShirt [description=" + getDescription() + ", brand=" + getBrand() + ", id=" + getId() + ", price=" + getPrice() + ", correction=" + getCorrection() + ", used=" + isUsed() + ", owners=" + getOwners() + ", size=" + getSize() + ", pattern=" + pattern + "]";
    }

    /**
     * Returns a BigDecimal object containing the price of the TShirt.
     *
     * @return a BigDecimal object containing the price of the TShirt
     */
    public BigDecimal calculatePrice() {
        BigDecimal price = getPrice();
        if (this.pattern == Pattern.PALM) {
            price =  price.multiply(new BigDecimal(0.5));
        }
        return price;
    }
}
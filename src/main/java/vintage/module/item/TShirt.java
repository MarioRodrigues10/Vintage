package vintage.module.item;

import vintage.module.item.carrier.Carrier;
import vintage.module.user.User;

import java.math.BigDecimal;
import java.io.Serializable;
/**
 * Defines a TShirt
 */
public class TShirt extends Item implements Serializable{

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
     * @param owner a User object containing the owner of the item
     * @param brand a String containing the brand or manufacturer of the item
     * @param evaluation an integer value representing the evaluation of the item
     * @param price a BigDecimal object containing the price of the item
     * @param owners an integer value representing the number of previous owners of the item
     * @param size an integer value representing the size of the TShirt
     * @param pattern a String containing the pattern of the TShirt
     * @param carrier a Carrier object containing the carrier of the item
     */
    public TShirt(String description, User owner, String brand, int evaluation, BigDecimal price, int owners, Size size, Pattern pattern, Carrier carrier) {
        super(description, owner, brand, evaluation, price, owners, carrier);
        this.size = size;
        this.pattern = pattern;
    }

    /**
     * Creates a new TShirt object with default values.
     */
    public TShirt() {
        super();
        this.size = Size.S;
        this.pattern = Pattern.SOLID;
    }

    /**
     * Creates a new TShirt object based on another TShirt object.
     *
     * @param tshirt a TShirt object
     */
    public TShirt(TShirt tshirt) {
        super(tshirt.getDescription(), tshirt.getOwner(), tshirt.getBrand(), tshirt.getEvaluation(), tshirt.getPrice(),  tshirt.getOwners(), tshirt.getCarrier());
        this.size = tshirt.getSize();
        this.pattern = tshirt.getPattern();
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
    @Override
    public String toString() {
        return "TShirt{" +
                "size=" + size +
                ", pattern=" + pattern +
                ", description='" + getDescription() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", evaluation=" + getEvaluation() +
                ", price=" + getPrice() +
                ", used=" + isUsed() +
                ", owners=" + getOwners() +
                ", carrier=" + getCarrier() +
                '}';
    }

    /**
     * Returns a boolean value indicating whether the TShirt object is equal to another object.
     *
     * @param obj an object
     * @return a boolean value indicating whether the TShirt object is equal to another object
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            System.out.println("Same instance");
            return true;
        }
        if (!(obj instanceof TShirt)) {
            return false;
        }
        TShirt tshirt = (TShirt) obj;
        return tshirt.getDescription().equals(this.getDescription()) && tshirt.getBrand().equals(this.getBrand()) && tshirt.getPrice().equals(this.getPrice()) && tshirt.calculatePrice() == this.calculatePrice() && tshirt.isUsed() == this.isUsed() && tshirt.getOwners() == this.getOwners() && tshirt.getSize() == this.getSize() && tshirt.getPattern() == this.getPattern();
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

    /**
     * Returns a TShirt object that is a deep clone of the current TShirt object.
     *
     * @return a TShirt object that is a deep clone of the current TShirt object
     */
    public TShirt clone() {
        return new TShirt(this);
    }
}
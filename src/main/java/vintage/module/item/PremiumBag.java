package vintage.module.item;
import vintage.module.item.carrier.Carrier;
import vintage.module.time.Time;
import vintage.module.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PremiumBag extends Bag {
    /**
     * Creates a new PremiumBag object with the specified properties.
     * @param description a String containing a brief description of the item
     * @param brand a String containing the brand or manufacturer of the item
     * @param evaluation an integer value representing the evaluation of the item
     * @param price a BigDecimal object containing the price of the item
     * @param owners an integer value representing the number of previous owners of the item
     * @param size an integer value representing the size of the bag
     * @param material a String containing the material of the bag
     * @param release an integer value representing the release year of the bag
     * @param carrier a Carrier object containing the carrier of the item
     */
    public PremiumBag(String description, User owner, String brand, int evaluation, BigDecimal price, int owners, int size, String material, int release, Carrier carrier) {
        super(description, owner, brand, evaluation, price, owners, size, material, release, carrier);
    }

    /**
     * The calculatePrice() method calculates the price of the premium bag by calling the getPrice() method
     */
    @Override
    public BigDecimal calculatePrice() {
        Time time = Time.getInstance();
        LocalDate currentDate = time.getCurrentDate();

        double increasingPercentage = 0.10; // increases its value 10% each year
        double yearsSinceRelease = currentDate.getYear() - getRelease();

        BigDecimal price = getPrice();
        price = price.add(price.multiply(BigDecimal.valueOf(increasingPercentage * yearsSinceRelease)));

        return price;
    }

    @Override
    public String toString() {
        return "PremiumBag{" +
                "id=" + getId() +
                ", owner=" + getOwner() +
                ", description='" + getDescription() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", evaluation=" + getEvaluation() +
                ", price=" + getPrice() +
                ", owners=" + getOwners() +
                ", size=" + getSize() +
                ", material='" + getMaterial() + '\'' +
                ", release=" + getRelease() +
                ", carrier=" + getCarrier() +
                '}';
    }
}

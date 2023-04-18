package vintage.item;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PremiumShoes extends Shoes {
    /**
     * Creates a new PremiumShoes object with the specified properties.
     *
     * @param description
     * @param brand
     * @param price
     * @param used
     * @param owners
     * @param size
     * @param laces
     * @param color
     * @param release
     */
    public PremiumShoes(String description, String brand, BigDecimal price, boolean used, int owners, double size, boolean laces, String color, int release) {
        super(description, brand, price, used, owners, size, laces, color, release);
    }

    /**
     * The calculatePrice() method calculates the price of the premium shoe by calling the getPrice() method
     * (which is inherited from the Shoe class) to get the base price, and then adds a premium based on the
     * shoe's special edition status and years since release.
     *
     * @return a BigDecimal object containing the price of the premium shoe
     */
    @Override
    public BigDecimal calculatePrice() {
        double increasingPercentage = 0.10; // increases its value 10% each year
        double yearsSinceRelease = LocalDate.now().getYear() - getRelease();

        BigDecimal price = getPrice();
        price = price.add(price.multiply(BigDecimal.valueOf(increasingPercentage * yearsSinceRelease)));

        return price;
    }
}

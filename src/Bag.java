import java.math.BigDecimal;

public class Bag extends Artigo {
    protected int size;
    protected String material;
    protected int release;

    public Bag(String description, String brand, String id, BigDecimal price, int correction, boolean used , int owners, int size, String material, int release) {
        super(description, brand, id, price, correction, owners, used);
        this.size = size;
        this.material = material;
        this.release = release;
    }
}
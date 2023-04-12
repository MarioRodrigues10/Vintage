import java.math.BigDecimal;

public class Shoes extends Artigo {
    protected double size;
    protected boolean laces;
    protected String color;
    protected int release;
    public Shoes(String description, String brand, String id, BigDecimal price, int correction, boolean used, int owners, double size, boolean laces, String color, int release) {
        super(description, brand, id, price, correction, owners, used);
        this.size = size;
        this.laces = laces;
        this.color = color;
        this.release = release;
    }
}
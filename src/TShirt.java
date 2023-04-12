import java.math.BigDecimal;
public class TShirt extends Artigo{
    public enum Size {
        S, M, L, XL
    }
    public enum Pattern {
       SOLID, STRIPPED, PALM
    }
    protected Size size;
    protected Pattern pattern;

    public TShirt(String description, String brand, String id, BigDecimal price, int correction, boolean used , int owners, Size size, Pattern pattern) {
        super(description, brand, id, price, correction, owners, used);
        this.size = size;
        this.pattern = pattern;
    }


}
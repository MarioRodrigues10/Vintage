import java.math.BigDecimal;

public abstract class Artigo {
    protected String description;
    protected String brand;
    protected String id;
    protected int evaluation;
    protected BigDecimal price;
    protected int correction;
    protected boolean used;

    protected int owners;

    // TODO: Owners && Premium && Carrier

    public Artigo(String description, String brand, String id, BigDecimal price, int correction, int owners, boolean used) {
        this.description= description;
        this.brand = brand;
        this.id = id;
        this.price = price;
        this.correction = correction;
        this.owners = owners;
        this.used = used;
    }
}
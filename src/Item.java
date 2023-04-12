import java.math.BigDecimal;


/**
 * Defines a Item
 */
public abstract class Item {
    protected String description; /* ! Description of an Item */
    protected String brand; /* ! Brand of an Item */
    protected String id; /* ! ID of an Item */
    protected int evaluation; /*! Defines the evaluation of an Item, in a scale from 1 to 10 */
    protected BigDecimal price; /* ! Price of an Item */
    protected int correction; /* ! Discount of an Item */
    protected boolean used; /* ! Defines if an Item is used or not */

    protected int owners; /* ! Number of previous owners of an Item */

    // TODO: Owners && Premium && Carrier

    /**
        * Creates a new Item object with the specified properties.
        *
        * @param description a String containing a brief description of the item
        * @param brand a String containing the brand or manufacturer of the item
        * @param id a String containing a unique identifier for the item
        * @param price a BigDecimal object containing the price of the item
        * @param correction an integer value representing the discount for an item
        * @param owners an integer value representing the number of previous owners of the item
    */
    public Item(String description, String brand, String id, BigDecimal price, int correction, int owners, boolean used) {
        this.description= description;
        this.brand = brand;
        this.id = id;
        this.price = price;
        this.correction = correction;
        this.owners = owners;
        this.used = used;
    }

    /**
        * Returns a String containing a brief description of the item.
        *
        * @return a String containing a brief description of the item
    */
    public String getDescription() {
        return description;
    }

    /**
        * Returns a String containing the brand or manufacturer of the item.
        *
        * @return a String containing the brand or manufacturer of the item
    */
    public String getBrand() {
        return brand;
    }

    /**
        * Returns a String containing a unique identifier for the item.
        *
        * @return a String containing a unique identifier for the item
    */
    public String getId() {
        return id;
    }

    /**
        * Returns an integer value representing the degree of correction needed for the item.
        *
        * @return an integer value representing the degree of correction needed for the item
    */
    public int getEvaluation() {
        return evaluation;
    }

    /**
        * Returns a BigDecimal object containing the price of the item.
        *
        * @return a BigDecimal object containing the price of the item
    */
    public BigDecimal getPrice() {
        return price;
    }

    /**
        * Returns an integer value representing the degree of correction needed for the item.
        *
        * @return an integer value representing the degree of correction needed for the item
    */
    public int getCorrection() {
        return correction;
    }

    /**
        * Returns an integer value representing the number of previous owners of the item.
        *
        * @return an integer value representing the number of previous owners of the item
    */
    public int getOwners() {
        return owners;
    }

    /**
        * Returns a boolean value representing if the item is used or not.
        *
        * @return a boolean value representing if the item is used or not
    */
    public boolean isUsed() {
        return used;
    }

    /**
        * Sets the used value of the item.
        *
        * @param used a boolean value representing if the item is used or not
    */
    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
        * Sets the price of the item.
        *
        * @param price a BigDecimal object containing the price of the item
    */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
        * Sets the degree of correction needed for the item.
        *
        * @param correction an integer value representing the degree of correction needed for the item
    */
    public void setCorrection(int correction) {
        this.correction = correction;
    }

    /**
        * Sets the number of previous owners of the item.
        *
        * @param owners an integer value representing the number of previous owners of the item
    */
    public void setOwners(int owners) {
        this.owners = owners;
    }

    /**
        * Sets the evaluation of the item.
        *
        * @param evaluation an integer value representing the evaluation of the item
    */
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    /**
        * Sets the description of the item.
        *
        * @param description a String containing a brief description of the item
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
        * Sets the brand of the item.
        *
        * @param brand a String containing the brand or manufacturer of the item
    */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
        * Sets the id of the item.
        *
        * @param id a String containing a unique identifier for the item
    */
    public void setId(String id) {
        this.id = id;
    }

    /**
        * Returns a String containing a brief description of the item.
        *
        * @return a String containing a brief description of the item
    */
    public String toString() {
        return "Artigo: " + description + " | Marca: " + brand + " | ID: " + id + " | Preço: " + price + " | Correção: " + correction + " | Usado: " + used + " | Proprietários: " + owners;
    }

    /**
        * Returns a boolean value representing if the item is equal to another item.
        *
        * @param obj an Object representing the item to be compared
        * @return a boolean value representing if the item is equal to another item
    */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Item artigo = (Item) obj;
        return artigo.id.equals(this.id);
    }

    /**
        * Returns a BigDecimal object containing the price of the item.
        *
        * @return a BigDecimal object containing the price of the item
    */
    public abstract BigDecimal calculatePrice();
}
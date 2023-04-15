import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private Residence residence;
    private String taxNumber;

    public User(String name, String email, Residence residence, String taxNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.residence = residence;
        this.taxNumber = taxNumber;
    }

    public User() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.email = "";
        this.residence = new Residence();
        this.taxNumber = "";
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}

import java.util.UUID;

public class User {
    private final UUID id; /* ! ID of a User */
    private String name; /* ! Name of a User */
    private String email; /* ! Email of a User */
    private Residence residence; /* ! Residence of a User */
    private String taxNumber; /* ! Tax number of a User */

    /**
     * Creates a new User object with the specified properties.
     *
     * @param name a String containing the name of the user
     * @param email a String containing the email of the user
     * @param residence a Residence object containing the residence of the user
     * @param taxNumber a String containing the tax number of the user
     */
    public User(String name, String email, Residence residence, String taxNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.residence = residence;
        this.taxNumber = taxNumber;
    }

    /**
     * Creates a new empty User object.
     */
    public User() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.email = "";
        this.residence = new Residence();
        this.taxNumber = "";
    }

    /**
     * Creates a new User object with the specified user.
     *
     * @param user a User object containing the user
     */
    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.residence = user.getResidence();
        this.taxNumber = user.getTaxNumber();
    }

    /**
     * Returns the ID of a User.
     *
     * @return the ID of a User
     */
    public UUID getId() {
        return id;
    }

    /**
     * Returns the name of a User.
     *
     * @return the name of a User
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a User.
     *
     * @param name a String containing the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email of a User.
     *
     * @return the email of a User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a User.
     *
     * @param email a String containing the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the residence of a User.
     *
     * @return the residence of a User
     */
    public Residence getResidence() {
        return residence;
    }

    /**
     * Sets the residence of a User.
     *
     * @param residence a Residence object containing the residence of the user
     */
    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    /**
     * Returns the tax number of a User.
     *
     * @return the tax number of a User
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets the tax number of a User.
     *
     * @param taxNumber a String containing the tax number of the user
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}

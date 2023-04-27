package vintage.user;

import vintage.receipt.Receipt;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private final UUID id; /* ! ID of a User */
    private String name; /* ! Name of a User */
    private String email; /* ! Email of a User */
    private Address residence; /* ! Residence of a User */
    private String taxNumber; /* ! Tax number of a User */
    private ArrayList<Receipt> receipts = new ArrayList<Receipt>(); 

    /**
     * Creates a new User object with the specified properties.
     *
     * @param name a String containing the name of the user
     * @param email a String containing the email of the user
     * @param residence a Residence object containing the residence of the user
     * @param taxNumber a String containing the tax number of the user
     */
    public User(String name, String email, Address residence, String taxNumber, ArrayList<Receipt> receipts) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.residence = residence;
        this.taxNumber = taxNumber;
        this.receipts = receipts;
    }

    /**
     * Creates a new empty User object.
     */
    public User() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.email = "";
        this.residence = new Address();
        this.taxNumber = "";
        this.receipts = new ArrayList<Receipt>();
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
        this.receipts = user.getReceipts();
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
    public Address getResidence() {
        return residence;
    }

    /**
     * Sets the residence of a User.
     *
     * @param residence a Residence object containing the residence of the user
     */
    public void setResidence(Address residence) {
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

    /**
     * Sets bills of a User.
     *
     * @return the User's Bill's list.
     */
    public ArrayList<Receipt> getReceipts() { return receipts; }

    /**
     * Sets the receipts of a User.
     *
     * @param receipts a Bill's ArrayList containing the receipts of the user
     */
    public void setReceipts(ArrayList<Receipt> receipts) { this.receipts = receipts; }

    /**
     * Adds a Receipt to a Receipt List
     * @param receipt
     */
    public void addReceipt(Receipt receipt) { this.receipts.add(receipt); }

    /**
     * Removes a Receipt to a Receipt List
     * @param receipt
     */
    public void removeReceipt(Receipt receipt) {
        receipts.remove(receipt);
    }

    /**
     * Returns a boolean indicating whether the user is equal to another user.
     * To check if a user is equal to another user, it is only necessary to check if the email is equal.
     *
     * @param user
     * @return boolean
     */
    public boolean equals(User user) {
        return this.email.equals(user.getEmail());
    }
}
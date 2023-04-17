package vintage.user;

public class Residence {
    private String country;
    private String city;
    private String street;
    private String postalCode;

    public Residence(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Residence() {
        this.country = "";
        this.city = "";
        this.street = "";
        this.postalCode = "";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Residence{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Residence residence = (Residence) o;
        return getCountry().equals(residence.getCountry()) && getCity().equals(residence.getCity()) && getStreet().equals(residence.getStreet()) && getPostalCode().equals(residence.getPostalCode());
    }
}
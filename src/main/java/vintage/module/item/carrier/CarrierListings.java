package vintage.module.item.carrier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrierListings implements Serializable {

    private static CarrierListings instance = null;
    private final Map<String, Carrier> carriers; /* ! Map of carriers, where the key is the carrier's name */

    public static CarrierListings getInstance() {
        if (instance == null) {
            instance = new CarrierListings();
        }
        return instance;
    }

    /**
     * Creates a new CarrierListings object with default properties.
     */
    private CarrierListings() { this.carriers = new HashMap<String, Carrier>(); }

    /**
     * Returns the Carrier of the specified name
     *
     * @param name
     * @return
     */
    public Carrier getCarrier(String name) { return this.carriers.get(name); }

    /**
     * Adds a Carrier to the carriers list
     *
     * @param carrier
     */
    public void addCarrier (Carrier carrier) { this.carriers.put(carrier.getName(), carrier); }

    /**
     * Removes a Carrier using the specified name
     *
     * @param name
     */

    public void removeCarrier (String name) { this.carriers.remove(name); }

    /**
     * Returns a list with every carrier
     *
     * @return List of Carriers
     */
    public List<Carrier> getAllCarriers() {
        List<Carrier> carrierList = new ArrayList<Carrier>(this.carriers.values());
        return carrierList;
    }

    public boolean checkCarrier (String name) {
        if (this.carriers.get(name) != null) return true;
        else return false;
    }
}

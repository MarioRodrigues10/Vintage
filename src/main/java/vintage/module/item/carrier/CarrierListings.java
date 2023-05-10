package vintage.module.item.carrier;

import vintage.module.user.UserListings;

import java.io.*;
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

    public void saveCarriers(String folderName) {
        try {
            File file = new File("saves/" + folderName + "/carriers.ser");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fileOut = new FileOutputStream("saves/" + folderName + "/carriers.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCarriers(String folderName) {
        try (FileInputStream fileIn = new FileInputStream("saves/" + folderName + "/carriers.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            CarrierListings carrierListings = (CarrierListings) in.readObject();
            instance = carrierListings;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package vintage.module.user;

import vintage.module.item.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *  Type UserList
 */
public class UserListings implements Serializable {
    private static UserListings instance = null;
    private Map<String, User> users; /* ! Map of Users by Email*/

    /**
     * Returns the instance of UserListings
     *
     * @return UserListings
     */
    public static UserListings getInstance() {
        if (instance == null) {
            instance = new UserListings();
        }
        return instance;
    }

    /**
     * Creates a new UserList object.
     */
    private UserListings() {
        this.users = new HashMap<String, User>();
    }

    /**
     * Returns the list of Users
     *
     * @return Map<String, User>
     */
    public Map<String, User> getUsers() { return Map.copyOf(this.users); }

    /**
     * Adds a User to users
     *
     * @param user
     */
    public void addUser(User user) { users.put(user.getEmail(), user); }

    /**
     * Deletes a User from users. If the user doesn't exist it return false
     *
     * @param email
     * @return boolean
     */
    public boolean deleteUser(String email) {
        if (checkUser(email)) {
            users.remove(email);
            return true;
        }
        else return false;
    }

    /**
     * Checks if a user exists
     *
     * @param email
     * @return boolean
     */
    public boolean checkUser(String email){ return users.containsKey(email); }

    /**
     * Gets a User by its email
     *
     * @param email
     * @return User
     */
    public User getUser(String email) { return users.get(email); }


    /**
     *  Gets a User by its name
     *  @param name
     *  @return User
     */
    public User getUserByName(String name) {
        for (User user : users.values()) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

    /**
     * Checks if a certain email is available
     *
     * @param email
     * @return boolean
     */
    public boolean isEmailAvailable(String email) { return users.containsKey(email); }

    public List<Item> getAllItems() {
        List<User> users = new ArrayList<User>(this.users.values());
        List<Item> items = new ArrayList<Item>();

        for(User user : users) {
            items.addAll(user.getItems());
        }
        return items;
    }

    public void saveUsers(String folderName) {
        try {
            File file = new File("saves/" + folderName + "/users.ser");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fileOut = new FileOutputStream("saves/" + folderName + "/users.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(String folderName) {
        try (FileInputStream fileIn = new FileInputStream("saves/" + folderName + "/users.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            UserListings userListings = (UserListings) in.readObject();
            instance = userListings;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package vintage.module.user;

import java.io.Serializable;
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
     * Gets a User by it's email
     *
     * @param email
     * @return User
     */
    public User getUser(String email) { return users.get(email); }

    /**
     * Checks if a certain email is available
     *
     * @param email
     * @return boolean
     */
    public boolean isEmailAvailable(String email) { return users.containsKey(email); }

}

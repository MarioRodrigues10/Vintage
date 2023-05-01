package vintage.user;

import java.util.Map;
import java.util.HashMap;

/**
 *  Type UserList
 */
public class UserList {

    private final Map<String, User> users = new HashMap<String, User>(); /* ! Map of Users by Email*/

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

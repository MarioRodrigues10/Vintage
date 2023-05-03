package vintage.module.item;

import vintage.module.User;
import vintage.module.user.User;

import java.util.*;
import java.util.stream.Collectors;

public class ItemListings {
    private final Map<UUID, List<Item>> items = new HashMap<UUID, List<Item>>(); /* ! Map of items, where the key is the user ID */

    /**
     * Returns a List of items of a specific user.
     *
     * @param user a User object containing the user
     * @return a List of items of a specific user
     */
    public List<Item> getUserItems(User user) {
        return this.items.get(user.getId());
    }

    /**
     * Returns a List of items of a specific user.
     *
     * @param userId a UUID object containing the user ID
     * @return a List of items of a specific user
     */
    public void addItem(UUID userId, Item item) {
        List<Item> userItems = this.items.get(userId);
        if (userItems == null) {
            userItems = new ArrayList<>();
        }
        userItems.add(item);
        this.items.put(userId, userItems);
    }

    /**
     * Removes an item from a user's list of items.
     *
     * @param userId a UUID object containing the user ID
     * @param item an Item object containing the item
     */
    public void removeItem(UUID userId, Item item) {
        List<Item> userItems = this.items.get(userId);
        if (userItems == null) {
            return;
        }
        userItems.remove(item);
    }

    /**
     * Returns a List of all items.
     *
     * @return a List of all items
     */
    public List<Item> getAllItems() {
        return items.values().stream()
                .flatMap(Collection::stream)
                .map(Item::clone) // create a copy of each item
                .collect(Collectors.toList());
    }
}
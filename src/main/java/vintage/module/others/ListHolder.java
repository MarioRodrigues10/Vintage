package vintage.module.others;

import vintage.module.UserList;
import vintage.module.item.ItemListings;
import vintage.module.order.OrderListings;

public class ListHolder {
    private static UserList users; /* ! List of Users*/
    private static ItemListings items; /* ! List of Items*/
    private static OrderListings orders; /* ! List of Orders*/

    /**
     * Init
     */
    public static void init() {
        users = new UserList();
        items = new ItemListings();
        orders = new OrderListings();
    }

    /**
     * Returns the list of Users
     *
     * @return Users
     */
    public static UserList getUsers() { return users; }

    /**
     * Returns the list of Items
     *
     * @return Items
     */
    public static ItemListings getItems() { return items; }

    /**
     * Returns the list of Orders
     *
     * @return Orders
     */
    public static OrderListings getOrders() {return orders; }
}

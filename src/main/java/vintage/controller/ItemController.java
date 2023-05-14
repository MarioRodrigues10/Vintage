package vintage.controller;

import vintage.module.item.Bag;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.item.TShirt;
import vintage.module.item.carrier.Carrier;
import vintage.module.item.carrier.CarrierListings;
import vintage.module.order.Order;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.ItemView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ItemController {
    public static void marketplace(User user) {
        List<Item> items = UserListings.getInstance().getAllItems();

        // turn the items list into a list of strings
        List<String> itemStrings = new ArrayList<String>();
        for (Item item : items) {
            itemStrings.add(item.toString());
        }

        int itemIndex = ItemView.marketplace(itemStrings);

        if (itemIndex == -1) {
            UserController.menu(user);
        } else {
            Item item = items.get(itemIndex - 1);
            Order pendingOrder = user.getPendingOrder();
            pendingOrder.addItem(item);
        }
    }

    public static void userItems(User user) {
        List<Item> items = UserListings.getInstance().getUser(user.getEmail()).getItems();

        List<String> itemStrings = new ArrayList<String>();
        for (Item item : items) {
            itemStrings.add(item.toString());
        }
        int option = ItemView.displayUserItems(itemStrings);

        if (option == 1) {
            createUserItem(user);

            // go back to user items
            ItemController.userItems(user);
        }
        else if (option == 2) {
            deleteUserItem(user);

            // go back to user items
            ItemController.userItems(user);
        }
        else {
            UserController.menu(user);
        }
    }

    private static void deleteUserItem(User user) {
        UUID itemId = UUID.fromString(ItemView.deleteUserItem());

        Item item = user.getItem(itemId);
        user.removeItem(item);
    }

    private static void createUserItem(User user) {
        Map<String, String> item = ItemView.createUserItem();

        if (item.get("type").equals("tshirt")) {
            createTShirt(user, item);
        }
        else if (item.get("type").equals("bag")) {
            createBag(user, item);
        }
        else {
            createShoes(user, item);
        }

        return;
    }

    private static void createTShirt(User user, Map<String, String> item) {
        TShirt.Size size;
        TShirt.Pattern pattern;

        if (item.get("size").equals("S")) {
            size = TShirt.Size.S;
        }
        else if (item.get("size").equals("M")) {
            size = TShirt.Size.M;
        }
        else if (item.get("size").equals("L")) {
            size = TShirt.Size.L;
        }
        else {
            size = TShirt.Size.XL;
        }

        if (item.get("pattern").equals("solid")) {
            pattern = TShirt.Pattern.SOLID;
        }
        else if (item.get("pattern").equals("stripped")) {
            pattern = TShirt.Pattern.STRIPPED;
        }
        else {
            pattern = TShirt.Pattern.PALM;
        }

        Carrier carrier = CarrierListings.getInstance().getCarrier(item.get("carrier"));

        Item tshirt = new TShirt(
                item.get("description"),
                user,
                item.get("brand"),
                Integer.parseInt(item.get("evaluation")),
                BigDecimal.valueOf(Double.parseDouble(item.get("price"))),
                Integer.parseInt(item.get("owners")),
                size,
                pattern,
                carrier
        );

        user.addItem(tshirt);
    }

    private static void createBag(User user, Map<String, String> item) {
        Item bag = new Bag(
                item.get("description"),
                user,
                item.get("brand"),
                Integer.parseInt(item.get("evaluation")),
                BigDecimal.valueOf(Double.parseDouble(item.get("price"))),
                Integer.parseInt(item.get("owners")),
                Integer.parseInt(item.get("size")),
                item.get("material"),
                Integer.parseInt(item.get("release")),
                null
        );

        user.addItem(bag);
    }

    private static void createShoes(User user, Map<String, String> item) {
        boolean laces;
        laces = item.get("laces").equals("y");

        Item shoes = new Shoes(
                item.get("description"),
                user,
                item.get("brand"),
                Integer.parseInt(item.get("evaluation")),
                BigDecimal.valueOf(Double.parseDouble(item.get("price"))),
                Integer.parseInt(item.get("owners")),
                Double.parseDouble(item.get("size")),
                laces,
                item.get("color"),
                Integer.parseInt(item.get("release")),
                null
        );

        user.addItem(shoes);
    }
}

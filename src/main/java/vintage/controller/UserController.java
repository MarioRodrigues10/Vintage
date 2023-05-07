package vintage.controller;

import vintage.module.item.Bag;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.item.TShirt;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class UserController {

      public static User registerUser(Map<String, String> user) {
          if (UserListings.getInstance().checkUser(user.get("email"))) return null;
          Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
          ArrayList<Receipt> receipts = new ArrayList<Receipt>();
          ArrayList<Item> items = new ArrayList<Item>();

          User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts, items);
          UserListings.getInstance().addUser(newUser);

          return newUser;
      }

      public static void showUserReceipts(User user) {
          List<Receipt> receipts = user.getReceipts();

          List<String> receiptStrings = new ArrayList<String>();

          for (Receipt receipt : receipts) {
              receiptStrings.add(receipt.toString());
          }

          vintage.view.UserView.showReceipts(receiptStrings);
      }

      public static List<String> getItemStringsByCategory(Map<String, User> usersMap,Integer option) {
          List<Item> items = UserListings.getInstance().getAllItems();
          List<String> categorizedItemStrings = new ArrayList<String>();

          switch (option) {
              case 1:
                  for (Item item : items) if (item instanceof TShirt) categorizedItemStrings.add(item.toString());
                  break;
              case 2:
                  for (Item item : items) if (item instanceof Shoes) categorizedItemStrings.add(item.toString());
              case 3:
                  for (Item item : items) if (item instanceof Bag) categorizedItemStrings.add(item.toString());
          }
          return categorizedItemStrings;
      }
      public static void showUserItems(User user) {
          List<Item> items = user.getItems();
          List<String> itemStrings = new ArrayList<String>();

          for (Item item : items) {
              itemStrings.add(item.toString());
          }

          int option = vintage.view.UserView.showItems(itemStrings);

          if (option == 1) {
              createUserItem(user);
              return;
          }
          else {
              deleteUserItem(user);
              return;
          }
      }

      public static void deleteUserItem(User user) {
          UUID itemId = UUID.fromString(vintage.view.UserView.deleteItem());

          Item item = user.getItem(itemId);
          user.removeItem(item);
      }

      public static void createUserItem(User user) {
          Map<String, String> item = vintage.view.UserView.createUserItem();

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

          Item tshirt = new TShirt(
                  item.get("description"),
                  user,
                  item.get("brand"),
                  Integer.parseInt(item.get("evaluation")),
                  BigDecimal.valueOf(Double.parseDouble(item.get("price"))),
                  Integer.parseInt(item.get("owners")),
                  size,
                  pattern,
                  null
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

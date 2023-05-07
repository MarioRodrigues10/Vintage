package vintage.controller;

import vintage.module.item.Bag;
import vintage.module.item.Item;
import vintage.module.item.Shoes;
import vintage.module.item.TShirt;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
}

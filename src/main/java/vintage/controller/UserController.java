package vintage.controller;

import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;

import java.util.ArrayList;
import java.util.Map;

public class UserController {

      public static User registerUser(Map<String, String> user) {



          if (UserListings.getInstance().checkUser(user.get("email"))) return null;
          Address address = new Address(user.get("country"), user.get("city"), user.get("street"), user.get("postalCode"));
          ArrayList<Receipt> receipts = new ArrayList<Receipt>();

          User newUser = new User(user.get("name"), user.get("email"), address, user.get("taxNumber"), receipts);
          UserListings.getInstance().addUser(newUser);

          return newUser;
      }
}

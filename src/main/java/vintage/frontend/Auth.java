package vintage.frontend;

import java.util.ArrayList;
import vintage.user.Address;
import vintage.receipt.Receipt;
import vintage.user.User;
import vintage.user.UserList;
import vintage.others.ListHolder;


public class Auth {

    public static User loginMenu (UserList users){

        Util.println("Login");
        String email = Util.inputEmail();

        if(users.checkUser(email)) {
            Util.println("Logged in successfully.");
            return users.getUser(email);
        }
        else {
            Util.println("User does not exist, try signing up.");
            return null;
        }
    }

    public static User inputUser () {

        String email = Util.inputEmail();
        String name = Util.input("Name: ");
        String country = Util.input("Country: ");
        String city = Util.input("City: ");
        String street = Util.input("Street: ");
        String postalCode = Util.input("Postal Code: ");
        String taxNumber = Util.inputTaxNumber();
        Address address = new Address(country, city, street, postalCode);
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        User user = new User(name, email, address, taxNumber, receipts);

        return user;
    }

    public static User signUpMenu (UserList users){

        Util.println("SignUp");
        User user = inputUser();

        if(users.checkUser(user.getEmail())) {
            Util.println("User with that email already exists. Try again.");
            user = null;
        }
        else users.addUser(user);
        return user;
    }

    public static User authMenu () {

        User auth = null;

        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Address("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");
        ListHolder.getUsers().addUser(user);


        do {
            Util.printHeader();
            Util.println("\n[1] LOGIN");
            Util.println("[2] SIGNUP");
            Integer option = Util.inputOption(2);
            if (option == 1) auth = Auth.loginMenu(ListHolder.getUsers());
            else auth = Auth.signUpMenu(ListHolder.getUsers());
        } while (auth == null);

        return auth;
    }

}

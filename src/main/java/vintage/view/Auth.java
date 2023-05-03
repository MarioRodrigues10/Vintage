package vintage.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, String> inputUser () {
        Map<String, String> userInput = new HashMap<String, String>();

        userInput.put("email", Util.inputEmail());
        userInput.put("name", Util.input("Name: "));
        userInput.put("country", Util.input("Country: "));
        userInput.put("city", Util.input("City: "));
        userInput.put("street", Util.input("Street: "));
        userInput.put("postalCode", Util.input("Postal Code: "));
        userInput.put("taxNumber", Util.inputTaxNumber());

        return userInput;
    }

    public static Map<String, String> signUpMenu (){

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

package vintage.view;

import java.util.HashMap;
import java.util.Map;

public class AuthView {
    public static Map<String, String> login() {
        Util.clearScreen();
        Util.printHeader();
        Map<String, String> user = new HashMap<String, String>();

        Util.println("\nLogin\n");
        Util.println("Type your email or 0 to go back.");
        String email = Util.inputEmail();
        user.put("email", email);

        return user;
    }

    public static void noUser() {
        Util.println("\nUser doesn't exist, try logging in with a different email.");
        Util.input("Press enter to go back to the Authentication page");
    }

    public static Map<String, String> signUp() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("SignUp");

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

    public static void userExists() {
        Util.println("\nUser already exists, try signing up with a different email.");
        Util.input("Press enter to go back to the Authentication page");
    }
}

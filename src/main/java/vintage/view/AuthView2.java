package vintage.view;

import java.util.HashMap;
import java.util.Map;

public class AuthView2 {
    public static Map<String, String> login() {
        Util.clearScreen();
        Map<String, String> user = new HashMap<String, String>();

        Util.println("Login");
        String email = Util.inputEmail();
        user.put("email", email);

        return user;
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
}

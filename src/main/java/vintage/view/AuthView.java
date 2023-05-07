package vintage.view;

import java.util.HashMap;
import java.util.Map;

public class AuthView {

    public static Map<String, String> loginMenu (){
        Map<String, String> user = new HashMap<String, String>();

        Util.println("Login");
        String email = Util.inputEmail();
        user.put("email", email);

        return user;
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
        Map<String, String> user = inputUser();

        return user;
    }

    public static Integer authMenu () {

        Util.printHeader();
        Util.println("\n[1] LOGIN");
        Util.println("[2] SIGNUP");
        Integer option = Util.inputOption(2);

        return option;
    }

}

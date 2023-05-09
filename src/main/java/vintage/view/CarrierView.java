package vintage.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrierView {

    public static Integer menu() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nCarrier MENU\n");
        Util.println  ("[1] View Carriers");
        Util.println  ("[2] Create Carrier");
        Util.println  ("[3] Delete Carrier");
        Util.println  ("[4] Change Carrier Formula");
        Util.println  ("[5] Back\n");

        Integer option = Util.inputOption(5);

        return option;
    }

    public static int viewCarriers(List<String> carrierStrings) {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nCarriers");

        int pageNumber = 1;
        int option = displayCarriers(carrierStrings, pageNumber);

        while (option > 0) {
            if (option == 1 && pageNumber > 1) {
                pageNumber--;
            } else if (option == 2 && carrierStrings.size() > pageNumber * 5) {
                pageNumber++;
            } else if (option == 3) {
                return -1;
            }

            option = displayCarriers(carrierStrings, pageNumber);
        }

        return pageNumber * 5 - 5 + option;
    }

    public static Integer displayCarriers(List<String> carriers, Integer pageNumber) {
        Integer i = 1;
        for(String carrier : carriers){
            Util.print(carriers.get(i-1));
            System.out.println("\n====================================");
            i++;
        }
        Util.println("[1] <-");
        Util.println("[2] ->");
        Util.println("[3] Back");
        Integer option = Util.inputOption(3);
        return option;
    }

    public static Map<String, String> createCarrier() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nCreate Carrier");

        Map<String, String> carrierInput = new HashMap<String, String>();

        carrierInput.put("name", Util.input("Name: "));
        carrierInput.put("profit", Util.input("Profit: "));
        carrierInput.put("deliveryTime", Util.input("Delivery Time (in days): "));
        carrierInput.put("premium", Util.input("Premium Carrier (y/n): "));
        return carrierInput;
    }

    public static String deleteCarrier() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nDelete Carrier");

        String carrierName = Util.input("Name of the Carrier you want to delete: ");

        return carrierName;
    }

    public static void carrierDeleted() {
        Util.println("If a Carrier with that name existed, it was deleted!");
        Util.input("Press enter to go back");
    }
}

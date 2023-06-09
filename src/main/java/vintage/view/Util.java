package vintage.view;

import vintage.module.item.carrier.Carrier;

import java.time.LocalDate;
import java.time.format.*;
import java.util.Scanner;
import java.util.List;
import java.lang.Double;

/**
 * Type Util.
 */
public class Util {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Prints a String with a newline.
     *
     * @param message
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * Prints a String with a newline.
     *
     * @param message
     */
    public static void print(String message) {System.out.print(message);}

    /**
     * Prints an Error.
     *
     * @param message
     */
    public static void giveError(String message) {
        System.err.println(message);
    }

    /**
     * Input String.
     *
     * @param message
     * @return string
     */
    public static String input(String message) {
        print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Input valid int.
     *
     * @param message
     * @return int
     */
    public static int inputInt(String message) {
        Integer num = null;
        String text;
        Scanner scanner = new Scanner(System.in);

        do {
            print(message);
            text = scanner.nextLine();

            try {
                num = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                giveError(text + " is not a valid Integer.");
            }

        } while (num == null);

        return num;
    }

    /**
     * Input valid int option.
     *
     * @param options
     * @return int
     */
    public static int inputOption(int options) {
        Integer num = null;
        String text = "";
        boolean state = true;
        Scanner scanner = new Scanner(System.in);

        do {
            print("Select one of the options above: ");
            try {
                text = scanner.nextLine();
                num = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                giveError(text + " is not a valid option!");
                state = false;
            }

            if ((num == null || num < 0 || num > options) && state) {
                num = null;
                giveError(text + " is not a valid option!");
            }
            state = true;
        } while (num == null);

        return num;
    }

    /**
     * Input date in the right format.
     *
     * @param message
     * @return local date
     */
    public static LocalDate InputDate(String message) {
        LocalDate date = null;
        String text = "";
        Scanner scanner = new Scanner(System.in);
        do {
            print(message);
            try {
                text = scanner.nextLine();
                date = LocalDate.parse(text, dateFormat);
            } catch (DateTimeParseException e) {
                giveError(text + " is not a valid date!");
                date = null;
            }
        } while (date == null);

        return date;
    }

    /**
     * Parse String to localDate format.
     *
     * @param dataStr string date
     * @return local date
     */
    public static LocalDate strToDate(String dataStr) {
        try {
            LocalDate.parse(dataStr, dateFormat);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return LocalDate.parse(dataStr, dateFormat);
    }

    /**
     * Wait for Input.
     */
    public static void waitInput(){
        Integer a = 0;
        do{
            inputInt("Type 0 to go back");
        }while(a != 0);
    }

    public static void printHeader() {

        System.out.println("           __   __ ___  _  _  _____  ___   ___  ___ ");
        System.out.println("           \\ \\ / /|_ _|| \\| ||_   _|/   \\ / __|| __|");
        System.out.println("            \\   /  | | | .  |  | |  | - || (_ || _|");
        System.out.println("             \\_/  |___||_|\\_|  |_|  |_|_| \\___||___|");
    }

    public static String inputEmail() {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String email = Util.input("Email: ");

        while (email.matches(emailRegex) == false && !email.equals("0")) {
            email = Util.input("You need to type a correct email: ");
        }
        return email;
    }

    public static String inputEvaluation() {
        String evaluationRegex = "^[1-9]|10$";
        String evaluation = Util.input("Evaluation: ");

        while (evaluation.matches(evaluationRegex) == false) {
            evaluation = Util.input("You need to type a correct evaluation: ");
        }
        return evaluation;
    }

    public static String inputLaces() {
        String laces = Util.input("Laces [y/n]: ");

        while (laces.equals("Y") || laces.equals("N")) {
            laces = Util.input("You need to type either 'y' or 'n': ");
        }
        return laces;
    }

    public static String inputPrice() {
        String priceRegex = "^[0-9]+(\\.[0-9]{1,2})?$";
        String price = Util.input("Price: ");

        while (!price.matches(priceRegex)) {
            price = Util.input("You need to type a correct price: ");
        }
        return price;
    }

    public static String inputSize() {
        String size = Util.input("Size [S/M/L/XL]: ");

        while (!size.equals("S") && !size.equals("M") && !size.equals("L") && !size.equals("XL") &&
                !size.equals("s") && !size.equals("m") && !size.equals("l") && !size.equals("xl")) {
            size = Util.input("You need to type a correct size: ");
        }
        return size;
    }

    public static String inputTaxNumber() {
        String numberRegex = "^\\d{9}$";
        String taxNumber = Util.input("Tax Number: ");

        while (taxNumber.matches(numberRegex) == false) {
            taxNumber = Util.input("You need to type a correct Tax Number (9 digits): ");
        }
        return taxNumber;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static List<String> getPage(List<String> items, int pageNumber) {
        int startIndex = (pageNumber - 1) * 5;
        if (startIndex < 0) startIndex = 0;
        int endIndex = Math.min(startIndex + 5, items.size());
        return items.subList(startIndex, endIndex);
    }

    public static String inputCarriers(List<String> carriers){
        printCarriers(carriers);
        String carrierId = Util.input("Carrier Name: ");

        return carrierId;
    }

    public static void printCarriers(List<String> carriers){
        for (String carrier : carriers) {
            System.out.println(carrier);
        }
    }
}

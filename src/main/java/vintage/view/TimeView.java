package vintage.view;

import java.util.HashMap;
import java.util.Map;

public class TimeView {

    public static Map<String, Integer> jumpTime() {
        Util.clearScreen();
        Util.printHeader();
        Util.println("\nJump in Time");

        Map<String, Integer> times = new HashMap<String, Integer>();
        times.put("years", Util.inputInt("How many years do you want to jump? "));
        times.put("months", Util.inputInt("How many months do you want to jump? "));
        times.put("days", Util.inputInt("How many days do you want to jump? "));

        return times;
    }

    public static void timeJumped() {
        Util.println("\nTime jumped successfully!");
        Util.input("Press enter to go back");
    }
}

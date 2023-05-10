package vintage.controller;

import vintage.module.time.Time;
import vintage.view.TimeView;

import java.util.Map;

public class TimeController {

    public static void jumpTime () {
        Map<String, Integer> times = TimeView.jumpTime();

        Time time = Time.getInstance();
        time.jumpYears(times.get("years"));
        time.jumpMonths(times.get("months"));
        time.jumpDays(times.get("days"));

        TimeView.timeJumped();
        AdminController.menu();
    }
}

package vintage.controller;

import vintage.module.time.Time;
import vintage.view.TimeView;

import java.util.Map;

public class TimeController {
    private static TimeController instance = null;

    public static TimeController getInstance() {
        if (instance == null) {
            instance = new TimeController();
        }
        return instance;
    }

    public void jumpTime () {
        Map<String, Integer> times = TimeView.getInstance().jumpTime();

        Time time = Time.getInstance();
        time.jumpYears(times.get("years"));
        time.jumpMonths(times.get("months"));
        time.jumpDays(times.get("days"));

        TimeView.getInstance().timeJumped();
        AdminController.getInstance().menu();
    }
}

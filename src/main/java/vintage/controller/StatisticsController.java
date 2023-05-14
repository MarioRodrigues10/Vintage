package vintage.controller;

import vintage.view.StatisticsView;

public class StatisticsController {

        public static void menu() {
            int option = StatisticsView.menu();
            StatisticsView.printStatistics(option);
        }
}

package vintage.others;

import vintage.order.OrderListings;

import java.time.LocalDate;
import java.io.Serializable;

public class Time implements Serializable {
    private static Time instance = null;
    private LocalDate currentDate; /* ! Current Date */

    /**
     * Returns the instance of Time
     * @return Time
     */
    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
        }
        return instance;
    }

    /**
     * Creates a new Time object with default properties.
     */
    private Time() {
        this.currentDate = LocalDate.now();
    }

    /**
     * Getter function for the current date.
     * @return a LocalDate object representing the current date
     */
    public LocalDate getCurrentDate() {
        return this.currentDate;
    }

    /**
     * Method that allows to jump a certain amount of days
     * @param days an integer value representing the amount of days to jump
     * @param orderListings an OrderListings object containing the orders
     * @param currentDate a LocalDate object representing the current date
     */
    public void jumpDays(int days, OrderListings orderListings, LocalDate currentDate) {
        orderListings.updateOrdersState();
        this.currentDate = this.currentDate.plusDays(days);
    }

    /**
     * Method that allows to jump a certain amount of months
     * @param months an integer value representing the amount of months to jump
     * @param orderListings an OrderListings object containing the orders
     * @param currentDate a LocalDate object containing the current date
     */
    public void jumpMonths(int months, OrderListings orderListings, LocalDate currentDate) {
        orderListings.updateOrdersState();
        this.currentDate = this.currentDate.plusMonths(months);
    }

    /**
     * Method that allows to jump a certain amount of years
     * @param years an integer value representing the amount of years to jump
     * @param orderListings an OrderListings object containing the orders
     * @param currentDate a LocalDate object containing the current date
     */
    public void jumpYears(int years, OrderListings orderListings, LocalDate currentDate) {
        orderListings.updateOrdersState();
        this.currentDate = this.currentDate.plusYears(years);
    }

    /**
     * Method that turns the current date into a String
     * @return a String representing the current date
     */
    public String toString() {
        return this.currentDate.toString();
    }
}

package vintage.others;

import vintage.order.OrderListings;

import java.time.LocalDate;

public class Time {
    private LocalDate currentDate; /* ! Current Date */

    /**
     * Creates a new Time object with the specified properties.
     * @param currentDate
     */
    public Time(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Creates a new Time object with default properties.
     */
    public Time() {
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
        orderListings.updateOrdersState(currentDate);
        this.currentDate = this.currentDate.plusDays(days);
    }

    /**
     * Method that allows to jump a certain amount of months
     * @param months an integer value representing the amount of months to jump
     * @param orderListings an OrderListings object containing the orders
     * @param currentDate a LocalDate object containing the current date
     */
    public void jumpMonths(int months, OrderListings orderListings, LocalDate currentDate) {
        orderListings.updateOrdersState(currentDate);
        this.currentDate = this.currentDate.plusMonths(months);
    }

    /**
     * Method that allows to jump a certain amount of years
     * @param years an integer value representing the amount of years to jump
     * @param orderListings an OrderListings object containing the orders
     * @param currentDate a LocalDate object containing the current date
     */
    public void jumpYears(int years, OrderListings orderListings, LocalDate currentDate) {
        orderListings.updateOrdersState(currentDate);
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

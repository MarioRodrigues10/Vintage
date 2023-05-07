package vintage.module.time;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Time implements Serializable {
    private static Time instance = null;
    private LocalDate currentDate; /* ! Current Date */
    private final List<TimeObserver> observers;

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
        this.observers = new ArrayList<TimeObserver>();
    }

    /**
     * Adds an observer to the list of observers
     * @param observer
     */
    public void addObserver(TimeObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers
     * @param observer
     */
    public void removeObserver(TimeObserver observer) {
        this.observers.remove(observer);
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
     */
    public void jumpDays(int days) {
        this.currentDate = this.currentDate.plusDays(days);
        notifyObservers();
    }

    /**
     * Method that allows to jump a certain amount of months
     * @param months an integer value representing the amount of months to jump
     */
    public void jumpMonths(int months) {
        this.currentDate = this.currentDate.plusMonths(months);
        notifyObservers();
    }

    /**
     * Method that allows to jump a certain amount of years
     * @param years an integer value representing the amount of years to jump
     */
    public void jumpYears(int years) {
        this.currentDate = this.currentDate.plusYears(years);
        notifyObservers();
    }

    public void notifyObservers() {
        for (TimeObserver observer : this.observers) {
            observer.update();
        }
    }

    /**
     * Method that turns the current date into a String
     * @return a String representing the current date
     */
    public String toString() {
        return this.currentDate.toString();
    }
}

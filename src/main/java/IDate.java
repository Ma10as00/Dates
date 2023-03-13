package main.java;
/**
 * This interface describes what methods we would need for a Date-class, to
 * satisfy the needs of our customer.
 * @author Mathias Øgaard
 */
public interface IDate {

    /**
     * @return The date's day (in a month).
     */
    public int getDay();

    /**
     * @return The date's month.
     */
    public Month getMonth();

    /**
     * @return The date's year.
     */
    public int getYear();

    /**
     * @return  A representation of the date in the following format: "DD MON YYYY", followed by " - INVALID" if appropriate.
     */
    public String toPrintFormat();

    /**
     * A date is valid if it is an actual date between the years of 1753 (inclusive) and 3000 (inclusive).
     * @return true if this is a valid date, false if it's not
     */
    public boolean isValid();

    /**
     * The year is evenly divisible by 4. If it is also divisible by 100, it is not a leap year - unless it is also divisible by 400. Then it still is a leap year.
     * @return true if this date's year is a leap year, false if it's not
     */
    public boolean isLeapYear();

    /**
     * Should take leap years into consideration, and return the correct number of days in this month. 
     * If this date's year is a leap year, and the month is February, it should return 29. For all other years, February should have 28 days.
     * @return The number of days in the date's month.
     */
    public int daysInMonth();

    /**
     * Prints to System.err that this date's year is invalid.
     */
    public void yearOutOfRange();
    /**
     * Prints to System.err that this date's day is invalid.
     */
    public void dayOutOfRange();
    /**
     * Prints to System.err that this date's month is null.
     */
    public void monthIsNull();   
    
}

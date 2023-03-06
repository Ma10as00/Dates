package main.java;

import java.util.ArrayList;

/**
 * This defines a class that reads input from the user, and converts it into a Date-structure.
 * Based on the input, the chatbot will print to the terminal whether the input was a valid date or not,
 * and provide the appropriate error messages if the input was invalid
 * .
 * @author Mathias Øgaard  
 */
public interface IChatBot <D extends IDate> {
    /**
     * Reads input from the user, and return 
     * @return
     */
    public String getNextLine();


    /**
     * Divides input into the relevant strings for day, month and year.
     * Valid input should be in the order day-month-year, and follow the rules below.
     * Should throw exception if input is unreadable.
     * @readableDays: dd, d or 0d
     * @readableMonth: mm, m, 0m or first three letters (mon or Mon)
     * @readableYear: yy or yyyy
     * @readableSeparator: - or / or <space> (The same separator must be used throughout the string)
     * @param input
     * @return A list of strings: [dd, Mon, yyyy] 
     */
    public ArrayList<String> readDate(String input);

    /**
     * Takes in a list processed by readDate(), and converts it into a Date.
     * 
     * @param input
     * @return The date the string specifies
     */
    public D toDate(ArrayList<String> readInput);

    /**
     * Prints a date to System.out, in the format: "DD MON YYYY", followed by " - INVALID" if appropriate.
     * @param date
     */
    public void printDate(D date);
}

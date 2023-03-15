package main.java;

import java.util.ArrayList;

/**
 * This defines a class that reads input from the user, and converts it into a Date-structure.
 * Based on the input, the chatbot will print to the terminal whether the input was a valid date or not,
 * and provide the appropriate error messages if the input was invalid.
 * ChatBots should keep a log of all dates given by the user.
 * .
 * @author Mathias Øgaard  
 */
public interface IChatBot<D extends IDate> {
    /**
     * Reads input from the user, and return 
     * @return
     */
    public String getNextLine();


    /**
     * Takes input from the user, and converts it into a Date.
     * Valid input should be in the order day-month-year, and follow the rules below.
     * Should throw exception if input is unreadable.
     * Days: dd, d or 0d    ----    
     * Month: mm, m, 0m or first three letters (mon or Mon)     ----    
     * Year: yy or yyyy     ----    
     * Separator: - or / or 'space' (The same separator must be used throughout the string)
     * @param line - A string given by the user
     * @return The date specified by the user input
     */
    public D readDate(String line);

    /**
     * Prints a date to System.out, in the format: "DD MON YYYY", followed by " - INVALID" if appropriate.
     * @param date
     */
    public void printDate(D date);

    /**
     * Directly reads input from System.in, and prints the date that the input indicates.
     */
    public void printInput();

    /**
     * @return the log of all dates given to the program
     */
    public ArrayList<D> getLog();

    /**
     * Adds given date to the log.
     * @param date
     * @return true if date was successfully logged, false if not
     */
    public boolean addToLog(D date);

    /**
     * Prints the log of all dates to System.in
     */
    public void printLog();

    /**
     * Directly reads input from System.in, and logs the date that the input indicates, and prints the entire log.
     */
    public void logAndPrint(String input);

    /**
     * Starts the program loop, where the chatbot communicates with the user.
     * Through this conversation, the user should be able to log new dates, and get them printed to the terminal.
     * The user should also be able to end the program whenever they want.
     */
    public void startConversation();
}

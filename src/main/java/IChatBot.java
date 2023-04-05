package main.java;

/**
 * This defines a class that reads input from the user, and converts it into a Date-structure.
 * <p>
 * Based on the input, the chatbot will print to the terminal whether the input was a valid date or not,
 * and provide the appropriate error messages if the input was invalid.
 * 
 * @author Mathias Øgaard  
 */
public interface IChatBot<D extends IDate> {

    /** 
     * @return the next line from user input
     */
    public String getNextLine();

    /**
     * Takes input from the user, and converts it into a Date.
     * Valid input should be in the order day-month-year, and follow the rules below.
     * <p>
     * Should throw exception if input is unreadable.
     * <p>
     * Days: dd, d or 0d    ----    
     * <p>
     * Month: mm, m, 0m or first three letters (mon or Mon)     ----    
     * <p>
     * Year: yy or yyyy     ----    
     * <p>
     * Separator: - or / or 'space' (The same separator must be used throughout the string)
     * @param line - A string given by the user
     * @return The date specified by the user input
     * @throws IllegalArgumentException if date is unreadable
     */
    public D readDate(String line);

    /**
     * Prints a date to System.out, in the format: {@code"DD Mon YYYY"}.
     * @param date
     */
    public default void printDate(D date){
        System.out.println(date.toPrintFormat());
    }

    /**
     * Directly reads input from System.in, and prints the date that the input indicates to System.out. 
     * <p>
     * Prints a date to System.out, in the format: {@code"DD Mon YYYY"}, followed by {@code" - INVALID"} if appropriate.
     * <p>
     * Also, if the date is invalid, appropriate error messages are printed to System.err.
     * @param input - A line of input
     * @throws IllegalArgumentException if date is unreadable
     */
    public void readNprint(String input);

    /**
     * Starts the program loop, where the chatbot communicates with the user.
     * <p>
     * Through this conversation, the user should be able to validate dates, and get them printed to the terminal.
     * <p>
     * The user should also be able to end the program whenever they want.
     */
    public void startConversation();
}

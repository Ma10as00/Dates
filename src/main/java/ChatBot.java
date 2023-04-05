package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChatBot implements IChatBot<Date> {

    private Scanner sc;

    public ChatBot(){
        sc = new Scanner(System.in);
    }
    
    public ChatBot(File file){
        try {
            sc = new Scanner(file);    
        } catch (Exception e) {
            System.out.println("Didn't find file. Taking input from the terminal instead.");
            sc = new Scanner(System.in);
        } 
    }


    @Override
    public String getNextLine() {
        return sc.nextLine();
    }

    @Override
    public Date readDate(String line) {

        String sep = "";
        if(line.contains("-"))
            sep = "-";
        if(line.contains("/"))
            sep = "/";
        if(line.contains(" "))
            sep = " ";
        
        if(sep.equals(line.substring(0, 1)) || sep.equals(line.substring(line.length()-1)))
            throw new IllegalArgumentException("Input cannot start or end with separators.");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(sep)));
        //If input was valid, list should now look like this: [day, month, year]

        if(list.size() > 3){
            throw new IllegalArgumentException("Too many separators in the date-expression.");
        }
        if(list.size() < 3){
            throw new IllegalArgumentException("Not enough information in the date-expression.");
        }

        //Read day
        String d = list.get(0);
        int day;
        try {
            if(d.length() > 2)
                throw new IllegalArgumentException("More than two digits in day-input.");
            day = Integer.valueOf(d);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-numerical day-input.");
        }

        //Read month.
        String m = list.get(1);
        Month month;
        try {
            int i = Integer.parseInt(m);
            if(m.length() > 2) //This line is reached only if month-input is numerical
                throw new IllegalArgumentException("More than two digits in month-input.");
            if(i<1 || i>12){
                throw new IllegalArgumentException("Only numbers 1-12 indicates valid months.");
            }
            month = Month.numToMonth(i);
        } catch (NumberFormatException e) {
            month = Month.strToMonth(m);
        }

        //Read year
        String y = list.get(2);
        int year;
        try {
            year = Integer.valueOf(y);
            if(y.length() == 2){ //If year is given with two digits
                if(year < 50)
                    year += 2000;
                else
                    year += 1900;   
            }
            if(y.length() != 2 && y.length() != 4)
                throw new IllegalArgumentException("Year was not 2 or 4 digits.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-numerical year-input.");
        }

        return new Date(day, month, year);
    }

    @Override
    public void printDate(Date date) {
        System.out.print(date.toPrintFormat());
        if(!date.isValid())
            System.out.println(" - INVALID");
        date.printErrors();
    }

    @Override
    public void startConversation() {
        boolean running = true;
        while (running){   
            System.out.println("What date do you want to validate?");
            System.out.println("Press 'q' to quit");
            String input = getNextLine();
            if(input.equals("q")){
                running = false;
            }else{
                try {
                    readNprint(input);
                } catch (Exception e) {
                    System.out.print("Sorry, I don't understand that date. This is why: ");
                    System.out.println(e.getMessage());
                } 
            }
            System.out.println(); //New line to make terminal more readable.
        }
    }

    /**
     * Simpler conversation that doesn't tell the user what to do. 
     * Responds only if it's feeded input.
     * <p>
     * Prints date to stdout if input was understood, followed by " - INVALID" if the date is invalid.
     * <p>
     * If the date is invalid, an error message will also be printed to stderr.
     */
    public void altConversation(){
        while (sc.hasNextLine()){
            String input = getNextLine();
            try {
                readNprint(input);
            } catch (Exception e) {
                System.out.println(input + " - INVALID");
            }
        }
    }
}

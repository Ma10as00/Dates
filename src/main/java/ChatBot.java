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
            day = Integer.valueOf(d);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid day-input.");
        }

        //Read month.
        String m = list.get(1);
        Month month;
        try {
            int i = Integer.parseInt(m);
            if(i<1 || i>12)
                throw new IllegalArgumentException("Only numbers 1-12 indicates valid months.");
            month = Month.numToMonth(i);
        } catch (NumberFormatException e) {
            month = Month.strToMonth(m);
        }

        //Read year
        String y = list.get(2);
        int year;
        try {
            year = Integer.valueOf(y);
            if(year < 50)
                year += 2000;
            if(year < 100 && year >= 50)
                year += 1900;    
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid year-input.");
        }

        return new Date(day, month, year);
    }

    @Override
    public void printDate(Date date) {
        System.out.print(date.toPrintFormat());
        if(!date.isValid()){
            System.out.println(" - INVALID");
            date.printErrors();
        }else{
            System.out.println();
        }
    }

    @Override
    public void startConversation() {
        boolean running = true;
        while (running){   
            System.out.println("What date do you want to check?");
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
}

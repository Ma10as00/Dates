package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChatBot implements IChatBot<Date> {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Date> log = new ArrayList<>(); 

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
            throw new IllegalArgumentException("Mulitple separators used in the same date-expression.");
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
        }else{
            System.out.println();
        }
    }

    @Override
    public void printInput() {
        printDate(readDate(getNextLine()));
    }

    @Override
    public ArrayList<Date> getLog() {
        return log;
    }

    @Override
    public boolean addToLog(Date date) {
        return log.add(date);
    }

    @Override
    public void printLog() {
        System.out.println("-----LOG-----");
        for (int i=0; i<log.size();i++){
            printDate(log.get(i));
        }
        System.out.println("-------------");
    }

    @Override
    public void logAndPrint() {
        addToLog(readDate(getNextLine()));
        printLog();
    }

    @Override
    public void startConversation() {
        boolean running = true;
        while (running){   
            System.out.println("What do you want to do?");
            System.out.println("Press 'a' to add another date");
            System.out.println("Press 'q' to quit");
            String input = getNextLine();
            if(input.equals("a")){
                System.out.println("What date do you want to add?");
                try {
                    logAndPrint();
                } catch (Exception e) {
                    System.out.println("Sorry, I don't understand that date.");
                } 
            }else if (input.equals("q")){
                running = false;
            }else{
                System.out.println("Sorry, I don't understand. Try again.");
            }
            System.out.println(); //New line to make terminal more readable.
        }
    }
}

package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChatBot implements IChatBot<Date> {

    private Scanner sc = new Scanner(System.in);

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
        System.out.println(list);

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
            System.out.println(i);
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
        System.out.println(date.toPrintFormat());
    }
}

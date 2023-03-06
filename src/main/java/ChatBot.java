package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JPopupMenu.Separator;

public class ChatBot implements IChatBot<Date> {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String getNextLine() {
        return sc.nextLine();
    }

    @Override
    public ArrayList<String> readDate(String line) { //needs more work
        String sep = "";
        if(line.contains("-"))
            sep = "-";
        if(line.contains("/"))
            sep = "/";
        if(line.contains("-"))
            sep = " ";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(sep)));

        if(list.size() > 3){
            throw new IllegalArgumentException("Mulitple separators used in the same date-expression.");
        }
        if(list.size() < 3){
            throw new IllegalArgumentException("Not enough information in the date-expression.");
        }

        //Month needs to be represented by the first three letters, starting with an upper-case.
        String month = list.get(2);
        try {
            Integer.parseInt(month);
        } catch (NumberFormatException e) {
            char firstLetter = month.charAt(0);
            Character.toUpperCase(firstLetter);
        }
        
        return list;
    }

    @Override
    public Date toDate(ArrayList<String> data) {
        int day = Integer.valueOf(data.get(0));
        Month month = switch (data.get(1)) {
            case "Jan" -> Month.JANUARY;
            case "Feb" -> Month.FEBRUARY;
            case "Mar" -> Month.MARCH;
            case "Apr" -> Month.APRIL;
            case "May" -> Month.MAY;
            case "Jun" -> Month.JUNE;
            case "Jul" -> Month.JULY;
            case "Aug" -> Month.AUGUST;
            case "Sep" -> Month.SEPTEMBER;
            case "Oct" -> Month.OCTOBER;
            case "Nov" -> Month.NOVEMBER;
            case "Dec" -> Month.DECEMBER;
            default -> throw new IllegalArgumentException("Invalid month-format from readDate().");
        };
        int year = Integer.valueOf(data.get(2));
        return new Date(day, month, year);
    }

    @Override
    public void printDate(Date date) {
        System.out.println(date.toPrintFormat());
    }
}

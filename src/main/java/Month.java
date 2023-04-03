package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public int getValueOf(){
        return ordinal() + 1;
    }

    /**
     * Takes an int as input, and returns the corresponding month.
     * @param i - An integer from 1 to 12
     * @return  The month of the given number
     * @throws IndexOutOfBoundsException if i is outside of range (1,12).
     */
    public static Month numToMonth(int i){
        if(i<1 || i>12)
            throw new IndexOutOfBoundsException("Can't recognize this month.");
        return Month.values()[i-1];
    }

     /**
     * Takes a string as input, and returns the corresponding month.
     * @param str - A three-letter string, corresponding to the first letters of a month
     * @return  The corresponding month
     */
    public static Month strToMonth(String str){
        String low = str.toLowerCase();
        int monthNum = months().indexOf(low) + 1;
        return numToMonth(monthNum);
    }

    private static ArrayList<String> months(){
        String[] array = new String[] {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
        return new ArrayList<>(Arrays.asList(array));
    }

    public static String toString(Month m){
        int i = m.getValueOf();
        String str = months().get(i-1);
        String capStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        return capStr;
    }

}

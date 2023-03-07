package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ChatBot cb = new ChatBot();
        String input = "3-8-24";
        Date d = cb.readDate(input);
        d.print();
        boolean readWorks = d.equals(new Date(3, Month.AUGUST, 2024));
        System.out.println(readWorks);
        String line = "hei på deg";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(" ")));
        System.out.println(Integer.valueOf("02"));
        System.out.println(line);
        System.out.println(list);
    }
}

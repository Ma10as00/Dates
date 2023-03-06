package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ChatBot cb = new ChatBot();
        String line = "hei på deg";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(" ")));
        System.out.println(line);
        System.out.println(list);
    }
}

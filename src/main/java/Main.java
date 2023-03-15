package main.java;

import java.io.File;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintStream errors = new PrintStream("error.txt"); 
        errors.flush();
        System.setErr(errors); //Redirects stderr to print in error.txt instead of printing to the terminal
        // ChatBot cb = new ChatBot(new File ("1.in"));
        // ChatBot cb = new ChatBot(new File ("2.in"));
        ChatBot cb = new ChatBot();
        cb.startConversation();
    }
}

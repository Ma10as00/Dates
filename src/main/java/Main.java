package main.java;

import java.io.File;    //In case you want to give input from a file instead of terminal
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintStream errors = new PrintStream("error.txt"); 
        errors.flush();
        System.setErr(errors);  //Redirects stderr to print in error.txt instead of printing to the terminal
        ChatBot cb = new ChatBot(); //To read from file: new ChatBot(new File("filename"));
        cb.startConversation();
    }
}

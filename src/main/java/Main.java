package main.java;

import java.io.File;    //In case you want to give input from a file instead of terminal
import java.io.PrintStream;

public class Main {

    //Change to false if program is ran by machine, e.g. AutoJudge
    private static final boolean USER_IS_HUMAN = true;  

    public static void main(String[] args) throws Exception {
        ChatBot cb = new ChatBot(); //To read from file: new ChatBot(new File("filename"));
        if(USER_IS_HUMAN){
            PrintStream errors = new PrintStream("error.txt"); 
            errors.flush();
            System.setErr(errors);  //Redirects stderr to print in error.txt instead of printing to the terminal
            cb.startConversation();
        }else{
            cb.altConversation();
        }
    }
}

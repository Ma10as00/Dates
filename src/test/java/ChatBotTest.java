package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;
import main.java.*;

public class ChatBotTest{

    ChatBot c = new ChatBot();
    ArrayList<String> input = new ArrayList<>();
    ArrayList<Date> dates = new ArrayList<>();
    ArrayList<String> output = new ArrayList<>();
    

    public void validCases(){
        input.add("3-8-24");
        input.add("14/may/67");
        input.add("25 08 1974");
        dates.add(new Date(3, Month.AUGUST, 2024));
        dates.add(new Date(14, Month.MAY, 1967));
        dates.add(new Date(25, Month.AUGUST, 1974));
        output.add("03 Aug 2024");
        output.add("14 May 1967");
        output.add("25 Aug 1974");
    }

    public void invalidCases(){
        input.add("29 2 1");
        input.add("1212-12-12");
        dates.add(new Date(29, Month.FEBRUARY, 2001));
        dates.add(new Date(1212, Month.DECEMBER,2012));
        output.add("29 Feb 2001 - INVALID");
        output.add("1212 Dec 2012 - INVALID");
    }

    public void reset(){
        input.clear();
        dates.clear();
        output.clear();
    }

    /**
     * Tests that the chatbot reads the dates correctly, i.e. readDate() returns the correct date. 
     */
    @Test
    public void readDateTest() {
        validCases();
        for (int i=0; i<input.size(); i++){
            assertEquals(dates.get(i), c.readDate(input.get(i)));    
        }
        reset();
        invalidCases();
        boolean exceptionThrown = false;
        for (int i=0; i<input.size(); i++){
            try {
                c.readDate(input.get(i)); 
            } catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown); //Check that the chatbot failed to read input
            exceptionThrown = false;    
        }
    }

    /**
     * Tests what the chatbot's printDate()-method is supposed to print. However, this does not test if it is actually printed to System.Out.
     */
    @Test
    public void printFormatTest() {
        validCases();
        for (int i=0; i<input.size(); i++){
            assertEquals(output.get(i), dates.get(i).toPrintFormat());     
        }
        reset();
        invalidCases(); // Should fail, beacuse toPrintFormat() doesn't add the " - INVALID"
        for (int i=0; i<input.size(); i++){
            assertFalse(output.get(i) == dates.get(i).toPrintFormat());     
        }
    }

}

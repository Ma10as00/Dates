package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import main.java.*;

public class ChatBotTest{

    ChatBot c = new ChatBot();
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Date> dates = new ArrayList<>();
    ArrayList<String> printed = new ArrayList<>();

    @BeforeAll
    public void testCases(){
        strings.add("3-8-24");
        strings.add("14/may/67");
        strings.add("25 08 1974");
        dates.add(new Date(3, Month.AUGUST, 2024));
        dates.add(new Date(14, Month.MAY, 1967));
        dates.add(new Date(25, Month.AUGUST, 1974));
        printed.add("03 Aug 2024");
        printed.add("14 May 1967");
        printed.add("25 Aug 1974");
    }

    @Test
    public void readDateTest() {
        for (int i=0; i<strings.size(); i++){
            assertEquals(dates.get(i), c.readDate(strings.get(i)));    
        }
    }

    /**
     * Tests what the chatbot's printDate()-method is supposed to print. However, this does not test if it is actually printed to System.Out.
     */
    @Test
    public void printFormatTest() {
        for (int i=0; i<strings.size(); i++){
            assertEquals(printed.get(i), dates.get(i).toPrintFormat());     
        }
    }
    
}

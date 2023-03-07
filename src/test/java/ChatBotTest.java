package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import main.java.*;

public class ChatBotTest{

    ChatBot c = new ChatBot();

    @Test
    public void readDateTest() {
        String test = "3-8-24";
        Date result = new Date(3, Month.AUGUST, 2024);
        assertEquals(result, c.readDate(test));

        String t1 = "14/may/67";
        Date r1 = new Date(14, Month.MAY, 1967);
        assertEquals(r1, c.readDate(t1));

        String t2 = "25 08 1974";
        Date r2 = new Date(25, Month.AUGUST, 1974);
        assertEquals(r2, c.readDate(t2));
    }

    @Test
    public void printDateTest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printDate'");
    }
    
}

package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.*;

public class DateTest {

    ArrayList<Date> dates = new ArrayList<>();

    public void validCases(){
        dates.add(new Date(3, Month.AUGUST, 2024));
        dates.add(new Date(14, Month.MAY, 1967));
        dates.add(new Date(25, Month.AUGUST, 1974));
        dates.add(new Date(1,Month.APRIL, 2002));
        dates.add(new Date(29,Month.FEBRUARY, 2000));
        dates.add(new Date(1,Month.APRIL, 1753));
        dates.add(new Date(1,Month.APRIL, 3000));
    }

    public void invalidCases(){
        dates.add(new Date(29, Month.FEBRUARY, 2001));
        dates.add(new Date(1212, Month.DECEMBER,2012));
        dates.add(new Date(0,Month.APRIL, 2002));
        dates.add(new Date(29,Month.FEBRUARY, 2002));
        dates.add(new Date(1,Month.APRIL, 1752));
        dates.add(new Date(1,Month.APRIL, 3001));
    }

    public void reset(){
        dates.clear();
    }

    @Test
    public void constructionTest(){
        Date date = new Date(2,Month.MARCH,2004); 
        assertEquals(date.getDay(), 2);
        assertEquals(date.getMonth(), Month.MARCH);
        assertEquals(date.getYear(), 2004);
    }

    @Test
    public void validationTest(){
        validCases();
        for (int i=0; i<dates.size(); i++){
            assertTrue(dates.get(i).isValid());     
        }
        reset();
        invalidCases();
        for (int i=0; i<dates.size(); i++){
            assertFalse(dates.get(i).isValid());    
        }
    }

    @Test
    public void leapYearTest(){
        Date d1 = new Date(1,Month.JANUARY,2000);   //Divisible by 4, 100 and 400
        assertTrue(d1.isLeapYear());
        Date d2 = new Date(1,Month.JANUARY,2200);   //Divisible by 4 and 100
        assertFalse(d2.isLeapYear());
        Date d3 = new Date(1,Month.JANUARY,2001);   //Not divisible by 4
        assertFalse(d3.isLeapYear());
        Date d4 = new Date(1,Month.JANUARY,2004);   //Divisible by 4
        assertTrue(d4.isLeapYear());

    }
}

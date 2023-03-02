package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import main.java.*;

public class DateTest {

    @Test
    public void constructionTest(){
        Date date = new Date(2,Month.MARCH,2004); 
        assertEquals(date.getDay(), 2);
        assertEquals(date.getMonth(), Month.MARCH);
        assertEquals(date.getYear(), 2004);
    }

    @Test
    public void validationTest(){
        Date wrongDay1 = new Date(0,Month.APRIL, 2002);
        Date validDay1 = new Date(1,Month.APRIL, 2002);
        Date wrongDay2 = new Date(29,Month.FEBRUARY, 2002);
        Date validDay2 = new Date(29,Month.FEBRUARY, 2000);
        
        Date wrongYear1 = new Date(1,Month.APRIL, 1752);
        Date validYear1 = new Date(1,Month.APRIL, 1753);
        Date wrongYear2 = new Date(1,Month.APRIL, 3001);
        Date validYear2 = new Date(1,Month.APRIL, 3000);

        assertFalse(wrongDay1.isValid());
        assertFalse(wrongDay2.isValid());
        assertTrue(validDay1.isValid());
        assertTrue(validDay2.isValid());

        assertFalse(wrongYear1.isValid());
        assertFalse(wrongYear2.isValid());
        assertTrue(validYear1.isValid());
        assertTrue(validYear2.isValid());
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

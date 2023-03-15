package main.java;
/**
 * @author Mathias Øgaard
 */
public class Date implements IDate{
    private int day = 0;
    private Month month;
    private int year = 0;

    public Date(int d, Month m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public Month getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isValid() {
        if (month == null){
            return false;
        }            
        if (day < 1 || day > daysInMonth()){
            return false;
        }            
        if (year < 1753 || year > 3000){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void printErrors() {
        if(!isValid()){
            if (month == null)
                monthIsNull();
            if (day < 1 || day > daysInMonth())
                dayOutOfRange();
            if (year < 1753 || year > 3000)
                yearOutOfRange();
        }
    }

    @Override
    public boolean isLeapYear() {
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0)
                    return true;    //Divisible by 4, 100 and 400
                else
                    return false;   //Divisible by 4 and 100
            }else{
                return true;        //Divisible by 4
            }
        }else{
            return false;           //Not divisble by 4
        }
    }

    @Override
    public int daysInMonth() {    
        int days = switch (month) {
                    case JANUARY,MARCH,MAY,JULY,AUGUST,OCTOBER,DECEMBER -> 31;
                    case APRIL,JUNE,SEPTEMBER,NOVEMBER -> 30;
                    case FEBRUARY -> (isLeapYear())? 29 : 28;
                    default -> throw new IllegalArgumentException("Unvalid month for daysInMonth().");
                };
        return days;
    }

    @Override
    public String toPrintFormat() {
        String dayStr = Integer.toString(day);
        if(day<10) dayStr = "0" + dayStr; 
        String monStr = Month.toString(month);
        String yearStr = Integer.toString(year);

        return dayStr + " " + monStr + " " + yearStr;
    }
    
    @Override
    public void yearOutOfRange() {
        System.err.println(toPrintFormat() + ": Invalid year. It is not between 1753 and 3000.");
    }

    @Override
    public void dayOutOfRange() {
        System.err.println(toPrintFormat() + ": The day isn't within the range of the given month. This month has " + daysInMonth() + " days.");
    }

    @Override
    public void monthIsNull() {
        System.err.println(toPrintFormat() + ": This date hasn't been given any month.");
    }

    /**
     * @param o - Object to compare with
     * @return true if {@link o} is a date with the same day, month and year as this.
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Date)){
            return false;
        }else{
            Date d = (Date) o;
            return (d.day == this.day && d.month == this.month && d.year == this.year);
        }
    }
}

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
        if (month == null)
            return false;
        if (day < 1 || day > daysInMonth())
            return false;
        if (year < 1753 || year > 3000)
            return false;
        else
            return true;
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
    public Exception yearOutOfRange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yearOutOfRange'");
    }

    @Override
    public Exception dayOutOfRange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dayOutOfRange'");
    }

    @Override
    public Exception monthOutOfRange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monthOutOfRange'");
    }

    @Override
    public String toPrintFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toPrintFormat'");
    }
}

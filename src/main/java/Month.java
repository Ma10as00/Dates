package main.java;
public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public int getValueOf(){
        return ordinal() + 1;
    }

    /**
     * Takes an int as input, and returns the corresponding month.
     * @param i - An integer from 1 to 12
     * @return  The month of the given number
     */
    public Month numToMonth(int i){
        return switch(i){
            case 1 -> JANUARY;
            case 2 -> FEBRUARY;
            case 3 -> MARCH;
            case 4 -> APRIL;
            case 5 -> MAY;
            case 6 -> JUNE;
            case 7 -> JULY;
            case 8 -> AUGUST;
            case 9 -> SEPTEMBER;
            case 10 -> OCTOBER;
            case 11 -> NOVEMBER;
            case 12 -> DECEMBER;
            default -> throw new IllegalArgumentException("This month doesn't exist.");
        };
    }
}

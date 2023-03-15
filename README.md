## Logging dates

## Description
This program lets you log a set of dates, by feeding the program with appropriate input.
The program structures your input into a Date class, allowing it to easily tell you if the date is valid or not.

If you give the program any invalid dates, it will tell you. The program will log all invalid dates, and why they're considered invalid in the file error.txt.

## Usage
The program should be launched by running the file Main.java.
Check out the file error.txt during or after running the program, to see the log of invalid dates, and why they were invalid.

### Valid Input
The program can understand dates in the following formats:
- Date needs to be in this order: day-month-year
- Day can be given as an int: d, 0d or dd
- Month can be given as one or two digits, or by the first three letters: m,0m,mm, or Mon
- Year can be given as int: yy or yyyy (When using two digits, the program will understand it as a year in the range, 1950-2049)

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

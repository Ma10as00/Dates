# Validate dates

## Description
This program lets you validate dates, by feeding the program with appropriate input.
The program structures your input into a Date class, allowing it to easily tell you if the date is valid or not.

If you give the program any invalid dates, it will tell you. The program will log all invalid dates, and why they're considered invalid in the file error.txt.

## Usage
The program should be launched by running the file Main.java.
Check out the file error.txt after running the program, to see the log of invalid dates, and why they were invalid.
If you want to give the program input from a file, instead of directly typing to the terminal, some simple changes need to be made in the Main-file. The comments in Main.java should guide you to do this the right way. (This was used heavily when testing the program against different text-files)

### Valid Input
The program can understand dates in the following formats:
- Date needs to be in this order: day-month-year
- Day can be given as an int: d, 0d or dd
- Month can be given as one or two digits, or by the first three letters: m,0m,mm, or Mon
- Year can be given as int: yy or yyyy (When using two digits, the program will understand it as a year in the range, 1950-2049)

## Testing
Some simple JUnit-testing have been done to make sure the Date- and Chatbot-classes work as they should.
In addition, the program have been tested on several text-files to see if it generates the wanted output.

## Folder Structure
The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

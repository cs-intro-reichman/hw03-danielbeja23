/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January
    static int countSundays = 0; // count how many sundays were on the first of the month.

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this
     * period.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
        // inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
        // prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days
        // were advanced so far.
        int debugDaysCounter = 0;
        int getYear = Integer.parseInt(args[0]); // get the year.

        while (getYear < getYear + 1) {
            advance();
            year++;
            debugDaysCounter++;
            if (year == getYear) {
                for (int month = 1; month < 13; month++) {
                    for (int dayOfMonth = 1; dayOfMonth <= nDaysInMonth(month, year); dayOfMonth++) {
                        if (dayOfWeek == 1) {
                            System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");

                        } else {
                            System.out.println(dayOfMonth + "/" + month + "/" + year);
                        }
                        dayOfWeek = dayOfWeek + 1;
                        if (dayOfWeek == 8) {
                            dayOfWeek = 1;
                        }

                    }
                }

            }
            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)

            /*
             * if (debugDaysCounter == 2) {
             * break;
             * }
             */

        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {
        for (int month = 1; month < 13; month++) {
            for (int dayOfMonth = 1; dayOfMonth <= nDaysInMonth(month, year); dayOfMonth++) {
                dayOfWeek = dayOfWeek + 1;
                if (dayOfWeek == 8) {
                    dayOfWeek = 1;
                }

            }
        }

    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        boolean isLeap = ((year % 400 == 0));
        isLeap = (isLeap || ((year % 4 == 0) && (year % 100 != 0)));
        return isLeap;
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
                month = 31;
                break;
            case 2:
                month = (isLeapYear(year) ? 29 : 28);
                break;
            case 3:
                month = 31;
                break;
            case 4:
                month = 30;
                break;
            case 5:
                month = 31;
                break;
            case 6:
                month = 30;
                break;
            case 7:
                month = 31;
                break;
            case 8:
                month = 31;
                break;
            case 9:
                month = 30;
                break;
            case 10:
                month = 31;
                break;
            case 11:
                month = 30;
                break;
            case 12:
                month = 31;
                break;

        }
        return month;
    }
}
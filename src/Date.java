import java.util.Objects;

public class Date {
    //FIELDS
    private int day;
    private int month;
    private int year;

    //CONSTRUCTORS
    public Date() {
        this.setDay(25);
        this.setMonth(2);
        this.setYear(2020);
    }

    public Date(int year, int month, int day) {
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    //GETTERS & SETTERS
    public int getDay() {
        return day;
    }

    //Sets the day, increments the month if the day passed is higher than total days in month
    //Sets the day as 1 if day passed is less than or equal to 0
    public void setDay(int day) {
        if (day > daysInMonth()) {
            System.out.println("Day passed: " + day);
            day -= daysInMonth();
            this.setMonth(++this.month);

            this.day = day;
        }
        else if (day <= 0) {
            this.day = 1;
        }
        else {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    //Sets the month, increments the year if month passed is higher than 12
    //Sets the month as 1 if month passed is less than or equal to 0
    public void setMonth(int month) {
        if (month > 12) {
            month -= 12;
            this.setYear(++this.year);
            this.month = month;
        }
        else if (month <= 0) {
            this.month = 1;
        }
        else {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    //Sets year as 2020 if anything lower is passed
    public void setYear(int year) {
        if (year < 2020) {
            this.year = 2020;
        }
        else {
            this.year = year;
        }
    }

    //METHODS + toString()
    public void nextDay() {
        this.setDay(++this.day);
    }

    public void addDays(int days) {
        this.setDay(this.day += days);
    }

    //DO THIS LATER
    public String dayOfWeek() {
        return "Oops";
    }

    public boolean isLeapYear() {
        return (this.year % 4) == 0;
    }

    public int daysInMonth() {
        //Declare variables to check if the month
        //is uneven (which means it has 31 days)
        //August also has 31 days while february only has 28
        boolean isFebruary = (this.month == 2);
        boolean isAugust = (this.month == 8);
        boolean has31Days = (this.month % 2 == 1);


        if (has31Days || isAugust) {
            return 31;
        }
        else if (!has31Days && !isAugust && !isFebruary) {
            return 30;
        }
        else if (isFebruary && !this.isLeapYear()) {
            return 28;
        }
        else if (isFebruary && this.isLeapYear()) {
            return 29;
        }
        else {
            //This statement should never run
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public String toString() {
        return "" + this.day + " " + this.month + " " + this.year + '\n';
    }
}

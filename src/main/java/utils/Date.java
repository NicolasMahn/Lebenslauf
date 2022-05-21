package utils;

import java.util.HashMap;

import static utils.Utils.intArrContains;

/**
 * This clas is a DIY Date Object
 * @author NicolasMahn
 */
public class Date {
    int day = 0;
    int month = 0;
    int year;
    Language language;
    HashMap<Integer, String> monthStringEN = new HashMap<Integer, String>(){{
        put(1, "January");
        put(2, "February");
        put(3, "March");
        put(4, "April");
        put(5, "May");
        put(6, "June");
        put(7, "July");
        put(8, "August");
        put(9, "September");
        put(10, "October");
        put(11, "November");
        put(12, "December");
    }};

    HashMap<Integer, String>  monthStringDE = new HashMap<Integer, String>(){{
        put(1, "Januar");
        put(2, "Februar");
        put(3, "M\u00E4rz");
        put(4, "April");
        put(5, "Mai");
        put(6, "Juni");
        put(7, "Juli");
        put(8, "August");
        put(9, "September");
        put(10, "Oktober");
        put(11, "November");
        put(12, "Dezember");
    }};

    public Date (int day, int month, int year, Language language) {
        int maxDay = getMaxDay(month, year);
        if (day > 0 && day <= maxDay) this.day = day;
        if (month > 0 && month <= 12) this.month = month;
        this.year = year;
        this.language = language;
    }

    public Date (int month, int year, Language language) {
        if (month > 0 && month <= 12) this.month = month;
        this.year = year;
        this.language = language;
    }

    public Date (int year, Language language) {
        this.year = year;
        this.language = language;
    }

    public Date (int day, int month, int year) {
        int maxDay = getMaxDay(month, year);
        if (day > 0 && day <= maxDay) this.day = day;
        if (month > 0 && month <= 12) this.month = month;
        this.year = year;
        this.language = Language.en;
    }

    public Date (int month, int year) {
        if (month > 0 && month <= 12) this.month = month;
        this.year = year;
        this.language = Language.en;
    }

    public Date (int year) {
        this.year = year;
        this.language = Language.en;
    }

    private int getMaxDay(int month, int year) {
        if (intArrContains(new int[] {4, 6, 9, 11}, month)) return 30;
        else if (month == 2 && year%4 == 0) return 29;
        else if (month == 2) return 28;
        else return 31;
    }

    public String toString() {
        if (month == 0) return "" + year;
        else if (day == 0 && language == Language.en) return monthStringEN.get(month) + " " + year;
        else if (day == 0 && language == Language.de) return monthStringDE.get(month) + " " + year;
        else return day + "." + month + "." + year;
    }

}

package objects;

import utils.Languages;
import utils.Utils;

/**
 * @author NicolasMahn
 * This object is used to save my stays abroad
 */
public class StaysAbroad {
    String beginning;
    String departure;
    String country;
    String city;
    String task;
    Languages language;

    /**
     * This is the constructor of the StayAbroad object
     * @param beginning describes when I went abroad
     * @param departure describes when I returned to Germany
     * @param country says in which country I was
     * @param city says in which city I was
     * @param task describes what I did abroad
     * @param language describes the language with which this object should be printed
     */
    public StaysAbroad(String beginning, String departure, String country, String city, String task, Languages language) {
        this.beginning = beginning;
        this.departure = departure;
        this.country = country;
        this.city = city;
        this.task = task;
        this.language = language;
    }

    /**
     * toString converts the object to a string for printing.
     * @return object as String
     */
    @Override
    public String toString() {
        int space = city.length() + country.length() + 3;
        String s= city + ", " + country + " ";
        if (language == Languages.de) s += "vom " + beginning + " bis " + departure;
        else s += "from " + beginning + " to " + departure;
        s += "\n" + Utils.getSpace(space) + Utils.newLine(task, space) + "\n";
        return s;
    }
}
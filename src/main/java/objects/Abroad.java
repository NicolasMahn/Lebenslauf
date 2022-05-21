package objects;

import utils.Date;
import utils.Language;
import static utils.Utils.*;

/**
 * @author NicolasMahn
 * This object is used to save my stays abroad
 */
public class Abroad {
    Date beginning;
    Date departure;
    String country;
    String city;
    String task;
    Language language;

    /**
     * This is the constructor of the StayAbroad object
     * @param beginning describes when I went abroad
     * @param departure describes when I returned to Germany
     * @param country says in which country I was
     * @param city says in which city I was
     * @param task describes what I did abroad
     * @param language describes the language with which this object should be printed
     */
    public Abroad(Date beginning, Date departure, String country, String city, String task, Language language) {
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
        int space = city.length() + country.length() + 6;
        String s= "In " + city + ", " + country + ", ";
        if (language == Language.de) s += "von " + beginning + " bis " + departure;
        else s += "from " + beginning + " to " + departure;
        s += "\n" + getSpace(space) + newLine(task, space) + "\n";
        return s + "\n";
    }
}
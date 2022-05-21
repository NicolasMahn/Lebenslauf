package objects;

import utils.Date;
import utils.Language;
import static utils.Utils.*;

/**
 * @author NicolasMahn
 * This object is used to save my educational path and professional experiences.
 */
public class Activity {
    Date from;
    Date to;
    String what;
    String degree;
    String where;
    String miscellaneous;
    String location;
    Language language;

    /**
     * This is the constructor of the EducationalPath object.
     * @param from describes when I started this activity
     * @param to describes when I finished this activity
     * @param what did I do at the activity
     * @param degree indicates the degree with which the activity was completed
     * @param where did I do the activity
     * @param location in what city did I do it
     * @param miscellaneous is a free text for miscellaneous information
     * @param language describes the language with which this object should be printed
     */
    public Activity(Date from, Date to, String what, String degree, String where, String location,
                    String miscellaneous, Language language) {
        this.from = from;
        this.to = to;
        this.what = what;
        this.degree = degree;
        this.where = where;
        this.location = location;
        this.miscellaneous = miscellaneous;
        this.language = language;
    }

    /**
     * toString converts the object to a string for printing.
     * @return object as String
     */
    @Override
    public String toString() {
        String s = what +": ";
        String space = getSpace(s.length());
        if (language == Language.de) {
            if (to == null) s += "Seit " + from + "\n";
            else if (from == null) s += "Bis " + to + "\n";
            else s += "Von " + from + "-" + to + "\n";
            s += space + where;
            if (location != null)
                s += " in " + newLine(location, space.length()+ where.length()+4, space.length());
            if (degree != null) s += "\n" + space + "Abschluss: " + newLine(degree, space.length()+11);
        } else {
            if (to == null) s += "Since " + from + "\n";
            else if (from == null) s += "Up to " + to + "\n";
            else s += "From the " + from + "-" + to + "\n";
            s += space + where;
            if (location != null)
                s += " in " + newLine(location, space.length()+ where.length()+4, space.length());
            if (degree != null) s += "\n" + space + "degree: " + newLine(degree, space.length()+8);
        }
        if (miscellaneous != null) s += "\n" + space + newLine(miscellaneous, space.length());
        s += "\n";
        return s + "\n";
    }
}
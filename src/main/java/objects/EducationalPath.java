package objects;

import utils.Languages;
import utils.Utils;

/**
 * @author NicolasMahn
 * This object is used to save my educational path.
 * In this case, educational path summarizes both my education and my professional life.
 */
public class EducationalPath {
    String from;
    String to;
    String what;
    String degree;
    String where;
    String miscellaneous;
    String location;
    Languages language;

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
    public EducationalPath(String from, String to, String what, String degree, String where, String location,
                    String miscellaneous, Languages language) {
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
        String space = Utils.getSpace(s.length());
        if (language == Languages.de) {
            if (to == null) s += "Seit " + from + "\n";
            else if (from == null) s += "Bis " + to + "\n";
            else s += "Von " + from + "-" + to + "\n";
            s += space + where;
            if (location != null)
                s += " in " + Utils.newLine(location, space.length()+ where.length()+4, space.length());
            if (degree != null) s += "\n" + space + "Abschluss: " + Utils.newLine(degree, space.length()+11);
        } else {
            if (to == null) s += "Since " + from + "\n";
            else if (from == null) s += "Up to " + to + "\n";
            else s += "From the " + from + "-" + to + "\n";
            s += space + where;
            if (location != null)
                s += " in " + Utils.newLine(location, space.length()+ where.length()+4, space.length());
            if (degree != null) s += "\n" + space + "degree: " + Utils.newLine(degree, space.length()+8);
        }
        if (miscellaneous != null) s += "\n" + space + Utils.newLine(miscellaneous, space.length());
        s += "\n";
        return s;
    }
}
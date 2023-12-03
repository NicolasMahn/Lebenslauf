package objects;

import utils.Language;
import static utils.Utils.*;

/**
 * @author NicolasMahn
 * This object is used to store my experiences. (just like Dumbledore does)
 * With experience I mainly mean scientific work that I did during my studies
 */
public class Experience {
    String time;
    String typ;
    String description;
    Language language;
    String link = null;

    /**
     * This is the constructor of the experience object
     * @param time describes in which semester I wrote the thesis
     * @param typ describes what typ of thesis I wrote
     * @param description A free text in which the experience is briefly described
     * @param link A link to the project on GitHub
     * @param language describes the language with which this object should be printed
     */
    public Experience(String time, String typ, String description, String link, Language language) {
        this.time = time;
        this.typ = typ;
        this.description = description;
        this.link = link;
        this.language = language;
    }

    /**
     * This is the constructor of the experience object
     * in case there is no GitHubLink
     * @param time describes in which semester I wrote the thesis
     * @param typ describes what typ of thesis I wrote
     * @param description A free text in which the experience is briefly described
     * @param language describes the language with which this object should be printed
     */
    public Experience(String time, String typ, String description, Language language) {
        this.time = time;
        this.typ = typ;
        this.description = description;
        this.language = language;
    }

    /**
     * toString converts the object to a string for printing.
     * @return object as String
     */
    @Override
    public String toString() {
        int NLSPACE = 10;
        String s;
        if (language == Language.de) {
            if (typ.equals("Paper")) {
                s = typ + " mit dem Thema \"" + newLine((description + "\""), typ.length() + 16, NLSPACE);
                if (link != null) s += "\n" + getSpace(NLSPACE) + link;
                s += "\n" + getSpace(NLSPACE) + time;
            } else {
                s = typ + " \u00FCber " + newLine(description, typ.length() + 6, NLSPACE);
                if (link != null) s += "\n" + getSpace(NLSPACE) + "Zum Projekt: " + link;
                s += "\n" + getSpace(NLSPACE) + time;
            }
        } else {
            s = typ + " about " + newLine(description, typ.length() + 6, NLSPACE);
            if (link != null) s += "\n" + getSpace(NLSPACE) + "To the Project: " + link;
            s += "\n" + getSpace(NLSPACE) + time;
        }
        return s + "\n";
    }
}
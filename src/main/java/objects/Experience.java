package objects;

import utils.Languages;
import utils.Utils;

/**
 * @author NicolasMahn
 * This object is used to store my experiences. (just like Dumbledore does)
 * With experience I mainly mean scientific work that I did during my studies
 */
public class Experience {
    int semester;
    String typ;
    String description;
    Languages language;
    String gitHubLink = null;

    /**
     * This is the constructor of the experience object
     * @param semester describes in which semester I wrote the thesis
     * @param typ describes what typ of thesis I wrote
     * @param description A free text in which the experience is briefly described
     * @param gitHubLink A link to the project on GitHub
     * @param language describes the language with which this object should be printed
     */
    public Experience(int semester, String typ, String description, String gitHubLink, Languages language) {
        this.semester = semester;
        this.typ = typ;
        this.description = description;
        this.gitHubLink = gitHubLink;
        this.language = language;
    }

    /**
     * This is the constructor of the experience object
     * in case there is no GitHubLink
     * @param semester describes in which semester I wrote the thesis
     * @param typ describes what typ of thesis I wrote
     * @param description A free text in which the experience is briefly described
     * @param language describes the language with which this object should be printed
     */
    public Experience(int semester, String typ, String description, Languages language) {
        this.semester = semester;
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
        if (language == Languages.de) {
            s = typ + " \u00FCber " + Utils.newLine(description, typ.length() + 6, NLSPACE);
            if (gitHubLink != null) s += "\n" + Utils.getSpace(NLSPACE) + "GitHub Link: " + gitHubLink;
            s += "\n" + Utils.getSpace(NLSPACE) + semester + " Semester\n";
        } else {
            s = typ + " about " + Utils.newLine(description, typ.length() + 6, NLSPACE);
            if (gitHubLink != null) s += "\n" + Utils.getSpace(NLSPACE) + "GitHub link: " + gitHubLink;
            s += "\n" + Utils.getSpace(NLSPACE) + semester + " semester\n";
        }
        return s;
    }
}
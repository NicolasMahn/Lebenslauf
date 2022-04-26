package objects;

import utils.Languages;
import utils.Utils;

/**
 * @author NicolasMahn
 * My qualifications are saved in this object
 */
public class Qualification {
    MainTopic mainTopic;
    String qualification;
    int grade = 0; //from 1-6 in german school grades or A-F in the american system
    static MainTopic prev = null;
    Languages language;

    /**
     * The main topics are defined in this enum
     */
    public enum MainTopic {
        fl, //Foreign languages
        pl, //Programming languages
        ml, //modeling languages
        oq  //other qualifications
    }

    /**
     * This is the constructor of the object
     * @param mainTopic describes the overarching theme of qualification
     * @param qualification this attribute means the name of the qualification
     * @param grade This is where I save how well I know the subject based on my own evaluation
     * @param language describes the language with which this object should be printed
     */
    public Qualification(MainTopic mainTopic, String qualification, int grade, Languages language) {
        this.mainTopic = mainTopic;
        this.qualification = qualification;
        this.grade = grade;
        this.language = language;
    }

    /**
     * This is the second constructor of the object
     * @param mainTopic describes the overarching theme of qualification
     * @param qualification this attribute means the name of the qualification
     * @param language describes the language with which this object should be printed
     */
    public Qualification(MainTopic mainTopic, String qualification, Languages language) {
        this.mainTopic = mainTopic;
        this.qualification = qualification;
        this.language = language;
    }

    /**
     * toString converts the object to a string for printing.
     * @return object as String
     */
    @Override
    public String toString() {
        final int SPACEGRADE = 15;
        String s = "";
        String mt = "";
        if (prev != mainTopic) {
            if (prev != null) s += "\n";
            if (language == Languages.de) {
                if (mainTopic == MainTopic.fl) s += " ### Fremdsprachen:\n";
                if (mainTopic == MainTopic.pl) s += " ### Programmiersprachen:\n";
                if (mainTopic == MainTopic.ml) s += " ### Modellierungssprachen:\n";
                if (mainTopic == MainTopic.oq) s += " ### Andere Qualifikationen:\n";
            } else {
                if (mainTopic == MainTopic.fl) s += " ### Foreign Languages:\n";
                if (mainTopic == MainTopic.pl) s += " ### Programming Languages:\n";
                if (mainTopic == MainTopic.ml) s += " ### Modeling Languages:\n";
                if (mainTopic == MainTopic.oq) s += " ### Other Qualifications:\n";
            }
            prev = mainTopic;
        }
        s += qualification;
        if (language == Languages.de) {
            if (grade != 0) {
                String space = Utils.getSpace(SPACEGRADE - qualification.length());
                s += space + "Eigene Bewertung: ";
                switch (grade) {
                    case 1:
                        s += "sehr gut";
                        break;
                    case 2:
                        s += "gut";
                        break;
                    case 3:
                        s += "befriedigend";
                        break;
                    case 4:
                        s += "ausreichend";
                        break;
                    case 5:
                        s += "mangelhaft";
                        break;
                    case 6:
                        s += "ungen\u00FCgent";
                        break;
                }
            }
        } else {
            if (grade != 0) {
                String space = Utils.getSpace(SPACEGRADE - qualification.length());
                s += space + "Own Rating: ";
                switch (grade) {
                    case 1:
                        s += "A";
                        break;
                    case 2:
                        s += "B";
                        break;
                    case 3:
                        s += "C";
                        break;
                    case 4:
                        s += "D";
                        break;
                    default:
                        s += "F";
                        break;
                }
            }
        }
        return s;
    }
}
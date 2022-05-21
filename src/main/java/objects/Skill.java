package objects;

import utils.Language;
import static utils.Utils.*;

/**
 * @author NicolasMahn
 * My qualifications are saved in this object
 */
public class Skill {
    String qualification;
    int iGrade = 0;
    String sGrade = null;
    Language language;

    /**
     * This is the constructor of the object
     * @param qualification this attribute means the name of the qualification
     * @param grade This is where I save how well I know the subject based on my own evaluation
     * @param language describes the language with which this object should be printed
     */
    public Skill(String qualification, int grade, Language language) {
        this.qualification = qualification;
        this.iGrade = grade;
        this.language = language;
    }

    /**
     * This is the constructor of the object
     * @param qualification this attribute means the name of the qualification
     * @param grade This is where I save how well I know the subject based on my own evaluation
     * @param language describes the language with which this object should be printed
     */
    public Skill(String qualification, String grade, Language language) {
        this.qualification = qualification;
        this.sGrade = grade;
        this.language = language;
    }

    /**
     * This is the second constructor of the object
     * @param qualification this attribute means the name of the qualification
     * @param language describes the language with which this object should be printed
     */
    public Skill(String qualification, Language language) {
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
        String o = ":";
        String q = "#";
        //String o = "\u25CB";
        //String q = "\u25C9";
        //String o = "\u25A1";
        //String q = "\u25A0";
        String s = "";
        s += qualification;
        if (iGrade != 0) {
            String space = getSpace(SPACEGRADE - qualification.length());
            s += space;
            switch (iGrade) {
                case 1:
                    s += o+o+o+o+q;
                    break;
                case 2:
                    s += q+q+o+o+o;
                    break;
                case 3:
                    s += q+q+q+o+o;
                    break;
                case 4:
                    s += q+q+q+q+o;
                    break;
                case 5:
                    s += q+q+q+q+q;
                    break;
            }
        } else if (sGrade != null){
            String space = getSpace(SPACEGRADE - qualification.length());
            s += space + sGrade;
        }

        return s + "\n";
    }
}
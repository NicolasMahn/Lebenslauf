/**
 * @author NicolasMahn
 * In diesem Pbjekt koennen meine Qualtifikationen gespeichert werden
 */
class Qualifikation{
    Ueberthema ueberthema;
    String qualifikation;
    int note = 0; //von 1-6 in Schulnoten
    static Ueberthema prev = null;

    /**
     * In diesem Enum werden die Ueberthemen definiert
     */
    enum Ueberthema {
        Fremdsprachen,
        Programmiersprachen,
        Modellierungssprachen,
        sonstige_Qualifikationen
    }

    /**
     * Das ist der Konstruktor des Objekts
     * @param ueberthema beschreibt das Ueberthema der Qualifikation
     * @param qualifikation mit diesem Attribut ist der Name der Qualifikation gemeint
     * @param note Hie wird nach eigener Bewertung abgespeichert wie gut ich mich mit dem
     *             Thema auskenne
     */
    Qualifikation(Ueberthema ueberthema, String qualifikation, int note) {
        this.ueberthema = ueberthema;
        this.qualifikation = qualifikation;
        this.note = note;
    }

    /**
     * Das ist der zweite Konstruktor des Objekts
     * @param ueberthema beschreibt das Ueberthema der Qualifikation
     * @param qualifikation mit diesem Attribut ist der Name der Qualifikation gemeint
     */
    Qualifikation(Ueberthema ueberthema, String qualifikation) {
        this.ueberthema = ueberthema;
        this.qualifikation = qualifikation;
    }

    /**
     * toString wandelt das Objekt in einen String um, um ihn ausgeben zu koennen.
     * @return Objekt als String
     */
    @Override
    public String toString() {
        final int SPACENOTE = 15;
        String s = "";
        if (prev != ueberthema) {
            if (prev != null) s+= "\n";
            s += " ### " + ueberthema + ":\n";
            prev = ueberthema;
        }
        s +=  qualifikation;
        if (note != 0) {
            String space = Utils.getSpace(SPACENOTE - qualifikation.length());
            s += space + "Eigene Bewertung: ";
            switch (note) {
                case 1: s += "sehr gut";
                    break;
                case 2: s += "gut";
                    break;
                case 3: s += "befriedigend";
                    break;
                case 4: s += "ausreichend";
                    break;
                case 5: s += "mangelhaft";
                    break;
                case 6: s += "ungen\u00FCgent";
                    break;
            }
        }
        return s;
    }
}
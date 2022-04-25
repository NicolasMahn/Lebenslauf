/**
 * @author NicolasMahn
 * Dieses Objekt wird zum speichern meiner Erfahrungen genutzt.
 * Mit Erfahrungen sind hier hauptsaechlich wissenschaftliche Arbeiten gemeint,
 * welche ich im Lauf meines Studiums gemacht habe
 */
class Erfahrung{
    int semester;
    String art;
    String beschreibung;
    String gitHubLink = null;

    /**
     * Das ist der Konstruktor des Erfahrungsobjekts
     * @param semester beschreibt in welchem Semester ich die Arbeit geschrieben habe
     * @param art beschreibt was ich gemacht habe i.e. Hausarbeit oder Projekt...
     * @param beschreibung Ein Freitext in welchem die Erfahrung kurz beschrieben wird
     * @param gitHubLink Ein Link zu dem Projekt auf GitHub wenn vorhanden
     */
    Erfahrung(int semester, String art, String beschreibung, String gitHubLink) {
        this.semester = semester;
        this.art = art;
        this.beschreibung = beschreibung;
        this.gitHubLink = gitHubLink;
    }

    /**
     * Das ist der zweite Konstruktor des Erfahrungsobjekt,
     * fuer den Fall, dass es keinen GitHubLink gibt
     * @param semester beschreibt in welchem Semester ich die Arbeit geschrieben habe
     * @param art beschreibt was ich gemacht habe i.e. Hausarbeit oder Projekt...
     * @param beschreibung Ein Freitext in welchem die Erfahrung kurz beschrieben wird
     */
    Erfahrung(int semester, String art, String beschreibung) {
        this.semester = semester;
        this.art = art;
        this.beschreibung = beschreibung;
    }

    /**
     * toString wandelt das Objekt in einen String um, um ihn ausgeben zu koennen.
     * @return Objekt als String
     */
    @Override
    public String toString() {
        int NLSPACE = 10;
        String s = art + " \u00FCber " + Utils.newLine(beschreibung, art.length()+6, NLSPACE);
        if (gitHubLink != null) s += "\n" + Utils.getSpace(NLSPACE) + "GitHub Link: " + gitHubLink;
        s += "\n" + Utils.getSpace(NLSPACE) + semester + " Semester\n";
        return s;
    }
}
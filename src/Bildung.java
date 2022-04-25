/**
 * @author NicolasMahn
 * Dieses Objekt wird zum speichern meines Bildungsweges verwendet.
 * Unter Bildung wird in diesem Fall sowohl mein Bildungsweg und mein
 * bisheriges Berufsleben zusammengefasst.
 */
class Bildung{
    String von;
    String bis;
    String was;
    String abschluss;
    String wo;
    String sonstiges;
    String ort;

    /**
     * Das ist der Konstruktor des Bildungsobjekts.
     * @param von beschreibt wann ich mit dieser Taetigkeit angefangen habe
     * @param bis beschreibt wann ich diese Taetigkeit abgeschlossen habe
     * @param was beschreibt die Taetigkeit die ich gemacht habe
     * @param abschluss gibt an mit welchem Abschluss die Taetigkeit beendet wurde
     * @param wo beschreibt an welchem Institut die Taetigkeit stattgefunden hat
     * @param ort beschreibt die Stadt wo die Taetigkeit stattgefunden hat
     * @param sonstiges ist ein Freitext um besonderheiten festzuhalten
     */
    Bildung(String von, String bis, String was, String abschluss, String wo, String ort, String sonstiges) {
        this.von = von;
        this.bis = bis;
        this.was = was;
        this.abschluss = abschluss;
        this.wo = wo;
        this.ort = ort;
        this.sonstiges = sonstiges;
    }

    /**
     * toString wandelt das Objekt in einen String um, um ihn ausgeben zu koennen.
     * @return Objekt als String
     */
    @Override
    public String toString() {
        String s = was+": ";
        String space = Utils.getSpace(s.length());
        if (bis == null) s += "Seit "+von+"\n";
        else if (von == null) s += "Bis "+bis+"\n";
        else s += "Von "+von+"-"+bis+"\n";
        s += space+wo;
        if (ort != null) s += " in " + Utils.newLine(ort, space.length()+wo.length()+4, space.length());
        if (abschluss != null) s += "\n" + space + "Abschluss: " + Utils.newLine(abschluss, space.length()+11);
        if (sonstiges != null) s += "\n" + space + "(" + Utils.newLine(sonstiges, space.length())+")";
        s += "\n";
        return s;
    }
}
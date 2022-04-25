/**
 * @author NicolasMahn
 * Dieses Objekt wird zum speichern meiner Auslandsaufenthalte genutzt
 */
class Auslandsaufenthalt{
    String antritt;
    String abreise;
    String land;
    String stadt;
    String taetigkeit;

    /**
     * Das ist der Kunstruktor des Auslandsaufenthaltobjekts
     * @param antritt beschreibt wann ich ins Ausland gefahren bin
     * @param abreise beschreibt wann ich nach Deutschland zurueckgekehrt bin
     * @param land sagt aus in welchem Land ich war
     * @param stadt sagt aus in welcher Stadt ich war
     * @param taetigkeit beschreibt was ich im Ausland gemacht habe
     */
    Auslandsaufenthalt(String antritt, String abreise, String land, String stadt, String taetigkeit) {
        this.antritt = antritt; this.abreise = abreise;
        this.land = land; this.stadt = stadt;	this.taetigkeit = taetigkeit;
    }

    /**
     * toString wandelt das Objekt in einen String um, um ihn ausgeben zu koennen.
     * @return Objekt als String
     */
    @Override
    public String toString() {
        String s= stadt+ ", " + land + " ";
        int len = s.length();
        s += "vom " + antritt + " bis " + abreise;
        s += "\n" + Utils.newLine(taetigkeit, stadt.length()+land.length()+3, 0) + "\n";
        return Utils.addSpace(s, len);
    }
}
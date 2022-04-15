import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Diese Klasse beschreibt meinen Lebenslauf.
 */
public class Lebenslauf {
    static final int MAXLINELENGTH = 80;
    static boolean open = true;

    /**
     * Diese Methode speichert meine persoenlichen Daten in einer HashMap.
     * @return wird die HashMap mit den pers. Daten
     */
    public static String persoenlicheDaten() {
        HashMap<String, String> persInfo = new HashMap<>(){{
            put("Name", "Nicolas Mahn");
            put("Adresse", "Untere Brandstra\u00DFe 62, 70567 Stuttgart");
            put("E-Mail", "Nicolas.Mahn@gmx.de");
            put("Tel.", "015206501315");
            put("Geboren", "2000-08-07 in Stuttgart");}};
        return hashMapToString(persInfo);
    }

    /**
     * Dieses Objekt wird zum speichern meines Bildungsweges verwendet.
     * Unter Bildung wird in diesem Fall sowohl mein Bildungsweg und mein
     * bisheriges Berufsleben zusammengefasst.
     */
    public static class Bildung{
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
        public Bildung(String von, String bis, String was, String abschluss, String wo, String ort, String sonstiges) {
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
            String space = getSpace(s.length());
            if (bis == null) s += "Seit "+von+"\n";
            else if (von == null) s += "Bis "+bis+"\n";
            else s += "Von "+von+"-"+bis+"\n";
            s += space+wo;
            if (ort != null) s += " in " + newLine(ort, space.length()+wo.length()+4, space.length());
            if (abschluss != null) s += "\n"+space+"Abschluss: " + newLine(abschluss, space.length()+11);
            if (sonstiges != null) s += "\n"+space+"("+newLine(sonstiges, space.length())+")";
            s += "\n";
            return s;
        }
    }

    /**
     * Diese Methode erstellt Bildungsobjekte aus meinen bisherigen Taetigkeiten.
     * @return wird ein Tuple mit allen 4 Bildungsobjekten
     */
    public static Tuple4<Bildung, Bildung, Bildung, Bildung> bildung() {
        Bildung studium = new Bildung("09.2019", null,
                "Wirtschaftsinformatik Studium",
                "voraussichtlich Bachelor of Science im Jahr 2023",
                "Hochschule Furtwangen (HFU)",
                "Furtwangen im Schwarzwald",
                "besondere Interessen: Machine Learning, Data Science und Software-Entwicklung");

        Bildung werkStudent = new Bildung("01.11.2021", "31.03.2022",
                "Werkstudent",
                null,
                "DB Systel",
                null,
                null);

        Bildung praktikum = new Bildung("01.04.2021", "30.09.2021",
                "Praktikum",
                null,
                "DB Netz AG",
                null,
                "im Konzernprogramm Digitale Schiene Deutschland.");

        Bildung schule = new Bildung(null, "2018",
                "Gymnasium",
                "Abitur",
                "am K\u00F6nigin-Charlotte-Gymnasium",
                "Stuttgart",
                "bilingualer Zug");

        return new Tuple4<>(studium, werkStudent, praktikum, schule);
    }

    /**
     * Dieses Objekt wird zum speichern meiner Erfahrungen genutzt.
     * Mit Erfahrungen sind hier hauptsaechlich wissenschaftliche Arbeiten gemeint,
     * welche ich im Lauf meines Studiums gemacht habe
     */
    public static class Erfahrung{
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
        public Erfahrung(int semester, String art, String beschreibung, String gitHubLink) {
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
        public Erfahrung(int semester, String art, String beschreibung) {
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
            String s = art + " \u00FCber " + newLine(beschreibung, art.length()+6, NLSPACE);
            if (gitHubLink != null) s += "\n" + getSpace(NLSPACE) + "GitHub Link: " + gitHubLink;
            s += "\n" + getSpace(NLSPACE) + semester + " Semester\n";
            return s;
        }
    }

    /**
     * Diese Methode speichert meine Erfahrungen in das entsprechende Objekt
     * @return ArrayListe mit allen Erfahrungsobjekten
     */
    public static Tuple9<Erfahrung, Erfahrung, Erfahrung, Erfahrung, Erfahrung,
            Erfahrung, Erfahrung, Erfahrung, Erfahrung> studium() {

        Erfahrung cph = new Erfahrung(2, "Wissenschaftliche Arbeit",
                "Cyber Physical Hacks");
        Erfahrung pa = new Erfahrung(2, "Hausarbeit",
                "Make-or-Buy-Prozess-Analyse mit Gesch\u00E4ftsprozess-design-Sprachen");
        Erfahrung as = new Erfahrung(2, "Hausarbeit",
                "Assembler und Systemarchitektur");
        Erfahrung ear = new Erfahrung(3, "Projekt",
                "Entwicklung eines Algorithmus zur Routenfindung von E-LKWs in Java" +
                        "(Anwendungsschicht), MongoDB (Datenhaltungsschicht) und PHP/JS" +
                        "(Pr\u00E4sentationsschicht)");
        Erfahrung bi1 = new Erfahrung(5, "Projekt",
                "Business Intelligence 1: Big Data Analitics Projekt mit Spark",
                "https://github.com/1Zero64/BusinessIntelligence");
        Erfahrung bi2 = new Erfahrung(5, "Projekt",
                "Business Intelligence 2: Machine Learning Projekt mit R",
                "https://github.com/NicolasMahn/BusinessIntelligence2");
        Erfahrung defi = new Erfahrung(5, "Wissenschaftliche Arbeit",
                "decentralized Finance (DeFi)");
        Erfahrung ipm = new Erfahrung(5, "Projekt",
                "Entwicklung eines Intelligenten Packetmanagement-System in Python," +
                        "anhand eines TSP Algorithmus",
                "https://github.com/NicolasMahn/IntPakman");
        Erfahrung ma = new Erfahrung(1, "Marktanalyse",
                "die Stadtkartenbranche wurde f\u00FCr ein Unternehmen durchgef\u00FChrt," +
                        "am Institut f\u00FCr Business Consulting (IBC) eine studentische Unternehmensberatung");

        return new Tuple9<>(cph, pa, as, ear, bi1, bi2, defi, ipm, ma);
    }

    /**
     * Dieses Objekt wird zum speichern meiner Auslandsaufenthalte genutzt
     */
    public static class Auslandsaufenthalt{
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
        public Auslandsaufenthalt(String antritt, String abreise, String land, String stadt, String taetigkeit) {
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
            s += "\n" + newLine(taetigkeit, stadt.length()+land.length()+3, 0) + "\n";
            return addSpace(s, len);
        }
    }

    /**
     * Diese Methode speichert meine Auslandsaufenthalte in einem Objekten ab
     * @return wird ein Tuple mit 3 Objekten
     */
    public static Tuple3<Auslandsaufenthalt, Auslandsaufenthalt, Auslandsaufenthalt> auslandsaufenthalte() {
        Auslandsaufenthalt nordirland = new Auslandsaufenthalt
                ("03.2009", "07.2009", "Nordirland", "In Sion Mills",
                        "Besuch der Sion Mills Primary School");

        Auslandsaufenthalt frankreich = new Auslandsaufenthalt
                ("03.2013", "07.2013", "Frankreich","In Lyon",
                        "Besuch des Coll\u00E8ge Charles de Foucault");

        Auslandsaufenthalt uganda = new Auslandsaufenthalt
                ("08.2018", "08.2019", "Uganda", "In Kampala",
                        "Aushilfslehrer f\u00FCr Mathematik und Science " +
                                "an der Kawempe Youth Development Association " +
                                "Primary School und der Makarere West Valley Primary School");

        return new Tuple3<>(nordirland, frankreich, uganda);
    }

    /**
     * Diese Methode speichert meine Freizeitaktivitaeten in Strings ab
     * @return werden die Strings als Tuple
     */
    public static Tuple3<String, String, String> engagementFreizeit() {
        String pfadfinder = "Deutsche Pfadfinderschaft Sankt Georg \n" +
                            "01.2017 - 07.2018 Jugendleiter \n" +
                            "Teilnahme an Hilfsprojekten auf den Philippinen und in Pal\u00E4stina\n";

        String fachschaft = "seit anfang 2020 Mitglied der Fachschaft Wirtschaftsinformatik " +
                            "\nder Hochschule Furtwangen\n";

        String hobbys = "Sport (Joggen, Fitnesstraining)\n" +
                        "Computerspiele (Minecraft, AOE)\n";

        return new Tuple3<>(pfadfinder, fachschaft, hobbys);
    }

    /**
     * In diesem Enum werden die Ueberthemen definiert
     */
    public enum Ueberthema {
        Fremdsprachen,
        Programmiersprachen,
        Modellierungssprachen,
        sonstige_Qualifikationen
    }

    /**
     * In diesem Pbjekt koennen meine Qualtifikationen gespeichert werden
     */
    public static class Qualifikation{
        Ueberthema ueberthema;
        String qualifikation;
        int note = 0; //von 1-6 in Schulnoten
        static Ueberthema prev = null;

        /**
         * Das ist der Konstruktor des Objekts
         * @param ueberthema beschreibt das Ueberthema der Qualifikation
         * @param qualifikation mit diesem Attribut ist der Name der Qualifikation gemeint
         * @param note Hie wird nach eigener Bewertung abgespeichert wie gut ich mich mit dem
         *             Thema auskenne
         */
        public Qualifikation(Ueberthema ueberthema, String qualifikation, int note) {
            this.ueberthema = ueberthema;
            this.qualifikation = qualifikation;
            this.note = note;
        }

        /**
         * Das ist der zweite Konstruktor des Objekts
         * @param ueberthema beschreibt das Ueberthema der Qualifikation
         * @param qualifikation mit diesem Attribut ist der Name der Qualifikation gemeint
         */
        public Qualifikation(Ueberthema ueberthema, String qualifikation) {
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
                String space = getSpace(SPACENOTE - qualifikation.length());
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

    /**
     * Diese Methode speichert meine Qualifikationen in einem Objekten ab
     * @return wird ein Tuple mit 4 Objekten
     */
    public static Tuple20<Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation,
            Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation,
            Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation>
    qualifikationen() {
        Qualifikation eng = new Qualifikation(Ueberthema.Fremdsprachen,"Englisch",1);
        Qualifikation fr = new Qualifikation(Ueberthema.Fremdsprachen,"Franz\u00F6sisch",2);

        Qualifikation java = new Qualifikation(Ueberthema.Programmiersprachen,"Java", 1);
        Qualifikation x86 = new Qualifikation(Ueberthema.Programmiersprachen,"x86 Assembler", 1);
        Qualifikation py = new Qualifikation(Ueberthema.Programmiersprachen,"Python",  1);
        Qualifikation sql = new Qualifikation(Ueberthema.Programmiersprachen,"SQL", 2);
        Qualifikation noSql = new Qualifikation(Ueberthema.Programmiersprachen,"NoSQL", 2);
        Qualifikation wd = new Qualifikation(Ueberthema.Programmiersprachen,"Webdesign", 2);
        Qualifikation gql = new Qualifikation(Ueberthema.Programmiersprachen,"GraphQL", 3);

        Qualifikation uml = new Qualifikation(Ueberthema.Modellierungssprachen,"UML", 2);
        Qualifikation bpmn = new Qualifikation(Ueberthema.Modellierungssprachen,"BPMN", 3);
        Qualifikation fc = new Qualifikation(Ueberthema.Modellierungssprachen,"Flowchart", 3);
        Qualifikation epk = new Qualifikation(Ueberthema.Modellierungssprachen,"EPK", 3);

        Qualifikation mw = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"Microsoft Word");
        Qualifikation ltx = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"LaTeX");
        Qualifikation mpp = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"Microsoft Power Point");
        Qualifikation me = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"Microsoft Excel");
        Qualifikation mt = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"Microsoft Teams");
        Qualifikation zoom = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"Zoom");
        Qualifikation sap = new Qualifikation(Ueberthema.sonstige_Qualifikationen,"SAP");

        return new Tuple20<>(eng, fr, java, x86, py, sql, noSql, wd, gql,uml, bpmn,
                fc, epk, mw, ltx, mpp, me, mt, zoom, sap);
    }

    /**
     * Die main Methode der Klasse
     * @param args
     */
    public static void main(String[] args) {
        makeLebenslauf();
    }

    /**
     * In dieser Methode werden die meisten Funktionen der Klasse ausgefuehrt
     */
    public static void makeLebenslauf() {
        ueberschrift();
        print(persoenlicheDaten(), "pers\u00F6nliche Daten");
        print(bildung(), "Bildungsweg");
        print(studium(), "Studium");
        print(auslandsaufenthalte(), "Auslandsaufenthalte");
        print(engagementFreizeit(), "Engagement und Freizeit");
        print(qualifikationen(), "Qualifikationen");
        menu();
    }

    /**
     * diese Methode erstellt das Lebenslauf_Nicolas_Mahn.txt
     */
    public static void makeTxt() {
        File file = new File("Lebenslauf_Nicolas_Mahn.txt");
        FileOutputStream fos = null;
        try {fos = new FileOutputStream(file);} catch (FileNotFoundException e) {e.printStackTrace();}
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        makeLebenslauf();
        ps.close();
        try {fos.close();} catch (IOException e) {e.printStackTrace();}
    }

    /**
     * Diese Methode schreibt die Ueberschrift
     */
    public static void ueberschrift() {
        System.out.println(" # Lebenslauf");
        hr();
        System.out.print(newLine("\nDieser Lebenslauf wurde Ihnen bereitgestellt von: " +
                "https://github.com/NicolasMahn/Lebenslauf", 0));
    }

    /**
     * Diese Methode schreibt eine Linie Aenlich wie man hr aus html kennt
     */
    public static void hr() {
        for (int i = 0; i < MAXLINELENGTH; i++) System.out.print('-');
    }

    /**
     * In dieser Methode werden die Datenpunkte des Lebenslaufs geschrieben
     * @param obj Das Objekt, welches die Daten beinhaltet
     * @param ueberschrift Ist die unterüberschrift
     */
    public static void print(Object obj, String ueberschrift) {
        System.out.println();
        hr();
        System.out.println("\n ## " + ueberschrift + "\n");

        String klasse = obj.getClass().toString();
        if (!klasse.contains("Tuple")) System.out.println(obj + "\n");
        else {
            int num;
            if (Character.isDigit(klasse.charAt(klasse.length() - 2)))
                num = Integer.parseInt(klasse.substring(klasse.length() - 2)) * 10;
            else num = Integer.parseInt(klasse.substring(klasse.length() - 1));
            printTuple((Tuple) obj, num);
        }
    }

    /**
     * Diese Methode schreibt alle Objekte die in einem Tuple gespeichert sind
     * @param tuple des Tuple Objekt, welches ausgedruckt werden soll
     * @param num gibt die groesse des Tuples an
     */
    public static void printTuple(Tuple tuple, int num) {
        System.out.println(tuple.getFirst());
        System.out.println(tuple.getSecond());
        System.out.println(tuple.getThird());
        if (num > 3) {
            System.out.println(tuple.getFourth());
        } if (num > 4) {
            System.out.println(tuple.getFifth());
            System.out.println(tuple.getSixth());
            System.out.println(tuple.getSeventh());
            System.out.println(tuple.getEighth());
            System.out.println(tuple.getNinth());
        } if (num > 9) {
            System.out.println(tuple.getTenth());
            System.out.println(tuple.getEleventh());
            System.out.println(tuple.getTwelfth());
            System.out.println(tuple.getThirteenth());
            System.out.println(tuple.getFourteenth());
            System.out.println(tuple.getFifteenth());
            System.out.println(tuple.getSixteenth());
            System.out.println(tuple.getSeventeenth());
            System.out.println(tuple.getEighteenth());
            System.out.println(tuple.getNineteenth());
            System.out.println(tuple.getTwentieth());
        }
    }

    /**
     * Diese Methode macht aus einer HashMap einen String
     * @param hm ist die zu Übergebende HashMap
     * @param <K> K ist das key Objekt der HashMap
     * @param <V> V ist dsa Value Objekt der HashMap
     * @return wird ein String, der die HashMap beschreibt
     */
    @SuppressWarnings("SuspiciousMethodCalls")
    public static <K, V> String hashMapToString(HashMap<K,V> hm) {
        Iterator<K> it = hm.keySet().iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()) {
            Object key = it.next();
            s.append(key).append(": ").append(hm.get(key)).append("\n");
        }
        return s.substring(0,s.length()-1);
    }

    /**
     * Diese Methode fügt ein Enter in einen zu langen String hinzu und handelt dabei auch das tabbing.
     * Dabei wird erst ein Enter hinzugefügt wenn der String die oben angegebene MAXLINELENGTH überschreitet.
     * Wenn moeglich bei einem Leerzeichen, sonst wird ein Wort geteilt.
     * @param s Der String welcher in lines getrennt werden soll
     * @param space Der Platz vor dem String s
     * @param nlSpace Der Tab in der nächsten Zeile
     * @return wird der String mit Enters und Tabs
     */
    public static String newLine(String s, int space, int nlSpace) {
        String s1 = s;
        String s2 = "";
        if (s.length()+space > MAXLINELENGTH){
            int lastSpace = 420;
            for(int i = 0; i<s.length() && i< MAXLINELENGTH -space; i++ ) if(s.charAt(i) == ' ') lastSpace = i;
            if (lastSpace != 420) {
                s1 = s.substring(0, lastSpace) + "\n";
                s2 = getSpace(nlSpace) + s.substring(lastSpace+1);
            }
            else {
                s1 = s.substring(0, MAXLINELENGTH - 1 - space) + "-\n";
                s2 = getSpace(nlSpace) + s.substring(MAXLINELENGTH - space);
            }
        }
        if (s2.length() > MAXLINELENGTH) s2 = newLine(s2, nlSpace, nlSpace);
        return (s1 + s2);
    }

    public static String newLine(String s, int space) {return newLine(s,space,space);}

    /**
     * Diese Methode erstellt aus einer int ein String mit Leerzeichen, in der Laenge des ints.
     * @param len gibt die endgueltige laenge des Strings an
     * @return gibt den String in der laenge des ints zurueck
     */
    public static String getSpace(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }

    /**
     * Diese Methode handelt auch tabbing, diese fuegt zu Enters allerdings 'nur' ein tab hinzu
     * @param s beschreibt den String der getabbt werden soll
     * @param len beschreibt die laenge des Strings
     * @return wird der String s mit tabs
     */
    public static String addSpace(String s, int len) {
        String space = getSpace(len);
        return s.replace("\n", "\n"+space);
    }

    /**
     * Diese Methode gibt dem User 2 Optionen:
     * A) Die Applikation zu schließen
     * B) ein .txt aus der Consolen Ausgabe zu erstellen
     */
    public static void menu() {
        if (open) {
            System.out.println("\n\nDr\u00FCcke 'x' um dieses Fenster zu schlie\u00DFen");
            System.out.println("Dr\u00FCcke 'p' um diesen Lebenslauf in eine .txt zu drucken");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(open) {
            String s = "";
            try {
                s = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s.charAt(0) == 'x') open = false;
            else if (s.charAt(0) == 'p') {
                System.out.println("Der Lebenslauf ist unter 'Lebenslauf_Nicolas_Mahn.txt' zu finden");
                System.out.println("Dieses Fenster schlie\u00DFt sich dabei...");
                try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
                open = false;
                makeTxt();
            }
        }
    }
}

/**
 * Diese Klasse ist die Vaterklasse aller spezifischen Tuple also tuple mit einer definierten Laenge
 */
class Tuple {
    public Object getFirst(){return null;}
    public Object getSecond(){return null;}
    public Object getThird(){return null;}
    public Object getFourth(){return null;}
    public Object getFifth(){return null;}
    public Object getSixth(){return null;}
    public Object getSeventh(){return null;}
    public Object getEighth(){return null;}
    public Object getNinth(){return null;}
    public Object getTenth(){return null;}
    public Object getEleventh(){return null;}
    public Object getTwelfth(){return null;}
    public Object getThirteenth(){return null;}
    public Object getFourteenth(){return null;}
    public Object getFifteenth(){return null;}
    public Object getSixteenth(){return null;}
    public Object getSeventeenth(){return null;}
    public Object getEighteenth(){return null;}
    public Object getNineteenth(){return null;}
    public Object getTwentieth(){return null;}
}

/**
 * Diese Klasse kann 3 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
class Tuple3<A, B, C>  extends  Tuple {
    public A first; public B second; public C third;

    public Tuple3(A first, B second, C third){
        this.first = first; this.second = second; this.third = third;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
}

/**
 * Diese Klasse kann 4 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
class Tuple4<A, B, C, D>  extends  Tuple  {
    public A first; public B second; public C third; public D fourth;

    public Tuple4(A first, B second, C third, D fourth){
        this.first = first; this.second = second; this.third = third; this.fourth = fourth;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
}

/**
 * Diese Klasse kann 9 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
class Tuple9<A, B, C, D, E, F, G, H, I>  extends  Tuple  {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    public H eighth; public I ninth;

    public Tuple9(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh; this.eighth = eighth; this.ninth = ninth;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
    public E getFifth() {return fifth;}
    public F getSixth() {return sixth;}
    public G getSeventh() {return seventh;}
    public H getEighth() {return eighth;}
    public I getNinth() {return ninth;}
}

/**
 * Diese Klasse kann 20 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
class Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>  extends  Tuple  {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    public H eighth; public I ninth; public J tenth; public K eleventh; public L twelfth; public M thirteenth;
    public N fourteenth; public O fifteenth; public P sixteenth; public Q seventeenth; public R eighteenth;
    public S nineteenth; public T twentieth;

    public Tuple20(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth,
                   K eleventh, L twelfth, M thirteenth, N fourteenth, O fifteenth, P sixteenth, Q seventeenth,
                   R eighteenth, S nineteenth, T twentieth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh; this.eighth = eighth; this.ninth = ninth; this.tenth = tenth;
        this.eleventh = eleventh; this.twelfth = twelfth; this.thirteenth = thirteenth; this.fourteenth = fourteenth;
        this.fifteenth = fifteenth; this.sixteenth = sixteenth; this.seventeenth = seventeenth;
        this.eighteenth = eighteenth; this.nineteenth = nineteenth; this.twentieth = twentieth;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
    public E getFifth() {return fifth;}
    public F getSixth() {return sixth;}
    public G getSeventh() {return seventh;}
    public H getEighth() {return eighth;}
    public I getNinth() {return ninth;}
    public J getTenth() {return tenth;}
    public K getEleventh() {return eleventh;}
    public L getTwelfth() {return twelfth;}
    public M getThirteenth() {return thirteenth;}
    public N getFourteenth() {return fourteenth;}
    public O getFifteenth() {return fifteenth;}
    public P getSixteenth() {return sixteenth;}
    public Q getSeventeenth() {return seventeenth;}
    public R getEighteenth() {return eighteenth;}
    public S getNineteenth() {return nineteenth;}
    public T getTwentieth() {return twentieth;}
}



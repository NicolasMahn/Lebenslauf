import tuple.*;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author NicolasMahn
 * Diese Klasse beschreibt meinen Lebenslauf.
 */
public class Lebenslauf {
    static boolean open = true;

    /**
     * Diese Methode speichert meine persoenlichen Daten in einer HashMap.
     * @return wird die HashMap mit den pers. Daten
     */
    public static String persoenlicheDaten() {
        HashMap<String, String> persInfo = new HashMap<String, String>(){{
            put("Name", "Nicolas Mahn");
            put("Adresse", "Untere Brandstra\u00DFe 62, 70567 Stuttgart");
            put("E-Mail", "Nicolas.Mahn@gmx.de");
            put("Tel.", "015206501315");
            put("Geboren", "2000-08-07 in Stuttgart");}};
        return Utils.hashMapToString(persInfo);
    }

    /**
     * Diese Methode erstellt Bildungsobjekte aus meinen bisherigen Taetigkeiten.
     * @return wird ein tuple.Tuple mit allen 4 Bildungsobjekten
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
     * Diese Methode speichert meine Auslandsaufenthalte in einem Objekten ab
     * @return wird ein tuple.Tuple mit 3 Objekten
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
     * @return werden die Strings als tuple.Tuple
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
     * Diese Methode speichert meine Qualifikationen in einem Objekten ab
     * @return wird ein tuple.Tuple mit 4 Objekten
     */
    public static Tuple20<Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation,
                Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation,
                Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation, Qualifikation>
    qualifikationen() {
        Qualifikation eng = new Qualifikation(Qualifikation.Ueberthema.Fremdsprachen,
                "Englisch",1);
        Qualifikation fr = new Qualifikation(Qualifikation.Ueberthema.Fremdsprachen,
                "Franz\u00F6sisch",2);

        Qualifikation java = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "Java", 1);
        Qualifikation x86 = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "x86 Assembler", 1);
        Qualifikation py = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "Python",  1);
        Qualifikation sql = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "SQL", 2);
        Qualifikation noSql = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "NoSQL", 2);
        Qualifikation wd = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "Webdesign", 2);
        Qualifikation gql = new Qualifikation(Qualifikation.Ueberthema.Programmiersprachen,
                "GraphQL", 3);

        Qualifikation uml = new Qualifikation(Qualifikation.Ueberthema.Modellierungssprachen,
                "UML", 2);
        Qualifikation bpmn = new Qualifikation(Qualifikation.Ueberthema.Modellierungssprachen,
                "BPMN", 3);
        Qualifikation fc = new Qualifikation(Qualifikation.Ueberthema.Modellierungssprachen,
                "Flowchart", 3);
        Qualifikation epk = new Qualifikation(Qualifikation.Ueberthema.Modellierungssprachen,
                "EPK", 3);

        Qualifikation mw = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "Microsoft Word");
        Qualifikation ltx = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "LaTeX");
        Qualifikation mpp = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "Microsoft Power Point");
        Qualifikation me = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "Microsoft Excel");
        Qualifikation mt = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "Microsoft Teams");
        Qualifikation zoom = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "Zoom");
        Qualifikation sap = new Qualifikation(Qualifikation.Ueberthema.sonstige_Qualifikationen,
                "SAP");

        return new Tuple20<>(eng, fr, java, x86, py, sql, noSql, wd, gql,uml, bpmn,
                fc, epk, mw, ltx, mpp, me, mt, zoom, sap);
    }

    /**
     * Die main Methode der Klasse
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
        Utils.hr();
        System.out.print(Utils.newLine("\nDieser Lebenslauf wurde Ihnen bereitgestellt von: " +
                "https://github.com/NicolasMahn/Lebenslauf", 0));
    }

    /**
     * In dieser Methode werden die Datenpunkte des Lebenslaufs geschrieben
     * @param obj Das Objekt, welches die Daten beinhaltet
     * @param ueberschrift Ist die unterüberschrift
     */
    public static void print(Object obj, String ueberschrift) {
        System.out.println();
        Utils.hr();
        System.out.println("\n ## " + ueberschrift + "\n");

        String klasse = obj.getClass().toString();
        if (!klasse.contains("tuple.Tuple")) System.out.println(obj + "\n");
        else {
            int num;
            if (Character.isDigit(klasse.charAt(klasse.length() - 2)))
                num = Integer.parseInt(klasse.substring(klasse.length() - 2)) * 10;
            else num = Integer.parseInt(klasse.substring(klasse.length() - 1));
            printTuple((Tuple) obj, num);
        }
    }

    /**
     * Diese Methode schreibt alle Objekte die in einem tuple.Tuple gespeichert sind
     * @param tuple des tuple.Tuple Objekt, welches ausgedruckt werden soll
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
                System.out.println("Dieses Fenster schlie\u00DFt sich jetzt...");
                try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
                open = false;
                makeTxt();
            }
        }
    }
}
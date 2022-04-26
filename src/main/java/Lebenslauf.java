
import objects.*;
import tuple.*;
import utils.*;

import java.util.HashMap;

/**
 * @author NicolasMahn
 * Diese Klasse beschreibt meinen Lebenslauf.
 */
public class Lebenslauf {
    static Languages DE = Languages.de;


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
            put("Geboren", "07.08.2000 in Stuttgart");}};
        return Utils.hashMapToString(persInfo);
    }

    /**
     * Diese Methode erstellt Bildungsobjekte aus meinen bisherigen Taetigkeiten.
     * @return wird ein Tuple mit allen 4 Bildungsobjekten
     */
    public static Tuple4<EducationalPath, EducationalPath, EducationalPath, EducationalPath> bildung() {
        EducationalPath studium = new EducationalPath("09.2019", null,
                "Wirtschaftsinformatik Studium",
                "voraussichtlich Bachelor of Science im Jahr 2023",
                "Hochschule Furtwangen (HFU)",
                "Furtwangen im Schwarzwald",
                "besondere Interessen: Machine Learning, Data Science und Software-Entwicklung", DE);

        EducationalPath werkStudent = new EducationalPath("01.11.2021", "31.03.2022",
                "Werkstudent",
                null,
                "DB Systel",
                null,
                null, DE);

        EducationalPath praktikum = new EducationalPath("01.04.2021", "30.09.2021",
                "Praktikum",
                null,
                "DB Netz AG",
                null,
                "im Konzernprogramm Digitale Schiene Deutschland.", DE);

        EducationalPath schule = new EducationalPath(null, "2018",
                "Gymnasium",
                "Abitur",
                "am K\u00F6nigin-Charlotte-Gymnasium",
                "Stuttgart",
                "bilingualer Zug", DE);

        return new Tuple4<>(studium, werkStudent, praktikum, schule);
    }

    /**
     * Diese Methode speichert meine Erfahrungen in das entsprechende Objekt
     * @return Tuple mit allen Erfahrungsobjekten
     */
    public static Tuple9<Experience, Experience, Experience, Experience, Experience,
                Experience, Experience, Experience, Experience> studium() {

        Experience cph = new Experience(2, "Wissenschaftliche Arbeit",
                "Cyber Physical Hacks", DE);
        Experience pa = new Experience(2, "Hausarbeit",
                "Make-or-Buy-Prozess-Analyse mit Gesch\u00E4ftsprozess-design-Sprachen", DE);
        Experience as = new Experience(2, "Hausarbeit",
                "Assembler und Systemarchitektur", DE);
        Experience ear = new Experience(3, "Projekt",
                "Entwicklung eines Algorithmus zur Routenfindung von E-LKWs in Java " +
                        "(Anwendungsschicht), MongoDB (Datenhaltungsschicht) und PHP/JS " +
                        "(Pr\u00E4sentationsschicht)", DE);
        Experience bi1 = new Experience(5, "Projekt",
                "Business Intelligence 1: Big Data Analitics Projekt mit Spark",
                "https://github.com/1Zero64/BusinessIntelligence", DE);
        Experience bi2 = new Experience(5, "Projekt",
                "Business Intelligence 2: Machine Learning Projekt mit R",
                "https://github.com/NicolasMahn/BusinessIntelligence2", DE);
        Experience defi = new Experience(5, "Wissenschaftliche Arbeit",
                "decentralized Finance (DeFi)", DE);
        Experience ipm = new Experience(5, "Projekt",
                "Entwicklung eines Intelligenten Packetmanagement-System in Python, " +
                        "anhand eines TSP Algorithmus",
                "https://github.com/NicolasMahn/IntPakman", DE);
        Experience ma = new Experience(1, "Marktanalyse",
                "die Stadtkartenbranche wurde f\u00FCr ein Unternehmen durchgef\u00FChrt, " +
                        "am Institut f\u00FCr Business Consulting (IBC) eine studentische Unternehmensberatung", DE);

        return new Tuple9<>(cph, pa, as, ear, bi1, bi2, defi, ipm, ma);
    }

    /**
     * Diese Methode speichert meine Auslandsaufenthalte in einem Objekten ab
     * @return wird ein Tuple mit 3 Objekten
     */
    public static Tuple3<StaysAbroad, StaysAbroad, StaysAbroad> auslandsaufenthalte() {
        StaysAbroad nordirland = new StaysAbroad
                ("03.2009", "07.2009", "Nordirland", "In Sion Mills",
                        "Besuch der Sion Mills Primary School", DE);

        StaysAbroad frankreich = new StaysAbroad
                ("03.2013", "07.2013", "Frankreich","In Lyon",
                        "Besuch des Coll\u00E8ge Charles de Foucault", DE);

        StaysAbroad uganda = new StaysAbroad
                ("08.2018", "08.2019", "Uganda", "In Kampala",
                        "Aushilfslehrer f\u00FCr Mathematik und Science " +
                                "an der Kawempe Youth Development Association " +
                                "Primary School und der Makarere West Valley Primary School", DE);

        return new Tuple3<>(nordirland, frankreich, uganda);
    }

    /**
     * Diese Methode speichert meine Freizeitaktivitaeten in Strings ab
     * @return werden die Strings als uple
     */
    public static Tuple3<String, String, String> engagementFreizeit() {
        String pfadfinder = "Deutsche Pfadfinderschaft Sankt Georg \n" +
                            "01.2017 - 07.2018 Jugendleiter \n" +
                            "Teilnahme an Hilfsprojekten auf den Philippinen und in Pal\u00E4stina\n";

        String fachschaft = "seit anfang 2020 Mitglied der Fachschaft Wirtschaftsinformatik " +
                            "\nder Hochschule Furtwangen\n";

        String hobbys = "Sport (Fitnesstraining, Joggen)\n" +
                        "Computerspiele (Minecraft, AOE)\n";

        return new Tuple3<>(pfadfinder, fachschaft, hobbys);
    }

    /**
     * Diese Methode speichert meine Qualifikationen in einem Objekten ab
     * @return wird ein Tuple mit 4 Objekten
     */
    public static Tuple20<Qualification, Qualification, Qualification, Qualification, Qualification, Qualification,
                Qualification, Qualification, Qualification, Qualification, Qualification, Qualification, Qualification,
                Qualification, Qualification, Qualification, Qualification, Qualification, Qualification, Qualification>
    qualifikationen() {
        Qualification eng = new Qualification(Qualification.MainTopic.fl,"Englisch",1, DE);
        Qualification fr = new Qualification(Qualification.MainTopic.fl,"Franz\u00F6sisch",2, DE);

        Qualification java = new Qualification(Qualification.MainTopic.pl,"Java", 1, DE);
        Qualification x86 = new Qualification(Qualification.MainTopic.pl,"x86 Assembler", 1, DE);
        Qualification py = new Qualification(Qualification.MainTopic.pl,"Python",  1, DE);
        Qualification sql = new Qualification(Qualification.MainTopic.pl,"SQL", 2, DE);
        Qualification noSql = new Qualification(Qualification.MainTopic.pl,"NoSQL", 2, DE);
        Qualification wd = new Qualification(Qualification.MainTopic.pl,"Webdesign", 2, DE);
        Qualification gql = new Qualification(Qualification.MainTopic.pl,"GraphQL", 3, DE);

        Qualification uml = new Qualification(Qualification.MainTopic.ml,"UML", 2, DE);
        Qualification bpmn = new Qualification(Qualification.MainTopic.ml,"BPMN", 3, DE);
        Qualification fc = new Qualification(Qualification.MainTopic.ml,"Flowchart", 3, DE);
        Qualification epk = new Qualification(Qualification.MainTopic.ml,"EPK", 3, DE);

        Qualification mw = new Qualification(Qualification.MainTopic.oq,"Microsoft Word", DE);
        Qualification ltx = new Qualification(Qualification.MainTopic.oq,"LaTeX", DE);
        Qualification mpp = new Qualification(Qualification.MainTopic.oq,"Microsoft Power Point", DE);
        Qualification me = new Qualification(Qualification.MainTopic.oq,"Microsoft Excel", DE);
        Qualification mt = new Qualification(Qualification.MainTopic.oq,"Microsoft Teams", DE);
        Qualification zoom = new Qualification(Qualification.MainTopic.oq,"Zoom", DE);
        Qualification sap = new Qualification(Qualification.MainTopic.oq,"SAP", DE);

        return new Tuple20<>(eng, fr, java, x86, py, sql, noSql, wd, gql,uml, bpmn,
                fc, epk, mw, ltx, mpp, me, mt, zoom, sap);
    }


}
import objects.*;
import tuple.*;
import utils.*;

import java.util.HashMap;

/**
 * @author NicolasMahn
 * This class describes my CV.
 */
public class CV {
static Languages EN = Languages.en;

    /**
     * This method stores my personal data in a HashMap.
     * @return The HashMap with my personal data is being returned
     */
    public static String persoalData() {
        HashMap<String, String> persInfo = new HashMap<String, String>(){{
            put("Name", "Nicolas Mahn");
            put("Address", "Untere Brandstra\u00DFe 62, 70567 Stuttgart, Germany");
            put("E-Mail", "Nicolas.Mahn@gmx.de");
            put("Tel.", "015206501315");
            put("Born", "2000-08-07 in Stuttgart");}};
        return Utils.hashMapToString(persInfo);
    }

    /**
     * This method creates EducationalPath objects from my previous activities.
     * @return A tuple of al my activities is returned
     */
    public static Tuple4<EducationalPath, EducationalPath, EducationalPath, EducationalPath> education() {
        EducationalPath studies = new EducationalPath("09.2019", null,
                "Business Informatics",
                "prospectively Bachelor of Science in the year 2023",
                "Hochschule Furtwangen (HFU)",
                "Furtwangen im Schwarzwald",
                "special Interests: Machine Learning, Data Science and Software-Development", EN);

        EducationalPath workStudent = new EducationalPath("01.11.2021", "31.03.2022",
                "Workstudent",
                null,
                "DB Systel",
                null,
                null, EN);

        EducationalPath internship = new EducationalPath("01.04.2021", "30.09.2021",
                "Internship",
                null,
                "DB Netz AG",
                null,
                "in the department Digital Rail Germany.", EN);

        EducationalPath school = new EducationalPath(null, "2018",
                "High School",
                "Abitur",
                "at the K\u00F6nigin-Charlotte-Gymnasium",
                "Stuttgart",
                "bilingual path", EN);

        return new Tuple4<>(studies, workStudent, internship, school);
    }

    /**
     * This method stores my experiences in the corresponding object
     * @return Tuple of all experience objects
     */
    public static Tuple9<Experience, Experience, Experience, Experience, Experience,
            Experience, Experience, Experience, Experience> studies() {

        Experience cph = new Experience(2, "assignment",
                "Cyber Physical Hacks", EN);
        Experience pa = new Experience(2, "assignment",
                "Make-or-Buy process analysis with business process design languages", EN);
        Experience as = new Experience(2, "assignment",
                "Assembler and system architecture", EN);
        Experience ear = new Experience(3, "project",
                "Development of an algorithm for route finding of e-trucks in Java (application layer), " +
                        "MongoDB (data management layer) and PHP/JS (presentation layer)", EN);
        Experience bi1 = new Experience(5, "project",
                "Business Intelligence 1: Big data analytics project with Spark",
                "https://github.com/1Zero64/BusinessIntelligence", EN);
        Experience bi2 = new Experience(5, "project",
                "Business Intelligence 2: Machine learning project with R",
                "https://github.com/NicolasMahn/BusinessIntelligence2", EN);
        Experience defi = new Experience(5, "assignment",
                "decentralized Finance (DeFi)", EN);
        Experience ipm = new Experience(5, "project",
                "Development of an intelligent packet management system in Python, using a TSP algorithm",
                "https://github.com/NicolasMahn/IntPakman", EN);
        Experience ma = new Experience(1, "market analysis",
                "the city map branch was carried out for a company, " +
                        "at the Institute for Business Consulting (IBC) a student management consultancy", EN);

        return new Tuple9<>(cph, pa, as, ear, bi1, bi2, defi, ipm, ma);
    }

    /**
     * This method saves my StaysAbroad in an object
     * @return returns a tuple wit 3 'StaysAbroad'
     */
    public static Tuple3<StaysAbroad, StaysAbroad, StaysAbroad> staysAbroad() {
        StaysAbroad northernIreland = new StaysAbroad
                ("03.2009", "07.2009", "Northern Ireland", "In Sion Mills",
                        "Attended Sion Mills Primary School", EN);

        StaysAbroad france = new StaysAbroad
                ("03.2013", "07.2013", "France","In Lyon",
                        "Attended Coll\u00E8ge Charles de Foucault", EN);

        StaysAbroad uganda = new StaysAbroad
                ("08.2018", "08.2019", "Uganda", "In Kampala",
                        "Substitute math and science teacher at Kawempe Youth Development " +
                                "Association Primary School and Makarere West Valley Primary School", EN);

        return new Tuple3<>(northernIreland, france, uganda);
    }

    /**
     * This method stores my freetime activities in strings
     * @return returns the Strings in a tuple
     */
    public static Tuple3<String, String, String> commitmentlLeisure() {
        String boyScouts = "German Scout Association Sankt Georg \n" +
                "01.2017 - 07.2018 youth leader \n" +
                "Participation in aid projects in the Philippines and Palestine\n";

        String studentCouncil = "since the beginning of 2020 member of the business informatics student council " +
                "\nof the HFU\n";

        String leisureActivities = "Sport (fitness training, jogging)\n" +
                "Computer Games (Minecraft, AOE)\n";

        return new Tuple3<>(boyScouts, studentCouncil, leisureActivities);
    }

    /**
     * This method stores my qualifications in an object
     * @return returns a tuple with 4 objects
     */
    public static Tuple20<Qualification, Qualification, Qualification, Qualification, Qualification, Qualification,
            Qualification, Qualification, Qualification, Qualification, Qualification, Qualification, Qualification,
            Qualification, Qualification, Qualification, Qualification, Qualification, Qualification, Qualification>
    qualifications() {
        Qualification eng = new Qualification(Qualification.MainTopic.fl,"English",1, EN);
        Qualification fr = new Qualification(Qualification.MainTopic.fl,"French",2, EN);

        Qualification java = new Qualification(Qualification.MainTopic.pl,"Java", 1, EN);
        Qualification x86 = new Qualification(Qualification.MainTopic.pl,"x86 Assembler", 1, EN);
        Qualification py = new Qualification(Qualification.MainTopic.pl,"Python",  1, EN);
        Qualification sql = new Qualification(Qualification.MainTopic.pl,"SQL", 2, EN);
        Qualification noSql = new Qualification(Qualification.MainTopic.pl,"NoSQL", EN);
        Qualification wd = new Qualification(Qualification.MainTopic.pl,"Web Design", 2, EN);
        Qualification gql = new Qualification(Qualification.MainTopic.pl,"GraphQL", 3, EN);

        Qualification uml = new Qualification(Qualification.MainTopic.ml,"UML", 2, EN);
        Qualification bpmn = new Qualification(Qualification.MainTopic.ml,"BPMN", 3, EN);
        Qualification fc = new Qualification(Qualification.MainTopic.ml,"Flowchart", 3, EN);
        Qualification epk = new Qualification(Qualification.MainTopic.ml,"EPK", 3, EN);

        Qualification mw = new Qualification(Qualification.MainTopic.oq,"Microsoft Word", EN);
        Qualification ltx = new Qualification(Qualification.MainTopic.oq,"LaTeX", EN);
        Qualification mpp = new Qualification(Qualification.MainTopic.oq,"Microsoft Power Point", EN);
        Qualification me = new Qualification(Qualification.MainTopic.oq,"Microsoft Excel", EN);
        Qualification mt = new Qualification(Qualification.MainTopic.oq,"Microsoft Teams", EN);
        Qualification zoom = new Qualification(Qualification.MainTopic.oq,"Zoom", EN);
        Qualification sap = new Qualification(Qualification.MainTopic.oq,"SAP", EN);

        return new Tuple20<>(eng, fr, java, x86, py, sql, noSql, wd, gql,uml, bpmn,
                fc, epk, mw, ltx, mpp, me, mt, zoom, sap);
    }


}
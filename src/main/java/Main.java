import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfLinkAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Link;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.kernel.pdf.action.PdfAction;
import tuple.Tuple;
import utils.Languages;
import utils.Utils;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * This method executes the code
 */
public class Main {
    static boolean open = true;
    static Languages lang = null;

    /**
     * The main Method of the class
     */
    public static void main(String[] args) {
        whatLanguage();
        if (lang == Languages.de)  makeLebenslauf();
        else  makeCV();
    }

    /**
     * In this methode the User can specify in what language he'd like the CV to be
     */
    public static void whatLanguage() {
        if (open) {
            System.out.println("\n\nIn what language would you like the CV?");
            System.out.println("In welcher Sprache h\u00E4tten Sie den Lebenslauf gerne?");
            System.out.println("\nIn german or english (de/EN)?");
            System.out.println("Auf Deutsch oder Englisch (de/EN)?");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "  ";
        try {
            s = in.readLine();
        } catch (IOException e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }

        if (s.toLowerCase().charAt(0) == 'd') lang = Languages.de;
        else lang = Languages.en;
    }

    /**
     * In dieser Methode werden die Funktionen der Lebenslaufklasse aufgerufen
     */
    public static void makeLebenslauf() {
        ueberschrift();
        print(Lebenslauf.persoenlicheDaten(), "pers\u00F6nliche Daten");
        print(Lebenslauf.bildung(), "Bildungsweg");
        print(Lebenslauf.studium(), "Studium");
        print(Lebenslauf.auslandsaufenthalte(), "Auslandsaufenthalte");
        print(Lebenslauf.engagementFreizeit(), "Engagement und Freizeit");
        print(Lebenslauf.qualifikationen(), "Qualifikationen");
        menu();
    }

    /**
     * This methode calls all the functions in te CV class
     */
    public static void makeCV() {
        headline();
        print(CV.persoalData(), "Personal Information");
        print(CV.education(), "Educational Path");
        print(CV.studies(), "Studies");
        print(CV.staysAbroad(), "Stays Abroad");
        print(CV.commitmentlLeisure(), "Commitments and Leisure Activities");
        print(CV.qualifications(), "Qualifications");
        menu();
    }

    /**
     * Diese Methode schreibt die Ueberschrift
     */
    public static void ueberschrift() {
        System.out.println("# Lebenslauf");
        Utils.hr();
        System.out.print(Utils.newLine("\nDieser Lebenslauf wurde Ihnen bereitgestellt von: " +
                "https://github.com/NicolasMahn/Lebenslauf", 0));
    }

    /**
     * This methode writes the headline
     */
    public static void headline() {
        System.out.println("# CV");
        Utils.hr();
        System.out.print(Utils.newLine("\nThis CV was provided by: " +
                "https://github.com/NicolasMahn/Lebenslauf", 0));
    }

    /**
     * This methode creates a .txt CV or Lebenslauf
     */
    public static void makeTxt(String fileName) {
        try {
            PrintStream ps_console = System.out;
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);

            if (lang == Languages.de) makeLebenslauf();
            else makeCV();

            ps.close();
            fos.close();
            System.setOut(ps_console);

            if (lang == Languages.de) {
                System.out.println("Der Lebenslauf wurde erstellt.");
                System.out.println("Er ist unter 'Lebenslauf_Nicolas_Mahn.txt' zu finden");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nDieses Fenster schlie\u00DFt sich jetzt...");

            } else {
                System.out.println("The CV has been created");
                System.out.println("It can be found under 'CV_Nicolas_Mahn.txt'");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nThis window will now close itself...");
            }
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException | IOException e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }
    }

    /**
     * This methode creates a .pdf CV or Lebenslauf
     */
    public static void makePdf(String fileName) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream ps_console = System.out;
            System.setOut(ps);

            if (lang == Languages.de) makeLebenslauf();
            else makeCV();

            System.out.flush();
            System.setOut(ps_console);
            ps.close();

            String cv = baos.toString();

            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            if (lang == Languages.de) pdf.setDefaultPageSize(new PageSize(595f, 1860f));
            else pdf.setDefaultPageSize(new PageSize(595f, 1830f));
            Document doc = new Document(pdf);
            PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER);

            for (String line : cv.split("\\n")) {
                if (line.contains("https://")) {
                    String[] arr = line.split("https://");
                    String beforeLink = arr[0];
                    String tempSLink = "https://";
                    String tempBehindLink = "";
                    if (arr[1].contains(" ")) { //Links are not allowed to have spaces
                        tempSLink += arr[1].substring(0, arr[1].charAt(' '));
                        tempBehindLink = arr[1].substring(arr[1].charAt(' '));
                    } else tempSLink += arr[1];
                    String sLink = tempSLink;
                    String behindLink = tempBehindLink;
                    Link link = new Link(sLink, new PdfLinkAnnotation(new Rectangle(0, 0)) {{
                        setAction(PdfAction.createURI(sLink));
                    }}){{
                        setFont(font);
                        setFontSize(10.8f);
                    }};
                    doc.add(new Paragraph() {{
                        add(new Text("\u00AD" + beforeLink) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        add(link.setUnderline() );
                        add(new Text(behindLink) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        setMultipliedLeading(0.0f);
                    }});
                } else {
                    doc.add(new Paragraph() {{
                        add(new Text("\u00AD" + line) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        setMultipliedLeading(0.0f);
                    }});
                }
            }
            doc.close();

            if (lang == Languages.de) {
                System.out.println("Der Lebenslauf wurde erstellt.");
                System.out.println("Er ist unter 'Lebenslauf_Nicolas_Mahn.pdf' zu finden");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nDieses Fenster schlie\u00DFt sich jetzt...");

            } else {
                System.out.println("The CV has been created");
                System.out.println("It can be found under 'CV_Nicolas_Mahn.pdf'");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nThis window will now close itself...");
            }
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }
    }

    /**
     * This Method prints the CV
     * @param obj The object which vontains data
     * @param headline the headline of the data
     */
    public static void print(Object obj, String headline) {
        System.out.println();
        Utils.hr();
        System.out.println("\n## " + headline + "\n");

        String cl = obj.getClass().toString();
        if (!cl.contains("Tuple")) System.out.println(obj + "\n");
        else {
            int num;
            if (Character.isDigit(cl.charAt(cl.length() - 2)))
                num = Integer.parseInt(cl.substring(cl.length() - 2)) * 10;
            else num = Integer.parseInt(cl.substring(cl.length() - 1));
            printTuple((Tuple) obj, num);
        }
    }

    /**
     * This method writes all objects stored in a tuple
     * @param tuple the tuple object contains the objects in which data is stored
     * @param num defines the size of the tuple
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
     * This methode offers the User with two options:
     * A) to close this application
     * B) To create a .txt CV
     */
    public static void menu() {
        if (open) {
            if (lang == Languages.de) {
                System.out.println("\n\nDr\u00FCcke 'x' um dieses Fenster zu schlie\u00DFen");
                System.out.println("Dr\u00FCcke 'p' um diesen Lebenslauf in eine pdf Datei zu drucken");
            } else {
                System.out.println("\n\nPress 'x' to close this window");
                System.out.println("Press 'p' to print the CV into a pdf file ");
            }
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(open) {
            String s = "  ";
            try {
                s = in.readLine();
            } catch (IOException e) {
                System.err.println("Oh, something went wrong....");
                e.printStackTrace();
            }
            if (s.toLowerCase().charAt(0) == 'x') open = false;
            else if (s.toLowerCase().charAt(0) == 'p') {
                open = false;
                if (lang == Languages.de) makePdf("Lebenslauf_Nicolas_Mahn.pdf");
                else makePdf("CV_Nicolas_Mahn.pdf");
            }
            else if (s.toLowerCase().charAt(0) == 't') {
                open = false;
                if (lang == Languages.de) makeTxt("Lebenslauf_Nicolas_Mahn.txt");
                else makeTxt("CV_Nicolas_Mahn.txt");
            }
        }
    }
}

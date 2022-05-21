import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.io.font.constants.StandardFonts;
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
import utils.Json;
import utils.Language;
import static utils.Utils.*;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This method executes the code
 */
public class Main {
    static Language lang = null;
    static Tuple cv = null;

    /**
     * The main Method of the class
     */
    public static void main(String[] args) {

        whatLanguage();
        if (lang == Language.de) cv = Json.readCV("Lebenslauf.json");
        else  cv = Json.readCV("CV.json");
        System.out.println(cv);
        menu();
    }

    /**
     * In this methode the User can specify in what language he'd like the CV to be
     */
    public static void whatLanguage() {

        System.out.println("\n\nIn what language would you like the CV?");
        System.out.println("In welcher Sprache h\u00E4tten Sie den Lebenslauf gerne?");
        System.out.println("\nIn german or english (de/EN)?");
        System.out.println("Auf Deutsch oder Englisch (de/EN)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "  ";
        try {
            s = in.readLine();
        } catch (IOException e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }

        if (s.length() > 0 && s.toLowerCase().charAt(0) == 'd') lang = Language.de;
        else lang = Language.en;
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

            System.out.println(cv);

            ps.close();
            fos.close();
            System.setOut(ps_console);

            if (lang == Language.de) {
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
            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            if (lang == Language.de) pdf.setDefaultPageSize(new PageSize(595f, 1770f));
            else pdf.setDefaultPageSize(new PageSize(595f, 1720f));
            Document doc = new Document(pdf);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);

            String sCV = cv.toString();
            String[] cvList = sCV.split("\\n");
            for (String line : cvList) {
                List<String> list = findLink(line);
                if (list.size() == 3) {
                    Link link = new Link(list.get(1), new PdfLinkAnnotation(new Rectangle(0, 0)) {{
                        setAction(PdfAction.createURI(list.get(1)));
                    }}){{
                        setFont(font);
                        setFontSize(10.8f);
                    }};
                    doc.add(new Paragraph() {{
                        add(new Text("\u00AD" + list.get(0)) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        add(link.setUnderline() );
                        add(new Text(list.get(2)) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        setMultipliedLeading(0.5f);
                    }});
                } else {
                    doc.add(new Paragraph() {{
                        add(new Text("\u00AD" + line) {{
                            setFont(font);
                            setFontSize(10.8f);
                        }});
                        setMultipliedLeading(0.5f);
                    }});
                }
            }
            doc.close();

            if (lang == Language.de) {
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
     * This methode offers the User with two options:
     * A) to close this application
     * B) To create a .txt CV
     */
    public static void menu() {
        if (lang == Language.de) {
            System.out.println("\n\nDr\u00FCcke 'x' um dieses Fenster zu schlie\u00DFen");
            System.out.println("Dr\u00FCcke 'p' um diesen Lebenslauf in eine pdf Datei zu drucken");
        } else {
            System.out.println("\n\nPress 'x' to close this window");
            System.out.println("Press 'p' to print the CV into a pdf file ");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "  ";
        try {
            s = in.readLine();
        } catch (IOException e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }
        if (s.length() > 0 && s.toLowerCase().charAt(0) == 'p') {
            if (lang == Language.de) makePdf("Lebenslauf_Nicolas_Mahn.pdf");
            else makePdf("CV_Nicolas_Mahn.pdf");
        }
        else if (s.length() > 0 && s.toLowerCase().charAt(0) == 't') {
            if (lang == Language.de) makeTxt("Lebenslauf_Nicolas_Mahn.txt");
            else makeTxt("CV_Nicolas_Mahn.txt");
        }
    }
}

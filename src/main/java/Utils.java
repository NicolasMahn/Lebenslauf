import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author NicolasMahn
 * In dieser Klasse werden hilfreiche Methoden definiert, welche
 */
public class Utils {
    static final int MAXLINELENGTH = 80;

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
     * Diese Methode schreibt eine Linie Aenlich wie man hr aus html kennt
     */
    public static void hr() {
        for (int i = 0; i < MAXLINELENGTH; i++) System.out.print('-');
    }

}

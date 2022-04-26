package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author NicolasMahn
 * Helpful methods are defined in this class
 */
public class Utils {
    static final int MAXLINELENGTH = 80;

    /**
     * This method turns a HashMap into a String
     * @param hm represents the transferred HashMap
     * @param <K> K is the key object of the HashMap
     * @param <V> V is the value object of the HashMap
     * @return A String describing the HashMap is returned
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
     * This method adds an Enters into a string that is too long. It also handles the tabbing.
     * An Enter is only added when the string exceeds the MAXLINELENGTH specified above.
     * If possible at a space, otherwise a word is split.
     * @param s the String which might be seperated into lines
     * @param space the space in front of the String s
     * @param nlSpace the tab for the next line
     * @return the String is returned with enters
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
     * This method converts an int to a string of spaces, at the length of the int.
     * @param len defines the length of the return String
     * @return returns a String in the length of len
     */
    public static String getSpace(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }

    /**
     * This method writes a line similar to what one might know from html
     */
    public static void hr() {
        for (int i = 0; i < MAXLINELENGTH; i++) System.out.print('-');
    }
}

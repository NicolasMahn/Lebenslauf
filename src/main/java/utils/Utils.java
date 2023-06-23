package utils;

import java.util.*;

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
     * This Method finds the Ordinal of a number
     * @param numb
     * @return the Ordinal
     */
    public static String findOrdinal(int numb) {
        if ((numb-1)%10 == 0 && numb != 11) return "st";
        else if ((numb-2)%10 == 0 && numb != 12) return "nd";
        else if ((numb-3)%10 == 0 && numb != 13) return "rd";
        else return "th";
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

        String[] sList = s.split("\\n");
        if (sList.length > 1) {
            String returnS = "";
            for (String line : sList) returnS += newLine(line, space, nlSpace) + "\n";
            return returnS;
        }

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
        if (s2.length() > MAXLINELENGTH && !isEmptyOrWhitespace(s2)) s2 = newLine(s2, 0, nlSpace);
        return (s1 + s2);
    }

    public static boolean isEmptyOrWhitespace(String str) {
        return str.trim().isEmpty();
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
     * @return String of MAXLINELENGTH '-'
     */
    public static String hr() {
        String s = "\n";
        for (int i = 0; i < MAXLINELENGTH; i++) s += '-';
        return s;
    }

    /**
     * this Method finds Links in a String
     * @param str the String to find links in
     * @return a List of Strings containing of a first entry -> before the link
     *                                           second entry -> the link
     *                                           third entry -> behind the link
     */
    public static List<String> findLink(String str) {
        if (str.contains("https://")) {
            String[] arr = str.split("https://");
            String beforeLink = arr[0];
            String tempSLink = "https://";
            String tempBehindLink = "";
            if (arr[1].contains(" ")) { //Links are not allowed to have spaces
                tempSLink += arr[1].substring(0, arr[1].charAt(' '));
                tempBehindLink = arr[1].substring(arr[1].charAt(' '));
            } else tempSLink += arr[1];
            String link = tempSLink;
            String behindLink = tempBehindLink;
            return new ArrayList<String>() {{
                add(beforeLink);
                add(link);
                add(behindLink);
            }};
        } else {
            return new ArrayList<String>() {{
                add(str);
            }};
        }
    }

    /**
     * This Method converets a String to a Language enum
     * @param language String
     * @return language Enum
     */
    public static Language strToLangEnum(String language) {
        if (language.contains("de")) return Language.de;
        else return  Language.en;
    }

    /**
     * Finds out whether the key is in the array
     * @param array
     * @param key
     * @return
     */
    public static boolean intArrContains(int[] array, int key) {
        return Arrays.stream(array).anyMatch(i -> i == key);
    }
}

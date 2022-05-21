package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.*;
import tuple.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class reads and can save cv jsons
 * @author NicolasMahn
 */
public class Json {
    static Language language = null;

    /**
     * This Method reads the json and then makes objects from it in a given pattern
     * @param filename
     * @return Tuple of all Objects
     */
    public static Tuple readCV(String filename) {
        ObjectMapper jsonMapper = new ObjectMapper();
        Map<String, Object> json = new HashMap<>();
        try {
            json = jsonMapper.readValue(new File(filename), HashMap.class);
        } catch (IOException e) {
            System.err.println("Oh, something went wrong....");
            e.printStackTrace();
        }
        language = Utils.strToLangEnum((String) json.get("language"));

        return makeTuple(json);
    }

    /**
     * This Method detects the class of an object an instructs the making of such an object
     * @param obj
     * @return defined Object
     */
    private static Object makeObject(Object obj) {

        String clas = obj.getClass().toString();
        if (clas.contains("LinkedHashMap")) {
            Map<String, Object> map = (HashMap) obj;
            String typ = (String) map.get("typ");
            if (typ.equals("KeyValue")) return makeKeyValue(map);
            else if (typ.equals("Activity")) return makeActivity(map);
            else if (typ.equals("Experience")) return makeExperience(map);
            else if (typ.equals("Abroad")) return makeAbroad(map);
            else if (typ.equals("Skill")) return makeSkill(map);
            else if (typ.equals("Tuple")) return makeTuple(map);
            else if (typ.equals("Date")) return makeDate(map);
            else {
                System.err.println("Oh, something went wrong....");
                System.err.println(typ);
                return null;
            }
        } else if (clas.contains("String")) {
            return Utils.newLine((String) obj, 0) + "\n";
        } else {
            System.err.println("Oh, something went wrong....");
            System.err.println(clas);
            return null;
        }
    }

    /**
     * This Method makes Tuples from a json map
     * @param map
     * @returns a Tuple Object
     */
    private static Tuple makeTuple(Map<String, Object> map) {
        List<Object> attributes = (List<Object>) map.get("attributes");
        List<Object> save = new ArrayList<>();
        for (Object attr : attributes){
            save.add(makeObject(attr));
        }
        Tuple tuple = Tuple.createTupleFromList(save);
        if (map.keySet().containsAll(new ArrayList<String>() {{ add("headline"); add("hierarchy"); }})){
            tuple.setHeadline((String) map.get("headline"));
            tuple.setHierarchy((int) map.get("hierarchy"));
        }
        return tuple;
    }

    /**
     * This Method makes KeyValues from a json map
     * @param map
     * @return a KeyValue Object
     */
    private static KeyValue makeKeyValue(Map<String, Object> map) {
        ArrayList<Object> attributes = (ArrayList) map.get("attributes");
        return new KeyValue(attributes.get(0), makeObject(attributes.get(1)));
    }

    /**
     * This Method makes Activities from a json map
     * @param map
     * @return an Activity Object
     */
    private static Activity makeActivity(Map<String, Object> map) {
        ArrayList<Object> attributes = (ArrayList) map.get("attributes");
        Date one;
        Date two;
        if (attributes.get(0) != null) one = (Date) makeObject(attributes.get(0));
        else one = null;
        if (attributes.get(1) != null) two = (Date) makeObject(attributes.get(1));
        else two = null;
        return new Activity(one, two, (String) attributes.get(2), (String) attributes.get(3),
                (String) attributes.get(4), (String) attributes.get(5), (String) attributes.get(6), language);
    }

    /**
     * This Method makes Experiences from a json map
     * @param map
     * @return an Experience Object
     */
    private static Experience makeExperience(Map<String, Object> map) {
        ArrayList<Object> attributes = (ArrayList) map.get("attributes");
        if (attributes.size() > 3) {
            return new Experience((int) attributes.get(0), (String) attributes.get(1), (String) attributes.get(2),
                    (String) attributes.get(3), language);
        } else {
            return new Experience((int) attributes.get(0), (String) attributes.get(1), (String) attributes.get(2),
                    language);
        }
    }

    /**
     * This Method makes Abroads from a json map
     * @param map
     * @return an Abroad Object
     */
    private static Abroad makeAbroad(Map<String, Object> map) {
        ArrayList<Object> attributes = (ArrayList) map.get("attributes");
        return new Abroad((Date) makeObject(attributes.get(0)), (Date) makeObject(attributes.get(1)),
                (String) attributes.get(2), (String) attributes.get(3), (String) attributes.get(4), language);
    }

    /**
     * This Method makes Skills from a json map
     * @param map
     * @return a Skill Object
     */
    private static Skill makeSkill(Map<String, Object> map) {
        ArrayList<Object> attributes = (ArrayList) map.get("attributes");
        if (attributes.size() < 2) {
            return new Skill((String) attributes.get(0), language);
        } else if (attributes.get(1).getClass().toString().contains("String")){
            return new Skill( (String) attributes.get(0), (String) attributes.get(1), language);
        } else {
            return new Skill( (String) attributes.get(0), (int) attributes.get(1), language);
        }
    }

    /**
     * This Method makes Dates from a json map
     * @param map
     * @return a Date Object
     */
    private static Date makeDate(Map<String, Object> map) {
        ArrayList<Integer> attributes = (ArrayList) map.get("attributes");
        int length = attributes.size();
        if (length == 1)  return new Date(attributes.get(0), language);
        else if (length == 2)  return new Date(attributes.get(0), attributes.get(1), language);
        else if (length == 3)  return new Date(attributes.get(0), attributes.get(1), attributes.get(2), language);
        else {
            System.err.println("Oh, something went wrong....");
            System.err.println(map);
            return null;
        }
    }
}

package tuple;

import static utils.Utils.*;

import java.util.List;

/**
 * @author NicolasMahn
 * This class is the parent class of all specific tuple. A tuple is a Object holding several other Objects
 */
public class Tuple {
    private String headline = null;
    private int hierarchy = 0;
    private int i = 0;
    private final int LENGTH = 0;

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

    public String getHeadline(){return headline;}
    public void setHeadline(String headline){this.headline = headline;}

    public int getHierarchy(){return hierarchy;}
    public void setHierarchy(int hierarchy){this.hierarchy = hierarchy;}

    public int length(){return LENGTH;}

    /**
     * TODO
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        switch (this.hierarchy) {
            case 1:
                if (this.headline.contains("Lebenslauf")) {
                    s += "\n\n\n# " + headline;
                    s += hr() + "\n";
                    s += newLine("Dieser Lebenslauf wurde Ihnen bereitgestellt von: " +
                            "https://github.com/NicolasMahn/Lebenslauf", 0);
                } else {
                    s += "\n\n\n# " + headline;
                    s += hr() + "\n";
                    s += newLine("This CV was provided by: " +
                            "https://github.com/NicolasMahn/Lebenslauf", 0);
                }
                break;
            case 2:
                s += hr();
                s += "\n## " + headline + "\n\n";
                break;
            case 3:
                s += "\n### " + headline + "\n";
                break;
        }

        while (this.hasnext()) {
            s += this.getnext();
        }
        return s;
    }

    public boolean hasnext() {
        if (i < this.length()) return true;
        else {
            i = 0;
            return false;
        }
    }

    public Object getnext() {
        if (i >= this.length()) i = 0;
        i++;
        return this.get(i-1);
    }

    public Object get(int index) {
        switch (index) {
            case 0: return getFirst();
            case 1: return getSecond();
            case 2: return getThird();
            case 3: return getFourth();
            case 4: return getFifth();
            case 5: return getSixth();
            case 6: return getSeventh();
            case 7: return getEighth();
            case 8: return getNinth();
            case 9: return getTenth();
            case 10: return getEleventh();
            case 11: return getTwelfth();
            case 12: return getThirteenth();
            case 13: return getFourteenth();
            case 14: return getFifteenth();
            case 15: return getSixteenth();
            case 16: return getSeventeenth();
            case 17: return getEighteenth();
            case 18: return getNineteenth();
            case 19: return getTwentieth();
        }
        return null;
    }

    /**
     * TODO
     * @param list
     * @return
     */
    public static Tuple createTupleFromList(List<Object> list) {
        int size = list.size();
        switch(size){
            case 1:
                return new Tuple1<>(list.get(0));
            case 2:
                return new Tuple2<>(list.get(0), list.get(1));
            case 3:
                return new Tuple3<>(list.get(0), list.get(1), list.get(2));
            case 4:
                return new Tuple4<>(list.get(0), list.get(1), list.get(2), list.get(3));
            case 5:
                return new Tuple5<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
            case 6:
                return new Tuple6<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
            case 7:
                return new Tuple7<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6));
            case 8:
                return new Tuple8<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7));
            case 9:
                return new Tuple9<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8));
            case 10:
                return new Tuple10<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9));
            case 11:
                return new Tuple11<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10));
            case 12:
                return new Tuple12<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11));
            case 13:
                return new Tuple13<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12));
            case 14:
                return new Tuple14<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13));
            case 15:
                return new Tuple15<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14));
            case 16:
                return new Tuple16<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14), list.get(15));
            case 17:
                return new Tuple17<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14), list.get(15), list.get(16));
            case 18:
                return new Tuple18<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14), list.get(15), list.get(16), list.get(17));
            case 19:
                return new Tuple19<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14), list.get(15), list.get(16), list.get(17), list.get(18));
            case 20:
                return new Tuple20<>(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
                        list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12),
                        list.get(13), list.get(14), list.get(15), list.get(16), list.get(17), list.get(18),
                        list.get(19));
            default:
                System.err.println("Oh, something went wrong....");
                return null;

        }
    }
}

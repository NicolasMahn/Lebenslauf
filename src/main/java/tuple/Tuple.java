package tuple;

/**
 * @author NicolasMahn
 * This class is the parent class of all specific tuple. A tuple is a Object holding several other Objects
 */
public class Tuple {
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

    public int length(){return LENGTH;}

    public boolean hasnext() {
        if (i < this.length()) return true;
        else return false;
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
}

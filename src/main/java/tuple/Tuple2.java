package tuple;

/**
 * @author NicolasMahn
 * This class can store 2 different objects in one
 */
public class Tuple2<A, B>  extends Tuple {
    public A first; public B second;
    private final int LENGTH = 2;

    public Tuple2(A first, B second){
        this.first = first; this.second = second;
    }

    public int length() {
        return LENGTH;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
}
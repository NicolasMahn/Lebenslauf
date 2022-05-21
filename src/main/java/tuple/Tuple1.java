package tuple;

/**
 * @author NicolasMahn
 * This class can store 1 different object
 */
public class Tuple1<A>  extends Tuple {
    public A first;
    private final int LENGTH = 1;

    public Tuple1(A first){
        this.first = first;
    }

    public int length() {
        return LENGTH;
    }

    public A getFirst() {return first;}
}
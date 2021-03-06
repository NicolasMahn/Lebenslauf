package tuple;

/**
 * @author NicolasMahn
 * This class can store 4 different objects in one
 */
public class Tuple4<A, B, C, D>  extends Tuple {
    public A first; public B second; public C third; public D fourth;
    private final int LENGTH = 4;

    public Tuple4(A first, B second, C third, D fourth){
        this.first = first; this.second = second; this.third = third; this.fourth = fourth;
    }

    public int length() {
        return LENGTH;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
}
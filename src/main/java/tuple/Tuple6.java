package tuple;

/**
 * @author NicolasMahn
 * This class can store 6 different objects in one
 */
public class Tuple6<A, B, C, D, E, F>  extends Tuple {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth;
    private final int LENGTH = 6;

    public Tuple6(A first, B second, C third, D fourth, E fifth, F sixth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth;
    }

    public int length() {
        return LENGTH;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
    public E getFifth() {return fifth;}
    public F getSixth() {return sixth;}
}

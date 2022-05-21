package tuple;

/**
 * @author NicolasMahn
 * This class can store 8 different objects in one
 */
public class Tuple8<A, B, C, D, E, F, G, H>  extends Tuple {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    public H eighth;
    private final int LENGTH = 8;

    public Tuple8(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh; this.eighth = eighth;
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
    public G getSeventh() {return seventh;}
    public H getEighth() {return eighth;}
}

package tuple;

/**
 * @author NicolasMahn
 * This class can store 7 different objects in one
 */
public class Tuple7<A, B, C, D, E, F, G>  extends Tuple {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    private final int LENGTH = 7;

    public Tuple7(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh;
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
}

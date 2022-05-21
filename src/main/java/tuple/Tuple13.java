package tuple;

/**
 * @author NicolasMahn
 * This class can store 13 different objects in one
 */
public class Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>  extends Tuple {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    public H eighth; public I ninth; public J tenth; public K eleventh; public L twelfth; public M thirteenth;
    private final int LENGTH = 13;

    public Tuple13(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth,
                   K eleventh, L twelfth, M thirteenth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh; this.eighth = eighth; this.ninth = ninth; this.tenth = tenth;
        this.eleventh = eleventh; this.twelfth = twelfth; this.thirteenth = thirteenth;
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
    public I getNinth() {return ninth;}
    public J getTenth() {return tenth;}
    public K getEleventh() {return eleventh;}
    public L getTwelfth() {return twelfth;}
    public M getThirteenth() {return thirteenth;}
}
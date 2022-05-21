package tuple;

/**
 * @author NicolasMahn
 * This class can store 5 different objects in one
 */
public class Tuple5<A, B, C, D, E>  extends Tuple {
    public A first; public B second; public C third; public D fourth; public E fifth;
    private final int LENGTH = 5;

    public Tuple5(A first, B second, C third, D fourth, E fifth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
    }

    public int length() {
        return LENGTH;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
    public E getFifth() {return fifth;}
}

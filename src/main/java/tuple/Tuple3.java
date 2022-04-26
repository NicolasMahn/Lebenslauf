package tuple;

/**
 * @author NicolasMahn
 * This class can store 3 different objects in one
 */
public class Tuple3<A, B, C>  extends Tuple {
    public A first; public B second; public C third;

    public Tuple3(A first, B second, C third){
        this.first = first; this.second = second; this.third = third;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
}
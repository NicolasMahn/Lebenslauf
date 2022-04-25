package tuple;

import tuple.Tuple;

/**
 * @author NicolasMahn
 * Diese Klasse kann 4 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
public class Tuple4<A, B, C, D>  extends Tuple {
    public A first; public B second; public C third; public D fourth;

    public Tuple4(A first, B second, C third, D fourth){
        this.first = first; this.second = second; this.third = third; this.fourth = fourth;
    }

    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public C getThird() {return third;}
    public D getFourth() {return fourth;}
}
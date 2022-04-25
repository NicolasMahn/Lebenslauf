/**
 * @author NicolasMahn
 * Diese Klasse kann 9 unterschiedliche Objekte in einem, diesem, Objekt speichern
 */
class Tuple9<A, B, C, D, E, F, G, H, I>  extends  Tuple  {
    public A first; public B second; public C third; public D fourth; public E fifth; public F sixth; public G seventh;
    public H eighth; public I ninth;

    public Tuple9(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        this.first = first; this.second = second; this.third = third; this.fourth = fourth; this.fifth = fifth;
        this.sixth = sixth; this.seventh = seventh; this.eighth = eighth; this.ninth = ninth;
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
}

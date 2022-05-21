package objects;

/**
 * Thsi can be looked at as a simple one item map
 * @author NicolasMahn
 * @param <K> the key class
 * @param <V> the value class
 */
public class KeyValue<K, V> {
    K k;
    V v;

    public KeyValue (K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public String toString() {
        return k + ": " + v;
    }
}

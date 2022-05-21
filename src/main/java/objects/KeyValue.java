package objects;

/**
 * TODO
 * @param <K>
 * @param <V>
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

package org.indivaragroup.generic;

public class MultipleParameterType<K,V> {
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private K key;
    private V value;

    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }

    public MultipleParameterType(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

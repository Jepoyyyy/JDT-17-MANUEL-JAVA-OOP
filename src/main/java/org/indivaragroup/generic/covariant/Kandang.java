package org.indivaragroup.generic.covariant;

public class Kandang<T> {
    private T penghuni;
    public Kandang(T penghuni) {
        this.penghuni = penghuni;
    }

    public T getPenghuni() {
        return penghuni;
    }


}

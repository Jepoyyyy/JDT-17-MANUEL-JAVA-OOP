package org.indivaragroup.generic.contravariant;

public class KandangC<T> {
    private T penghuni;
    public KandangC(T penghuni) {
        this.penghuni = penghuni;
    }

    public T getPenghuni() {
        return penghuni;
    }
    public void setPenghuni(T penghuni) {}


}

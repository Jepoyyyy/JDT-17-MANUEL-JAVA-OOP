package org.indivaragroup.generic;

public class Pasangan<T> {
    public T getPertama() {
        return pertama;
    }

    public void setPertama(T pertama) {
        this.pertama = pertama;
    }

    public T getPertama2() {
        return pertama2;
    }

    public void setPertama2(T pertama2) {
        this.pertama2 = pertama2;
    }

    private T pertama;
    private T pertama2;

    public Pasangan(T Key, T Value) {
        this.pertama = Key;
        this.pertama2 = Value;
    }
    @Override
    public String toString() {
        return "Pasangan "+ pertama.toString() +" "+ pertama2.toString();
    }
}

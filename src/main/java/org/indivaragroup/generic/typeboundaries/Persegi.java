package org.indivaragroup.generic.typeboundaries;

public class Persegi extends Bentuk{
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    @Override
    public double hitunganLuas() {
        return sisi*sisi;
    }
}

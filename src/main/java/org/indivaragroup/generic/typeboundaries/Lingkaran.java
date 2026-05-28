package org.indivaragroup.generic.typeboundaries;

public class Lingkaran extends Bentuk{
    private double radius;

    public Lingkaran(double radius){
        this.radius = radius;
    }
    @Override
    public double hitunganLuas() {
        return Math.PI * radius * radius;
    }
}

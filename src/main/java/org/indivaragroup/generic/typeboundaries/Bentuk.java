package org.indivaragroup.generic.typeboundaries;

abstract class Bentuk implements Comparable<Bentuk> {
    abstract double hitunganLuas();

    @Override
    public int compareTo(Bentuk lain) {
        return Double.compare(this.hitunganLuas(), lain.hitunganLuas());
    }
}

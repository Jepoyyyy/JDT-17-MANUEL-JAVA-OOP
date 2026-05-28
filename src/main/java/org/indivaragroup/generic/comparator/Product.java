package org.indivaragroup.generic.comparator;

public class Product {
    String nama;
    double harga;

    public Product(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama+ "+ (Rp" +harga+")";
    }
}

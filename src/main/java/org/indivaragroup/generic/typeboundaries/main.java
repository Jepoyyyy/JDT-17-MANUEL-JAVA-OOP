package org.indivaragroup.generic.typeboundaries;

public class main {
    public static void main(String[] args) {
        Lingkaran l = new Lingkaran(15);
        System.out.println(l.hitunganLuas());
        Persegi p = new Persegi(15);
        System.out.println(p.hitunganLuas());

        KoleksiBentuk<Lingkaran> koleksi = new KoleksiBentuk();
        koleksi.tambah(new Lingkaran(5));
        koleksi.tambah(new Lingkaran(6));
        koleksi.tambah(new Lingkaran(7));

        Lingkaran terbesar = koleksi.terbesar();
        System.out.println(terbesar.hitunganLuas());
    }
}

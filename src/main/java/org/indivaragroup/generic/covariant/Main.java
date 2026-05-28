package org.indivaragroup.generic.covariant;

public class Main {
    public static void main(String[] args) {
        Kucing kucingOne = new Kucing();
        kucingOne.Nama = "Kucing";
        kucingOne.Warna = "Merah";
        Kandang<Kucing> kandangKucing = new Kandang<>(kucingOne);
        Hewan hewan = new Hewan();
        lihatKandang(kandangKucing);

    }
    static void lihatKandang(Kandang<? extends Hewan> kandang ) {
        Hewan h = kandang.getPenghuni();
        System.out.println(h.Nama);
    }

}

package org.indivaragroup.generic.contravariant;

public class Main {
    public static void main(String[] args) {
        // 1. Membuat objek KucingC dan mengisi propertinya
        KucingC kucingCOne = new KucingC();
        kucingCOne.Nama = "Kucing Oren";
        kucingCOne.Warna = "Merah";

        // 2. Membuat KandangC bertipe KucingC
        KandangC<KucingC> kandangCKucing = new KandangC<>(kucingCOne);

        // 3. Memanggil method dengan mengirimkan kandang tersebut
        lihatKandang(kandangCKucing);
    }

    // Menggunakan Contravariant (? super KucingC)
    static void lihatKandang(KandangC<? super KucingC> kandang) {

        // --- 1. PROSES WRITE (Set / Consumer) ---
        // Kita membuat objek KucingC baru untuk dimasukkan ke dalam kandang
        KucingC kucingBaru = new KucingC();
        kucingBaru.Nama = "Kucing Baru";
        kucingBaru.Warna = "Hitam";

        // Ini BERHASIL karena parameter method adalah contravariant dari KucingC
        kandang.setPenghuni(kucingBaru);
        System.out.println("-> Berhasil memasukkan kucing baru ke dalam kandang.");

        // --- 2. PROSES READ (Get / Producer) ---
        // Karena bertipe '? super KucingC', Java hanya menjamin data yang keluar adalah 'Object'
        Object penghuni = kandang.getPenghuni();

        // Untuk mencetak Nama atau Warna tanpa 'if', kita bisa memanfaatkan method toString()
        // jika sudah di-override di class KucingC/HewanC, atau melakukan cetak biasa.
        System.out.println("-> Objek yang berhasil diambil bertipe: " + penghuni.getClass().getSimpleName());
    }
}
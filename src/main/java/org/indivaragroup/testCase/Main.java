package org.indivaragroup.testCase;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Course<Integer>> daftarPeserta = new ArrayList<>();
        System.out.print("Masukkan jumlah peserta: ");
        int jumlahPeserta = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlahPeserta; i++) {
            System.out.println("\nPeserta " + (i + 1));
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Nilai: ");
            int nilai = sc.nextInt();
            sc.nextLine();

            daftarPeserta.add(new Course<>(nama, nilai));
        }

        System.out.println("\n===== HASIL =====");

        int totalNilai = 0;
        int jumlahLulus = 0;
        Course<Integer> pesertaTertinggi = daftarPeserta.get(0);

        for (Course<Integer> peserta : daftarPeserta) {
            peserta.tampilkanData();
            System.out.println();

            totalNilai += peserta.getNilai();

            if (peserta.getNilai() >= 50) {
                jumlahLulus++;
            }

            if (peserta.getNilai() > pesertaTertinggi.getNilai()) {
                pesertaTertinggi = peserta;
            }
        }

        double rataRata = (double) totalNilai / jumlahPeserta;
        System.out.println("==================");
        System.out.println("Rata-rata Nilai        : " + rataRata);
        System.out.println("Jumlah Peserta Lulus   : " + jumlahLulus);
        System.out.println("Peserta Nilai Tertinggi: " + pesertaTertinggi.getNamaPeserta() + " (" + pesertaTertinggi.getNilai() + ")");
        sc.close();
    }
}
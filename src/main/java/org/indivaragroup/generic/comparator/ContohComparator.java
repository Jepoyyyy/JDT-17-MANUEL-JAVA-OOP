package org.indivaragroup.generic.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContohComparator {
    public static void main(String[] args) {
        List<Product> daftar = new ArrayList<>();
        daftar.add(new Product("Laptop",1500000000));
        daftar.add(new Product("Ulo",3000000));
        daftar.add(new Product("Tablet",4000000));

        Comparator<Product> urutharga = (p1,p2) ->Double.compare(p1.harga, p2.harga);
        Collections.sort(daftar,urutharga);

        System.out.println("Diurutkan berdasrakan Harga");
        daftar.forEach(System.out::println);

        daftar.sort(Comparator.comparing(p -> p.nama));
        System.out.println("Berdasrakan Nama");
        daftar.forEach(System.out::println);

//        List<Product> daftar = new ArrayList<>();
//        daftar.add(new Product("Laptop", 1500000000));
//        daftar.add(new Product("Ulo", 3000000));
//        daftar.add(new Product("Tablet", 4000000));

//        // 1. URUT BERDASARKAN HARGA (Cara kamu - Sudah Benar)
//        Comparator<Product> urutharga = (p1, p2) -> Double.compare(p1.harga, p2.harga);
//        Collections.sort(daftar, urutharga);
//
//        System.out.println("=== Diurutkan berdasarkan Harga ===");
//        daftar.forEach(System.out::println);
//        System.out.println();
//
//        // 2. URUT BERDASARKAN NAMA (Perbaikan Cara Modern)
//        // Kita panggil langsung method .sort() milik list 'daftar'
//        daftar.sort(Comparator.comparing(p -> p.nama));
//
//        System.out.println("=== Diurutkan berdasarkan Nama ===");
//        daftar.forEach(System.out::println);
    }
}

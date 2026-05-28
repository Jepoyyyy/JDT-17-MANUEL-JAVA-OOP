package org.indivaragroup.generic.compareableinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContohCompareable {
    public static void main(String[] args) {
        List<Mahasiswa> daftar = new ArrayList<>();
        daftar.add(new Mahasiswa("Mahal",13));
        daftar.add(new Mahasiswa("Mahal",14));
        daftar.add(new Mahasiswa("Mahal",12));
        daftar.add(new Mahasiswa("Mahal",11));

        System.out.println("Sebelum");
        for (Mahasiswa m : daftar) {
            System.out.println(""+ m);
        }

        Collections.sort(daftar);

        System.out.println("Setelah");
        for (Mahasiswa m : daftar) {
            System.out.println("" + m);
        }

    }
}

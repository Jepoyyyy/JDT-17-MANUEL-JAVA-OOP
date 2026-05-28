package org.indivaragroup.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class main {
//    static void cetakSemua (List<?> kotak){
//        for (Object item : kotakdaftar){}
//    }
    static void cetakKotak (Kotak <?> kotak){
        System.out.println("isi Kotak" + kotak.getData());
    }
    public static void main(String[] args) {
        List<?> Kotak = new ArrayList<>();
    }
}

package org.indivaragroup.generic;

public class MainInstanceOf<T> {
    private T[] array;

    public MainInstanceOf(T[] array) {
        this.array = array;
    }
    public static <T> void predictArray(T[] array){
        if (array == null|| array.length==0) {
            System.out.println("gada");
            return;
        }
        T value = array[0];

    if (value instanceof String) {
        StringBuilder hasilString = new StringBuilder();
        for (Object elemen : array) {
            hasilString.append((String) elemen);
        }
        System.out.println("Hasil String : " + hasilString);
    } else if (value instanceof Number) {
        int hasilNumber = 0;
        for (int i =0 ; i<array.length ; i++) {
            hasilNumber += ((Number) array[i]).intValue();
        }
        System.out.println("Hasil Number : " + hasilNumber);
    } else if (value instanceof Boolean) {
        String hasilBoolean = "";
        for (int i =0 ; i<array.length ; i++) {
            hasilBoolean += !((Boolean)array[i]) + " ";
        }

        System.out.println("Boolean : " + hasilBoolean.trim());
    }
        }
    }


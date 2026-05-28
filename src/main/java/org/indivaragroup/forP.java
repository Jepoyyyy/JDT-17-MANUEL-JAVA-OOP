package org.indivaragroup;

public class forP {
    public static void main(String[] args) {
        String[] itemlist = new String[3];
        int itemCounter = 3;

        itemlist[0] = "X";
        itemlist[1] = "Zaroon";
        itemlist[2] = "D";

        for (int i = 0; i < itemCounter - 1; i++) {
            for (int j = 0; j < itemCounter; j++) {
                System.out.println(itemlist[j]);
            }
        }

        for (int i = 0; i < itemCounter; i++) {
            System.out.println(itemlist[i]);
        }
    }
}
package org.indivaragroup.generic;

public class ArrayHelper {
   public static <T> void cetakArray(T[] array) {
       for (T item : array) {
           System.out.println(item + "");
       }
       System.out.println();
   }

   public static <T> T cetakFirst(T[] array) {
       if (array.length == 0) {
           return null;

       }
       return array[0];
   }
}

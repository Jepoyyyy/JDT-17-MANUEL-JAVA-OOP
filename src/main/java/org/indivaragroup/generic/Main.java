package org.indivaragroup.generic;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        KotakString KotakOne = new KotakString();
//        KotakString KotakTwo = new KotakString();
//        KotakString KotakThree = new KotakString();
//        KotakOne.setValue("Yey");
//        KotakTwo.setValue(123);
//        KotakThree.setValue("....Mama");
//        KotakOne.print();
//        KotakTwo.print();
//        KotakThree.print();
//
//        Pasangan hewan = new Pasangan<>("sapi","babi");
//        System.out.println(hewan.toString());
//
//        MultipleParameterType<String,Integer> test = new MultipleParameterType<>("Awwww",1234);
//        System.out.println(test.getValue() + " " +test.getKey() );
//
//        Integer[] testArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        String[] testNama = new String[]{"A","B","C","D","E","F"};
//        ArrayHelper.cetakArray(testArray);
//        System.out.print( ArrayHelper.cetakFirst(testNama) );

        Object[] array = new Object[]{"A","B","C","D","E","F"};
        Object[] array2 = new Object[]{2,3,4};
        Object[] array3 = new Object[]{true,true,false,false,true};
        Object[] array4 = new Object[]{};
        MainInstanceOf.predictArray(array);
        MainInstanceOf.predictArray(array2);
        MainInstanceOf.predictArray(array3);
        MainInstanceOf.predictArray(array4);


        //Tipe Data harus Jelas
        //contoh salah
        ArrayList list = new ArrayList();
        list.add("A");
        list.add(1);

        String Teks = (String) list.get(1);

//        yang bener
        List<String> list2 = new ArrayList();
        list2.add("A");
        list2.add("B");

        String Teks1 = (String) list.get(0);

        System.out.println(Teks);
        System.out.println(Teks1);
        //invariant

        TypeBoundaries<Integer>  OkGas= new TypeBoundaries<>();
       //salah TypeBoundaries<boolean>  OkGas1= new TypeBoundaries<>();
    }
}
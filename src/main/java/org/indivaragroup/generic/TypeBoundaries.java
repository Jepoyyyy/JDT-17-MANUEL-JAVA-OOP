package org.indivaragroup.generic;

public class TypeBoundaries <T extends Number> {
    private T data;

    public double nilaiDouble(){
     return data.doubleValue();
    }
}

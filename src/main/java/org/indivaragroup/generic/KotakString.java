package org.indivaragroup.generic;

public class KotakString <T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print(){
        System.out.println( "Yey"+ value);
    }

    private T pertama;
    private T pertama2;

}

package org.indivaragroup.inheritance.exam.company;

import org.indivaragroup.inheritance.exam.company.annotation.ValidAge;
import org.indivaragroup.inheritance.exam.company.annotation.ValidString;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Employee implements Employable {

    // Terapkan Annotation Langsung di Model
    @ValidString(minLength = 5)
    private String name;

    @ValidAge(min = 20, max = 35)
    private int age;

    @ValidString
    private String position;

    private BigDecimal salary; // Gaji tidak divalidasi input karena generate otomatis

    public Employee(String name, int age, String position, BigDecimal salary) {
        this.name = name != null ? name.toUpperCase() : "";
        this.age = age;
        this.position = position != null ? position.toUpperCase() : "";
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        NumberFormat currencyFormat = NumberFormat.getInstance(Locale.US);
        System.out.printf("| %-20s | %-5d | %-25s | Rp %-15s |\n",
                name, age, position, currencyFormat.format(salary));
    }
}
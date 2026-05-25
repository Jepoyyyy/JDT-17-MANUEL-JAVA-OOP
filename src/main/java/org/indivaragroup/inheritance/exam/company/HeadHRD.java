package org.indivaragroup.inheritance.exam.company;

import java.math.BigDecimal;

public class HeadHRD extends Employee {
    public HeadHRD(String name, int age, BigDecimal salary) {
        super(name, age, "HEAD HRD", salary);
        if (age > 55) {
            System.out.println("\n>>> [MEMO HEAD HRD] UNTUK " + name.toUpperCase() + ": KAMU HARUS PENSIUN! <<<");
        }
    }
}
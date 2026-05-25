package org.indivaragroup.inheritance.exam.company;

import java.math.BigDecimal;

public class JavaDeveloper extends Employee {
    public JavaDeveloper(String name, int age, String level, BigDecimal salary) {
        super(name, age, "JAVA DEVELOPER (" + level + ")", salary);
    }
}
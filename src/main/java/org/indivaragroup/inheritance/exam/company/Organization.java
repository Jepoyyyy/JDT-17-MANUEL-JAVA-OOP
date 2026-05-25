package org.indivaragroup.inheritance.exam.company;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String companyName;
    private List<Employee> employees;

    public Organization(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void displayStructure() {
        System.out.println("\n==========================================================================");
        System.out.println("               STRUKTUR ORGANISASI " + companyName.toUpperCase());
        System.out.println("==========================================================================");
        System.out.printf("| %-20s | %-5s | %-25s | %-18s |\n", "NAMA KARYAWAN", "UMUR", "POSISI / LEVEL", "GAJI");
        System.out.println("--------------------------------------------------------------------------");
        for (Employee emp : employees) {
            emp.displayInfo();
        }
        System.out.println("==========================================================================\n");
    }
}
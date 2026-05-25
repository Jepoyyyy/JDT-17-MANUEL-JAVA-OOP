package org.indivaragroup;

import org.indivaragroup.inheritance.exam.company.*;
import org.indivaragroup.inheritance.exam.company.exception.validation.EmployeeValidationException;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.TegalFoodStall;

import java.math.BigDecimal;
import java.util.Scanner;

import org.indivaragroup.inheritance.exam.company.Employee;



public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("PT JDT 17 MAJU SEJAHTERA MANDIRI");


        org.addEmployee(new HeadHRD("Slamet Riyadi", 58, new BigDecimal("35000000")));
        org.addEmployee(new JavaDeveloper("Budi Santoso", 24, "JUNIOR", new BigDecimal("12000000")));

        org.displayStructure();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== PENDAFTARAN KARYAWAN BARU ===");

        System.out.print("Masukkan Nama       : ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Umur       : ");
        int age = 0;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Error: Umur harus angka!");
            return;
        }

        System.out.print("Masukkan Role/Posisi: ");
        String role = scanner.nextLine();


        String level = "";
        BigDecimal salary = BigDecimal.ZERO;

        if (age >= 20 && age <= 25) {
            level = "JUNIOR";
            salary = new BigDecimal("10000000");
        } else if (age > 25 && age <= 35) {
            level = "MIDDLE TO SENIOR";
            salary = new BigDecimal("25000000");
        }


        Employee newEmployee;
        if (role.equalsIgnoreCase("HEAD HRD")) {
            newEmployee = new HeadHRD(name, age, salary);
        } else {
            newEmployee = new JavaDeveloper(name, age, level, salary);
        }


        try {
            ReflectionValidator.validate(newEmployee);


            System.out.println("\n>>> VALIDASI SUKSES! Karyawan ditambahkan.");
            org.addEmployee(newEmployee);
            org.displayStructure();

        } catch (EmployeeValidationException e) {

            System.err.println("\n" + e.getMessage());
            System.out.println(">>> PENDAFTARAN DITOLAK.");
        } catch (IllegalAccessException e) {
            System.err.println("Sistem Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
//
        TegalFoodStall stall = new TegalFoodStall();

        System.out.println("\t\t\t----------------------------------");
        System.out.println("\t\t\t         WARTEG KITE KITE         ");
        System.out.println("\t\t\t----------------------------------");

        stall.showFoodMenu();
        stall.showDrinkMenu();
    }
}

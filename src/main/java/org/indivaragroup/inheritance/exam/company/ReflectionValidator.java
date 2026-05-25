package org.indivaragroup.inheritance.exam.company;

import org.indivaragroup.inheritance.exam.company.annotation.ValidAge;
import org.indivaragroup.inheritance.exam.company.annotation.ValidString;
import org.indivaragroup.inheritance.exam.company.exception.validation.EmployeeValidationException;

import java.lang.reflect.Field;

public class ReflectionValidator {

    public static void validate(Object obj) throws EmployeeValidationException, IllegalAccessException {
        Class<?> currentClass = obj.getClass();
        String roleValue = "";


        while (currentClass != null && currentClass != Object.class) {
            try {
                Field roleField = currentClass.getDeclaredField("position");
                roleField.setAccessible(true);
                roleValue = (String) roleField.get(obj);
                break;
            } catch (NoSuchFieldException e) {
                currentClass = currentClass.getSuperclass();
            }
        }


        currentClass = obj.getClass();


        while (currentClass != null && currentClass != Object.class) {
            for (Field field : currentClass.getDeclaredFields()) {
                field.setAccessible(true);


                if (field.isAnnotationPresent(ValidString.class)) {
                    ValidString ann = field.getAnnotation(ValidString.class);
                    String value = (String) field.get(obj);

                    if (ann.notEmpty() && (value == null || value.trim().isEmpty())) {
                        throw new EmployeeValidationException("VALIDASI GAGAL: " + field.getName().toUpperCase() + " / Role tidak boleh kosong!");
                    }
                    if (value != null && value.trim().length() < ann.minLength()) {
                        throw new EmployeeValidationException("VALIDASI GAGAL: " + field.getName().toUpperCase() + " minimal " + ann.minLength() + " karakter!");
                    }
                }


                if (field.isAnnotationPresent(ValidAge.class)) {
                    ValidAge ann = field.getAnnotation(ValidAge.class);
                    int age = (int) field.get(obj);

                    if (age < ann.min()) {
                        throw new EmployeeValidationException("VALIDASI GAGAL: Umur tidak boleh di bawah " + ann.min() + " tahun!");
                    }

                    if (age > ann.max() && !roleValue.contains("HEAD HRD")) {
                        throw new EmployeeValidationException("VALIDASI GAGAL: Umur tidak boleh lebih dari " + ann.max() + " tahun!");
                    }
                    if (roleValue != null && roleValue.contains("JAVA DEVELOPER") && age < 20) {
                        throw new EmployeeValidationException("VALIDASI GAGAL: Pendaftar JAVA DEVELOPER tidak boleh di bawah 20 tahun!");
                    }
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }
}
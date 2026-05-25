package org.indivaragroup.inheritance.exam.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Harus RUNTIME agar bisa dibaca oleh Reflection
@Target(ElementType.FIELD)          // Annotation ini hanya bisa dipakai di variabel/field
public @interface ValidString {
    boolean notEmpty() default true;
    int minLength() default 0;
}
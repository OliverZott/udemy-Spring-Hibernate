package com.luv2code.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom Annotation -
 *
 * '@Constraint' ... Helper class containing business rules / validation logic
 * '@Target' ... can apply annotation to method or field
 * '@Retention' ... how long will marked annotation be used (retain in java class and process at runtime)
 */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String[] value() default {"Zwu", "LUV"};

    // define default error-message
    String message() default "Must start with 'LUV'";

    // define default groups
    Class<?>[] groups() default {};

    // define default payloads
    Class<? extends Payload>[] payload() default {};

}

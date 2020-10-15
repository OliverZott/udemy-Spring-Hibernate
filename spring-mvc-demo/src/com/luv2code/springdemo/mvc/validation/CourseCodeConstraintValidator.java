package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Null;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraint) {
        coursePrefix = constraint.value();
    }

    /**
     * "isValid" Method will be called by Spring MVC
     * Customize validation method.
     */
    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {

        boolean result;

        if (obj != null) {
            result = obj.startsWith(coursePrefix);
        } else {
            result = true;      // cause optional
        }

        // return obj != null && obj.startsWith(coursePrefix);  // not good because field is optional
        return result;
    }
}

package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.stream.Stream;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

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

        boolean result = false;

        /* Some testing
        String[] bla = coursePrefix;
        String blub = Arrays.toString(coursePrefix);
        */

        if (obj != null) {

            /*
            Stream version not working yet cause wanna check start
            https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java
             */
            // Stream<String> stream = Arrays.stream(coursePrefix);

            for (String word : coursePrefix) {
                result = obj.startsWith(word);

                if (result) {
                    break;
                }
            }

        } else {
            result = true;      // cause optional
        }

        // return obj != null && obj.startsWith(coursePrefix);  // not good because field is optional
        return result;
    }
}

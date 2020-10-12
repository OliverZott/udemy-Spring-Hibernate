package com.luv2code.springdemo.mvc;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "This field is required")
    @Size(min = 3, message = "At least three characters")
    private String lastName;

    /**
     * For @NotNull to work the type has to be "Integer" so it can be trimmed to null!!!
     */
    @NotNull(message = "This field is required")
    @Min(value = 2, message = "wtf, you got two free!!!")
    @Max(value = 10, message = "Ey, 10 max buddy!")
    private Integer freePasses;

    /**
     * Pattern works only on String-type !
     * Empty String allowed cause NO @NotNull
     */
    @Pattern(regexp = "^([a-zA-Z0-9]{5})", message = "only 5 chars/digits")
    private String postalCode;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }
}

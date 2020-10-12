package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    /*
     * Functionality:
     *  - Pre-Process every String from-data
     *  - Remove leading- an trailing whitespace
     *  - If only whitespace -> trim to null
     *
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/showCustomerForm")
    public String showForm(Model theModel) {

        // create Customer instance and add customer to model
        theModel.addAttribute("customerAttr", new Customer());

        return "customer-form";
    }


    @RequestMapping("/processCustomerForm")
    public String processForm(
            @Valid @ModelAttribute("customerAttr") Customer theCustomer,
            BindingResult theBindingResult) {
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }


}

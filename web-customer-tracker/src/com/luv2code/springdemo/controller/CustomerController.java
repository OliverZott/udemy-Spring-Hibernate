package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        System.out.println(model);

        // get customer from dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add customers list to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form-data
        Customer newCustomer = new Customer();
        model.addAttribute("customer", newCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            customerService.saveCustomer(customer);
            return "redirect:/customer/list";
        }
    }


    /**
     * Functionality:
     *  - Pre-Process every String from-data
     *  - Remove leading- an trailing whitespace
     *  - If only whitespace -> trim to null
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}

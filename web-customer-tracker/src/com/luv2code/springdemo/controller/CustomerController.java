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
     * "GET" --> spring checks if properties are NOT Null and populates in case of Get
     *
     * @param id
     * @param model
     * @return string
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

        // get customer from our service
        Customer customer = customerService.getCustomer(id);

        // set customer as model-attribute to pre-populate the form
        model.addAttribute("customer", customer);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("customerId") int id, Model model) {

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("theSearchName") String name, Model model) {
        List<Customer> customers = customerService.searchCustomer(name);
        model.addAttribute("customers", customers);
        return "list-customers";
    }


    /**
     * Functionality:
     * - Pre-Process every String from-data
     * - Remove leading- an trailing whitespace
     * - If only whitespace -> trim to null
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}

package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // Controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Controller method to process html form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    
    // Add form-data to Model
    @RequestMapping("processFormVersionTwo")
    public String letShouldDude(HttpServletRequest request, Model model) {

        // read request parameter from html form
        String theName = request.getParameter("studentName");

        // convert to upper-case
        theName = theName.toUpperCase();

        // create message
        String result = "Yo! " + theName;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }
    
    
    /*
     * Binding Request Parameters (Annotations)
     * https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5653362#overview
     */
    @RequestMapping("processFormVersionThree")
    public String processFormVersionThree(
    		@RequestParam("studentName") String theName, 
    		Model model) {


        // convert to upper-case
        theName = theName.toUpperCase();

        // create message
        String result = "Ola, from version3! " + theName;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

}

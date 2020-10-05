package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	/**
	 * 1. Create Student-Class 
	 * 2. Add Student Object to Model
	 * 
	 * 3. Create template with form (student-form.jsp)
	 * 
	 * 4. Controller to bind Form-Data to Model-Attribute
	 * 
	 * @param theModel
	 * @return
	 */
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create Student object
		Student theStudent = new Student();
		
		// add Student object to model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	
	/**
	 * 5. Pass ModelAttribute to process method+
	 *  
	 * 6. Use process-method to send Model-Attribute to a confirmation page
	 * 
	 * @param theStudent
	 * @return
	 */
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " +  theStudent.getLastName());
		
		return "student-confirmation";
	}

}

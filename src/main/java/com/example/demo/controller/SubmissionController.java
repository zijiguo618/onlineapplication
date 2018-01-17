package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Documents;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Submission;
@Controller
public class SubmissionController {
	@GetMapping("/submission")
	public String greetingForm(Model model,HttpServletRequest request) {
		model.addAttribute("submission", new Submission());
//		Documents obj=(Documents)request.getSession().getAttribute("document");
//		System.out.println(obj.toString());
		return "submission";
	}

	@PostMapping("/submission")
	public String greetingSubmit(@Valid Submission Submission,BindingResult result,HttpServletRequest request) {
		System.out.println(Submission.toString());
		HttpSession session = request.getSession();  
		session.setAttribute("Submission",Submission); 
		if(result.hasErrors()) {
			return "submission";
		}
		return "success";
	}
}

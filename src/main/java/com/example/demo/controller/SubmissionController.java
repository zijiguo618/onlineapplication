package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Submission;
@Controller
public class SubmissionController {
	@GetMapping("/submission")
	public String greetingForm(Model model) {
		model.addAttribute("submission", new Submission());
		return "submission";
	}

	@PostMapping("/submission")
	public String greetingSubmit(@ModelAttribute Submission Submission,HttpServletRequest request,BindingResult result) {
		System.out.println(Submission.toString());
		return "success";
	}
}

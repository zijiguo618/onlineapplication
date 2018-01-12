package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Settlement;

@Controller
public class SettlementController {
	@GetMapping("/settlement")
	public String greetingForm(Model model, HttpServletRequest request) {
		model.addAttribute("settlement", new Settlement());
		return "settlementaccount";
	}

	@PostMapping("/settlement")
	public String greetingSubmit(@ModelAttribute Settlement Settlement,HttpServletRequest request,
			BindingResult result) {
		System.out.println(Settlement.toString());
		return "uploadMulti";
	}
}

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.utilities.Bankaccount;
import com.example.demo.utilities.Settlement;

@Controller
public class BankaccountController {
	@GetMapping("/bankaccount")
	public String greetingForm(Model model, HttpServletRequest request) {
		model.addAttribute("bankaccount", new Bankaccount());
		List<String> currencies= new ArrayList<String>();
		currencies.add("USD");
		currencies.add("HDK");
		model.addAttribute("currencylist", currencies);
		return "bankaccount";
	}

	@PostMapping("/bankaccount")
	public String greetingSubmit(@ModelAttribute Bankaccount Bankaccount,HttpServletRequest request,
			BindingResult result) {
		System.out.println(Bankaccount.toString());
		return "success";
	}
}

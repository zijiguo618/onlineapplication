package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.utilities.Bankaccount;
import com.example.demo.utilities.Settlement;

@Controller
public class BankaccountController {
	private Settlement settlement;
	@GetMapping("/bankaccount")
	public ModelAndView greetingForm( HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("bankaccount", new Bankaccount());
		HttpSession session = request.getSession();  
		settlement =(Settlement)session.getAttribute("Settlement");
		System.out.println(settlement.toString());
		model.addObject("currencylist", settlement.getcurrensies());
		model.setViewName("bankaccount");
		return model;
	}

	@PostMapping("/bankaccount")
	public ModelAndView greetingSubmit(@Valid Bankaccount bankaccount,BindingResult result,HttpServletRequest request,RedirectAttributes redirectAttributes
			) {
		HttpSession session = request.getSession();  
		
		System.out.println(bankaccount.toString());
		if(bankaccount.getRoutingnumber().isEmpty()&&bankaccount.getSwiftcode().isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please enter your Routingnumber or SwiftCode");
			return new ModelAndView("redirect:/bankaccount");
		}
		if(result.hasErrors()) {
			System.out.println("has error");
		
			ModelAndView model =new ModelAndView();
			model.addObject("currencylist", settlement.getcurrensies());
			model.setViewName("/bankaccount");
			return model;
		}
		session.setAttribute("bankaccount",bankaccount); 
		
		return new ModelAndView("uploadMulti");
	}
}

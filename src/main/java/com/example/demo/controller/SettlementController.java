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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Products;
import com.example.demo.utilities.Settlement;

@Controller
public class SettlementController {
	@GetMapping("/settlement")
	public ModelAndView greetingForm( HttpServletRequest request) {
		System.out.println("2");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("settlement", new Settlement());
		modelAndView.setViewName("settlementaccount");
//		Products obj=(Products)request.getSession().getAttribute("products");
//		System.out.println(obj.toString());
		return modelAndView;
	}

	@PostMapping("/settlement")
	public ModelAndView greetingSubmit(@Valid Settlement Settlement,BindingResult result,HttpServletRequest request
			,RedirectAttributes redirectAttributes) {
		
		HttpSession session = request.getSession();  
		session.setAttribute("Settlement",Settlement);  
//		System.out.println(Settlement.toString());
		if(!Settlement.getWithdrawallist().equals("Manually")) {
			if(Settlement.getWithdrawalminimumamount().isEmpty()&&Settlement.getWithdrawalregular().isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select your Withdrawl Way");
				return new ModelAndView("redirect:/settlement");
			}
		}else if(Settlement.getSettlemulticurrency_CAD()==null&&Settlement.getSettlemulticurrency_EUR()==null&&Settlement.getSettlemulticurrency_GBP()==null&&Settlement.getSettlemulticurrency_HKD()==null&&Settlement.getSettlemulticurrency_JPY()==null&&Settlement.getSettlemulticurrency_USD()==null) {
			redirectAttributes.addFlashAttribute("message", "Please select your settlement currency");
			return new ModelAndView("redirect:/settlement");
		}
			if(result.hasErrors()) {
			System.out.println("error");
			return new ModelAndView("settlementaccount");
		}
		
		return new ModelAndView("redirect:/bankaccount");
	}
}

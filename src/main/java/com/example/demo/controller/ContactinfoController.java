package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.MCClist;
@Controller
public class ContactinfoController {

	@GetMapping("/contact")
	public ModelAndView greetingForm(Model model,HttpServletRequest request) {
		System.out.println("confirm contactinfo access");
		Contactinfo contactinfo = new Contactinfo();
		MCClist mcclist= new MCClist();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contactinfo", contactinfo);
		modelAndView.setViewName("contactinfo");
		Basicinfo obj= (Basicinfo)request.getSession().getAttribute("basicinfo");  
		System.out.println(obj.toString());
//		System.out.println(request.getSession().getAttribute("basicinfo").toString());
		return modelAndView;
	}

	@PostMapping("/contact")
	public ModelAndView greetingSubmit(@ModelAttribute Contactinfo contactinfo,HttpServletRequest request,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contactinfo", contactinfo);
		modelAndView.setViewName("success");
		HttpSession session = request.getSession();  
		session.setAttribute("contactinfo",contactinfo);  
		if (result.hasErrors()) {
			modelAndView.setViewName("contactinfo");
			return modelAndView;
		}
		return modelAndView;
	}
}

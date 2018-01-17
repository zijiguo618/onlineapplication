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
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contactinfo", contactinfo);
		modelAndView.setViewName("contactinfo");
//		Basicinfo obj= (Basicinfo)request.getSession().getAttribute("basicinfo");  
//		System.out.println("Basicindo:"+obj.toString());
		return modelAndView;
	}

	@PostMapping("/contact")
	public ModelAndView greetingSubmit(@Valid Contactinfo contactinfo,BindingResult result,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/products");
		HttpSession session = request.getSession();  
		session.setAttribute("contactinfo",contactinfo);  
		System.out.println(contactinfo.toString());
		if (result.hasErrors()) {
			System.out.println("has error");
			return new ModelAndView("contactinfo");
		}
		return modelAndView;
	}
}

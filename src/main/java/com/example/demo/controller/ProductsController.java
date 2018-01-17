package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Products;
import com.example.demo.utilities.offlineproducts;
import com.example.demo.utilities.onlineproducts;
@Controller
public class ProductsController {
	@GetMapping("/products")
	public ModelAndView productsform(Model model,HttpServletRequest request) {
//		Contactinfo obj= (Contactinfo)request.getSession().getAttribute("contactinfo");
//		System.out.println(obj.toString());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", new Products());
		modelAndView.setViewName("products");
		return modelAndView;
	}


	@PostMapping("/products")
	public ModelAndView productsform(@Valid Products Products,BindingResult result,HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
	
		ModelAndView modelAndView = new ModelAndView();
	
		System.out.println("1");
		modelAndView.setViewName("redirect:/settlement");
		HttpSession session = request.getSession();  
		System.out.println("1");
		session.setAttribute("products",Products);  
		System.out.println("1");
		if(Products.checkstatus()==true) {
			redirectAttributes.addFlashAttribute("message", "Please select at least one currency");
			return new ModelAndView("redirect:/products");
		}
		System.out.println("1");
		System.out.println(Products.toString());
		return modelAndView;
	}

}

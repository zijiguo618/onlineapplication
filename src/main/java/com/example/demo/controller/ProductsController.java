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

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", new Products());
		modelAndView.setViewName("products");
//		Contactinfo obj= (Contactinfo)request.getSession().getAttribute("contactinfo");  
//		System.out.println(obj.toString());
//		System.out.println(request.getSession().getAttribute("basicinfo").toString());
		return modelAndView;
	}

//	@GetMapping("/products/online")
//	public void onlineForm(Model model) {
//		model.addAttribute("onlineproducts", new onlineproducts());
//	
//	}
//
//	
//	@GetMapping("/products/offline")
//	public void offlineForm(Model model) {
//		model.addAttribute("offlineproducts", new offlineproducts());
//	
//	}

	@PostMapping("/products")
	public ModelAndView productsform(@Valid Products Products,HttpServletRequest request,
			BindingResult result) {
		System.out.println(Products.getExpresspaycurrency_USD());
		System.out.println(Products.getExpresspaycurrency_EUR());
		System.out.println(Products.getSecurepay_unionpay());
		System.out.println(Products.getSecurepay_alipay());
		System.out.println(Products.getPOS_alipay());
		System.out.println(Products.getPOS_wechatpay());
		System.out.println(Products.getShowqrcodecurrency_USD());
		System.out.println(Products.getShowqrcodecurrency_EUR());
		System.out.println(Products.getExpresspay_settlement());
		System.out.println(Products.getPOS_settlement());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Products", Products);
		modelAndView.setViewName("success");
		HttpSession session = request.getSession();  
		session.setAttribute("products",Products);  
		if (result.hasErrors()) {
			modelAndView.setViewName("products");
			return modelAndView;
		}
		return modelAndView;
	}

}

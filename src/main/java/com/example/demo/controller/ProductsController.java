package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Products;
import com.example.demo.utilities.offlineproducts;
import com.example.demo.utilities.onlineproducts;
@Controller
public class ProductsController {
	@GetMapping("/products")
	public String productsform(Model model) {
//		Map<String,Object> products = new HashMap();
//		products.put("onlineproducts",new onlineproducts());
//		products.put("offlineproducts",new offlineproducts());
//		model.addAttribute("products", products);
		model.addAttribute("products", new Products());
		return "products";
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
	public String productsform(@Valid offlineproducts offlineproducts,@Valid onlineproducts onlineproducts,HttpServletRequest request,
			BindingResult result) {
		return "products";
	}

}

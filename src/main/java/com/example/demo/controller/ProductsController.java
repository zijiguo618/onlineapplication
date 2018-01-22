package com.example.demo.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.DB;
import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Products;
@Controller
public class ProductsController {
	@GetMapping("/products")
	public ModelAndView productsform(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
//		Contactinfo obj= (Contactinfo)request.getSession().getAttribute("contactinfo");
//		System.out.println(obj.toString());
		ModelAndView modelAndView = new ModelAndView();

		
		HttpSession session = request.getSession();  
		int applicationid=(int)session.getAttribute("applicationID");
		Products prod =new Products().getproduct(applicationid);
		modelAndView.addObject("products", prod);
		modelAndView.addObject("applicationID", applicationid);

		modelAndView.setViewName("products");
		System.out.println(prod.toString());
		return modelAndView;
	}


	@PostMapping("/products")
	public ModelAndView productsform(@Valid Products Products,BindingResult result,HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException {
	
		ModelAndView modelAndView = new ModelAndView();
		DB db =new DB();

		modelAndView.setViewName("redirect:/settlementaccount");
		HttpSession session = request.getSession();  

		session.setAttribute("products",Products);  
		System.out.println((int)session.getAttribute("applicationID"));
		System.out.println(Products.toString());
		if(Products.checkstatus()==true) {
			redirectAttributes.addFlashAttribute("message", "Please select at least one currency");
			return new ModelAndView("redirect:/products");
		}
			db.update2application_product((int)session.getAttribute("applicationID"), "expresspay", Products.getExpresspaycurrency_USD(), Products.getExpresspaycurrency_JPY(), Products.getExpresspaycurrency_HKD(), Products.getExpresspaycurrency_EUR(), Products.getExpresspaycurrency_GBP(), Products.getExpresspaycurrency_CAD(),Products.getExpresspay_settlement());
			db.update((int)session.getAttribute("applicationID"), Products.getExpresspay_unionpay(), "expresspay_unionpay");
			db.update2application_product((int)session.getAttribute("applicationID"), "POS", Products.getPOScurrency_USD(), Products.getPOScurrency_JPY(), Products.getPOScurrency_HKD(), Products.getPOScurrency_EUR(), Products.getPOScurrency_GBP(), Products.getPOScurrency_CAD(),Products.getPOS_settlement());
			db.update((int)session.getAttribute("applicationID"), Products.getPOS_unionpay(), "POS_unionpay");
			db.update((int)session.getAttribute("applicationID"), Products.getPOS_wechatpay(), "POS_wechatpay");
			db.update((int)session.getAttribute("applicationID"), Products.getPOS_alipay(), "POS_alipay");
			db.update2application_product((int)session.getAttribute("applicationID"), "securepay", Products.getSecurepaycurrency_USD(), Products.getSecurepaycurrency_JPY(), Products.getSecurepaycurrency_HKD(), Products.getSecurepaycurrency_EUR(), Products.getSecurepaycurrency_GBP(), Products.getSecurepaycurrency_CAD(),Products.getSecurepay_settlement());
			db.update((int)session.getAttribute("applicationID"), Products.getSecurepay_unionpay(), "securepay_unionpay");
			db.update((int)session.getAttribute("applicationID"), Products.getSecurepay_wechatpay(), "securepay_wechatpay");
			db.update((int)session.getAttribute("applicationID"), Products.getSecurepay_alipay(), "securepay_alipay");
			db.update2application_product((int)session.getAttribute("applicationID"), "showqrcode", Products.getShowqrcodecurrency_USD(), Products.getShowqrcodecurrency_JPY(), Products.getShowqrcodecurrency_HKD(), Products.getShowqrcodecurrency_EUR(), Products.getShowqrcodecurrency_GBP(), Products.getShowqrcodecurrency_CAD(),Products.getSecurepay_settlement());
			db.update((int)session.getAttribute("applicationID"), Products.getShowqrcode_wechatpay(), "showqrcode_wechatpay");
			db.update((int)session.getAttribute("applicationID"), Products.getShowqrcode_alipay(), "showqrcode_alipay");

		System.out.println(Products.toString());
		db.updatestage((int)session.getAttribute("applicationID"), 3, "stage");
		return modelAndView;
	}

}

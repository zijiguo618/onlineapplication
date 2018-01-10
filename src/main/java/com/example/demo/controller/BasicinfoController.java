package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.MCClist;
//import com.example.demo.utilities.basicindo_industry;
@Controller
public class BasicinfoController {
	@GetMapping("/basicinfo")
	public ModelAndView showRegistration(HttpServletRequest request) {
		System.out.println("confirm access");
		Basicinfo basicinfo = new Basicinfo();
		MCClist mcclist= new MCClist();
		ModelAndView modelAndView = new ModelAndView();
//		basicindo_industry industry= new basicindo_industry();
		modelAndView.addObject("basicinfo", basicinfo);
		modelAndView.setViewName("basicinfo");
		modelAndView.addObject("mcclist", mcclist.getlist());
//		Object obj= request.getSession().getAttribute("userApplication");  
//		System.out.println(obj.toString());
//		System.out.println(request.getSession().getAttribute("message").toString());
		return modelAndView;
	}

	// Process the form.
	@PostMapping("/basicinfo")
	public ModelAndView processRegistration(@Valid Basicinfo basicinfo,HttpServletRequest request,
			BindingResult result) {
		System.out.println("confirm");
		System.out.println(basicinfo.getIndustry());
		System.out.println(basicinfo.getMcc());
		System.out.println(basicinfo.getNatureofmerchant());
		System.out.println(basicinfo.getMailaddress_city());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("basicinfo", basicinfo);
		modelAndView.setViewName("success");
	
		if (result.hasErrors()) {
			modelAndView.setViewName("basicinfo");
			return modelAndView;
		}
		return modelAndView;
	}
	public Map<String,String> getlist() {
		Map<String,String> result=new LinkedHashMap<String,String>();
		result.put("Internet","Internet / eCommerce");
		result.put("Electronic","Electronic");
		result.put("Automotive","Automotive");
		result.put("Education","Education & School");
		result.put("Tourism","Tourism & travel");
		result.put("Beauty","Beauty & Health Care");
		result.put("Resturant","Resturant & Food");
		result.put("Retail","Retail");
		result.put("Jewelry","Jewelry");
		result.put("Toys","Baby products & Toys");
		result.put("Entertainment","Entertainment, music & games");
		result.put("Sports","Sports & Outdoors");
		result.put("Fashion","Fashion");
		result.put("Professional","Professional Services");
		result.put("Business","Business Services");
		result.put("Government","Government Services");
		result.put("Other","Other");
		return result;
	}
	
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map referenceData = new HashMap();
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		referenceData.put("countryList", country);
		return referenceData;
		}
}

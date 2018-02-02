package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.DB;
import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.MCClist;

import com.example.demo.utilities.Registration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BasicinfoController {
	@GetMapping("/basicinfo")
	public ModelAndView showRegistration(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		System.out.println("confirm access");
		Basicinfo basicinfo = new Basicinfo();
		HttpSession session = request.getSession();
		MCClist mcclist = new MCClist();
		ModelAndView modelAndView = new ModelAndView();
		int applicationid = (int) session.getAttribute("applicationID");
		modelAndView.addObject("basicinfo", basicinfo.getbasicinfo(applicationid));
		modelAndView.addObject("applicationID", applicationid);
		modelAndView.setViewName("index");
		modelAndView.addObject("mcclist", mcclist.getlist());
		return modelAndView;
	}

	@PostMapping("/basicinfo")
	public ModelAndView processRegistration(@Valid Basicinfo basicinfo,BindingResult result,HttpServletRequest request,RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException {
		ModelAndView modelAndView = new ModelAndView();
		DB db = new DB();
		System.out.println("confirm button");
		String mailingaddress = basicinfo.getMailaddress_country() + " , " + basicinfo.getMailaddress_state() + " , "
				+ basicinfo.getMailaddress_city() + " , " + basicinfo.getMailaddress_street() + " , "
				+ basicinfo.getMailaddress_zipcode();
		

		if (result.hasErrors()) {
			System.out.println("errors happreed");
			MCClist mcclist= new MCClist();
			modelAndView.addObject("mcclist", mcclist.getlist());
			modelAndView.setViewName("index");
			return modelAndView;
		}
		HttpSession session = request.getSession();
		session.setAttribute("basicinfo", basicinfo);
		modelAndView.setViewName("redirect:/contactinfo");
		db.update2application_basic((int)session.getAttribute("applicationID"), basicinfo.getMerchantname(), basicinfo.getMerchantlegalname(),
				basicinfo.getMerchanturl(), basicinfo.getCustomerservicetel(), basicinfo.getMerchanttype(),
				basicinfo.getEstablisheddate(), basicinfo.getNatureofmerchant(), basicinfo.getMcc(),
				basicinfo.getIndustry(), basicinfo.getFederaltaxid(), basicinfo.getAgent(),
				mailingaddress);
		db.updatestage((int)session.getAttribute("applicationID"), 1, "stage");
		 ObjectMapper mapperObj = new ObjectMapper();
		 String jsonStr;
		try {
			System.out.println("----hson----");
			jsonStr = mapperObj.writeValueAsString(basicinfo);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return modelAndView;
	}

	public Map<String, String> getlist() {
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("", "");
		result.put("Internet", "Internet / eCommerce");
		result.put("Electronic", "Electronic");
		result.put("Automotive", "Automotive");
		result.put("Education", "Education & School");
		result.put("Tourism", "Tourism & travel");
		result.put("Beauty", "Beauty & Health Care");
		result.put("Resturant", "Resturant & Food");
		result.put("Retail", "Retail");
		result.put("Jewelry", "Jewelry");
		result.put("Toys", "Baby products & Toys");
		result.put("Entertainment", "Entertainment, music & games");
		result.put("Sports", "Sports & Outdoors");
		result.put("Fashion", "Fashion");
		result.put("Professional", "Professional Services");
		result.put("Business", "Business Services");
		result.put("Government", "Government Services");
		result.put("Other", "Other");
		return result;
	}

}

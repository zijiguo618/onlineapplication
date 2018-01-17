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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.MCClist;
import com.example.demo.utilities.Registration;
@Controller
public class BasicinfoController {
	@GetMapping("/basicinfo")
	public ModelAndView showRegistration(HttpServletRequest request) {
		System.out.println("confirm access");
		Basicinfo basicinfo = new Basicinfo();
		 HttpSession session = request.getSession();  
//		 Registration obj=(Registration)session.getAttribute("registration");
//		System.out.println(obj.toString()); 
		MCClist mcclist= new MCClist();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("basicinfo", basicinfo);
		modelAndView.setViewName("basicinfo");
		modelAndView.addObject("mcclist", mcclist.getlist());
		return modelAndView;
	}

	@PostMapping("/basicinfo")
	public ModelAndView processRegistration(@Valid Basicinfo basicinfo,BindingResult result,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		
		if(!(basicinfo.getAddressmatch()==null)&&basicinfo.getAddressmatch().equals("1")) {
			System.out.println("-----------same address");
			basicinfo.setPhyaddress_country(basicinfo.getMailaddress_country());
			basicinfo.setPhyaddress_state(basicinfo.getMailaddress_state());
			basicinfo.setPhyaddress_city(basicinfo.getMailaddress_city());
			basicinfo.setPhyaddress_street(basicinfo.getMailaddress_street());
			basicinfo.setPhyaddress_zipcode(basicinfo.getMailaddress_zipcode());
					}else {
						if(basicinfo.getPhyaddress_country()==null) {
							redirectAttributes.addFlashAttribute("message", "Please enter your Physical Address Country cannot be Empty");
							modelAndView.setViewName("redirect:/basicinfo");
							return modelAndView;
						}
						if(basicinfo.getPhyaddress_state()==null) {
							redirectAttributes.addFlashAttribute("message", "Please enter your Physical Address State cannot be Empty");
							modelAndView.setViewName("redirect:/basicinfo");
							return modelAndView;
						}
						if(basicinfo.getPhyaddress_city()==null) {
							redirectAttributes.addFlashAttribute("message", "Please enter your Physical Address City cannot be Empty");
							modelAndView.setViewName("redirect:/basicinfo");
							return modelAndView;
						}
						if(basicinfo.getPhyaddress_street()==null) {
							redirectAttributes.addFlashAttribute("message", "Please enter your Physical Address Street cannot be Empty");
							modelAndView.setViewName("redirect:/basicinfo");
							return modelAndView;
						}
						if(basicinfo.getPhyaddress_zipcode()==null) {
							redirectAttributes.addFlashAttribute("message", "Please enter your Physical Address Zipcode cannot be Empty");
							modelAndView.setViewName("redirect:/basicinfo");
							return modelAndView;
						}
	
					}
		
		if (result.hasErrors()) {
			System.out.println("errors happreed");
			MCClist mcclist= new MCClist();
			modelAndView.addObject("mcclist", mcclist.getlist());
			modelAndView.setViewName("basicinfo");
			return modelAndView;
		}
		HttpSession session = request.getSession();  
		session.setAttribute("basicinfo",basicinfo);  
		modelAndView.setViewName("redirect:/contact");
//		System.out.println(basicinfo.toString());
		return modelAndView;
	}
	public Map<String,String> getlist() {
		Map<String,String> result=new LinkedHashMap<String,String>();
		result.put("","");
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
	
}

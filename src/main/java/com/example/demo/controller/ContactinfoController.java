package com.example.demo.controller;

import java.sql.SQLException;

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
import com.example.demo.utilities.MCClist;
@Controller
public class ContactinfoController {

	@GetMapping("/contactinfo")
	public ModelAndView greetingForm(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		System.out.println("confirm contactinfo access");
		HttpSession session = request.getSession();  
		int applicationid= (int)session.getAttribute("applicationID");
		
		System.out.println(applicationid);
		Contactinfo contactinfo = new Contactinfo().getcontactinfo(applicationid);
		System.out.println(contactinfo.toString());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contactinfo", contactinfo);

		modelAndView.addObject("applicationID", applicationid);
		modelAndView.setViewName("contactinfo");
//		Basicinfo obj= (Basicinfo)request.getSession().getAttribute("basicinfo");  
//		System.out.println("Basicindo:"+obj.toString());
		return modelAndView;
	}


	@PostMapping("/contactinfo")
	public ModelAndView greetingSubmit(@Valid Contactinfo contactinfo,BindingResult result,HttpServletRequest request) throws ClassNotFoundException, SQLException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/products");
		HttpSession session = request.getSession();  
		session.setAttribute("contactinfo",contactinfo);  
		System.out.println(contactinfo.toString());
		if (result.hasErrors()) {
			System.out.println("has error");
			return new ModelAndView("contactinfo");
		}
		DB db=new DB();
		db.update2application_contact((int)session.getAttribute("applicationID"), contactinfo.getContactname(), contactinfo.getTittle(), contactinfo.getPhone(), contactinfo.getEmail());
		db.updatestage((int)session.getAttribute("applicationID"), 2, "stage");

		return modelAndView;
	}
}

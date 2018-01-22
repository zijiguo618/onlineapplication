package com.example.demo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DB;
import com.example.demo.utilities.Contactinfo;
import com.example.demo.utilities.Login;

@Controller
public class LoginController {
	DB db;
	@GetMapping("/login")
	public ModelAndView greetingForm(Model model,HttpServletRequest request) {
		Login login = new Login();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("login", login);
		modelAndView.setViewName("Login");
//		Basicinfo obj= (Basicinfo)request.getSession().getAttribute("basicinfo");  
//		System.out.println("Basicindo:"+obj.toString());
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView greetingSubmit(@Valid Login Login,BindingResult result,HttpServletRequest request) throws SQLException, ClassNotFoundException {
		ModelAndView modelAndView = new ModelAndView();
		db=new DB();
		modelAndView.setViewName("redirect:/basicinfo");
		HttpSession session = request.getSession();  
		session.setAttribute("Login",Login);  
		
		int applicationid= db.getitemsid(Login.getEmail());
		session.setAttribute("applicationID", applicationid);
		System.out.println(applicationid);
		if (result.hasErrors()) {
			System.out.println("has error");
			return new ModelAndView("redirect:/login");
		}
		int stage=db.getstage("stage", applicationid);
		if(stage==2) {
			return new ModelAndView("redirect:/contactinfo");
		}else if(stage==3) {
			return new ModelAndView("redirect:/products");
		}else if(stage==4) {
			return new ModelAndView("redirect:/settlementaccount");
		}else if(stage==5) {
			return new ModelAndView("redirect:/bankaccount");
		}else if(stage==6) {
			return new ModelAndView("redirect:/uploadMulti");
		}
		
		
		return modelAndView;
	}
}

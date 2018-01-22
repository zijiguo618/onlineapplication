package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.example.demo.utilities.Bankaccount;
import com.example.demo.utilities.Basicinfo;
import com.example.demo.utilities.Settlement;

@Controller
public class BankaccountController {
	private Settlement settlement;
	DB db;
	@GetMapping("/bankaccount")
	public ModelAndView greetingForm( HttpServletRequest request) throws ClassNotFoundException, SQLException {
		ModelAndView model = new ModelAndView();
		 db=new DB();
		HttpSession session = request.getSession();  

		settlement =(Settlement)session.getAttribute("Settlement");
		System.out.println(settlement.toString());
		model.addObject("currencylist", settlement.getcurrensies());

		int applicattionid=(int)session.getAttribute("applicationID");
		model.addObject("bankaccount", new Bankaccount().getbankaccount(applicattionid));
//		System.out.println(settlement.toString());
		model.addObject("applicationID", applicattionid);
		String str= db.getitem("settlemulticurrency", applicattionid);
		List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
		model.addObject("currencylist",items );

		model.setViewName("bankaccount");

		return model;
	}

	@PostMapping("/bankaccount")
	public ModelAndView greetingSubmit(@Valid Bankaccount bankaccount,BindingResult result,HttpServletRequest request,RedirectAttributes redirectAttributes
			) throws SQLException {
		HttpSession session = request.getSession();  
		
		System.out.println(bankaccount.toString());
		if(bankaccount.getRoutingnumber().isEmpty()&&bankaccount.getSwiftcode().isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please enter your Routingnumber or SwiftCode");
			return new ModelAndView("redirect:/bankaccount");
		}
		if(result.hasErrors()) {
			System.out.println("has error");
		
			ModelAndView model =new ModelAndView();
			model.addObject("currencylist", settlement.getcurrensies());
			model.setViewName("/bankaccount");
			return model;
		}
		session.setAttribute("bankaccount",bankaccount); 

		db.update2application_bankacoount((int)session.getAttribute("applicationID"), bankaccount.getCurrency(), bankaccount.getBankaddress_country()+bankaccount.getBankaddress_state()+bankaccount.getBankaddress_city()+bankaccount.getBankaddress_street(), bankaccount.getBankname(), bankaccount.getAccountname(), bankaccount.getAccount(), bankaccount.getSwiftcode(), bankaccount.getRoutingnumber(), bankaccount.getAccounttype());
		db.updatestage((int)session.getAttribute("applicationID"), 5, "stage");

		return new ModelAndView("uploadMulti");
	}
}

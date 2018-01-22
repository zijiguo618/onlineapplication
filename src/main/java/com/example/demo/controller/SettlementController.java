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
import com.example.demo.utilities.Greeting;
import com.example.demo.utilities.Products;
import com.example.demo.utilities.Settlement;

@Controller
public class SettlementController {

	@GetMapping("/settlementaccount")
	public ModelAndView greetingForm( HttpServletRequest request) throws ClassNotFoundException, SQLException {


		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("settlementaccount");

		HttpSession session = request.getSession();  
		int applicationid=(int)session.getAttribute("applicationID");
		modelAndView.addObject("applicationID", applicationid);
		modelAndView.addObject("settlement", new Settlement().getsettlement(applicationid));

//		Products obj=(Products)request.getSession().getAttribute("products");
//		System.out.println(obj.toString());
		return modelAndView;
	}

	@PostMapping("/settlementaccount")
	public ModelAndView greetingSubmit(@Valid Settlement Settlement,BindingResult result,HttpServletRequest request
			,RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException {
		DB db=new DB();
		HttpSession session = request.getSession();  
		session.setAttribute("Settlement",Settlement);  
//		System.out.println(Settlement.toString());
		if(!Settlement.getWithdrawallist().equals("Manually")) {
			if(Settlement.getWithdrawalminimumamount().isEmpty()&&Settlement.getWithdrawalregular().isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select your Withdrawl Way");
				return new ModelAndView("redirect:/settlement");
			}
		}else if(Settlement.getSettlemulticurrency_CAD()==null&&Settlement.getSettlemulticurrency_EUR()==null&&Settlement.getSettlemulticurrency_GBP()==null&&Settlement.getSettlemulticurrency_HKD()==null&&Settlement.getSettlemulticurrency_JPY()==null&&Settlement.getSettlemulticurrency_USD()==null) {
			redirectAttributes.addFlashAttribute("message", "Please select your settlement currency");
			return new ModelAndView("redirect:/settlement");
		}
			if(result.hasErrors()) {
			System.out.println("error");
			return new ModelAndView("settlementaccount");
		}

			System.out.println(Settlement.getcurrensies().toString());
			
			db.update2application_settlement((int)session.getAttribute("applicationID"), Settlement.getcurrensies().toString(), Settlement.getOverdraft(), Settlement.getLending(), Settlement.getWithdrawalminimumamount(), Settlement.getWithdrawalregular(), Settlement.getWithdrawalreserveamount());
			db.updatestage((int)session.getAttribute("applicationID"), 4, "stage");

		return new ModelAndView("redirect:/bankaccount");
	}
}

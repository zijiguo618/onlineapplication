package com.example.demo.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

public class basicindo_industry {
	@ModelAttribute("industrylist")
	public List getlist() {
		List<String> result=new ArrayList<>();
		result.add("Internet / eCommerce");
		result.add("Electronic");
		result.add("Automotive");
		result.add("Education & School");
		result.add("Tourism & travel");
		result.add("Beauty & Health Care");
		result.add("Resturant & Food");
		result.add("Retail");
		result.add("Jewelry");
		result.add("Baby products & Toys");
		result.add("Entertainment, music & games");
		result.add("Sports & Outdoors");
		result.add("Fashion");
		result.add("Professional Services");
		result.add("Business Services");
		result.add("Government Services");
		result.add("Other");
		return result;
	}
}

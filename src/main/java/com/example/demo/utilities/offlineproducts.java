package com.example.demo.utilities;

import org.hibernate.validator.constraints.NotEmpty;

public class offlineproducts {
	@NotEmpty
	private String contactname;
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
}

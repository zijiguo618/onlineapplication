package com.example.demo.utilities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Contactinfo {
	@NotEmpty
	private String contactname;
	@NotEmpty
	private String tittle;
	@NotEmpty
	private String phone;
	@NotEmpty
	@Email
	private String email;
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contactinfo [contactname=" + contactname + ", tittle=" + tittle + ", phone=" + phone + ", email="
				+ email + "]";
	}

}

package com.example.demo.utilities;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Registration {
	@NotEmpty(message = "Please enter your first name.")
	@Size(min = 1, max = 30, message = "Your firstname should between 1 and 30 characters.")
	private String firstname;
	@NotEmpty(message = "Please enter your last name.")
	@Size(min = 1, max = 30, message = "Your last should between 1 and 30 characters.")
	private String lastname;
	@NotEmpty(message = "Please enter your Email address.")
	@Email(message = "Your email address is incorrect.")
	private String email;
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 1, max = 15, message = "Your password should between 6 and 5 characters.")
	private String password;
	@NotEmpty(message = "Please enter your company name.")
	@Size(min = 2, max = 30)
	private String company;
	@NotEmpty(message = "Please re-enter your password for checking.")
	@Size(min = 1, max = 15)
	private String confirmpassword;


	public void setcompany(String company) {
		this.company = company;
	}

	public String getcompany() {
		return company;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
		return password;
	}

	public void setconfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getconfirmpassword() {
		return confirmpassword;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getemail() {
		return email;
	}
	
}

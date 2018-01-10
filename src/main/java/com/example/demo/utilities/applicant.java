package com.example.demo.utilities;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.SessionAttributes;
//@SessionAttributes("applicant")
public class applicant {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String company;
	private String confirmpassword;
	private String merchantname;
	private String merchanlegalname;
	private String merchanturl;
	private String customerservicetel;
	private String merchanttype;
	private String establisheddate;

	// public void set() {
	// this.=;
	// }
	// public String get() {
	// return ;
	// }


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getMerchanlegalname() {
		return merchanlegalname;
	}

	public void setMerchanlegalname(String merchanlegalname) {
		this.merchanlegalname = merchanlegalname;
	}

	public String getMerchanturl() {
		return merchanturl;
	}

	public void setMerchanturl(String merchanturl) {
		this.merchanturl = merchanturl;
	}

	public String getCustomerservicetel() {
		return customerservicetel;
	}

	public void setCustomerservicetel(String customerservicetel) {
		this.customerservicetel = customerservicetel;
	}

	public String getMerchanttype() {
		return merchanttype;
	}

	public void setMerchanttype(String merchanttype) {
		this.merchanttype = merchanttype;
	}

	public String getEstablisheddate() {
		return establisheddate;
	}

	public void setEstablisheddate(String establisheddate) {
		this.establisheddate = establisheddate;
	}

	@Override
	public String toString() {
		return "applicant [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", company=" + company + ", confirmpassword=" + confirmpassword + ", merchantname="
				+ merchantname + ", merchanlegalname=" + merchanlegalname + ", merchanturl=" + merchanturl
				+ ", customerservicetel=" + customerservicetel + ", merchanttype=" + merchanttype + ", establisheddate="
				+ establisheddate + "]";
	}

	
	
}



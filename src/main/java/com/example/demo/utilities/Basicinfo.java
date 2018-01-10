package com.example.demo.utilities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes("applicant")
public class Basicinfo {
	@NotEmpty
	private String merchantname;
	@NotEmpty
	private String merchantlegalname;
	@NotEmpty
	private String merchanturl;
	@NotEmpty
	private String customerservicetel;
	@NotEmpty
	private String merchanttype;
	@NotEmpty
	private String establisheddate;
	@NotEmpty
	private String natureofmerchant;
	@NotEmpty
	private String mcc;
	@NotEmpty
	private String industry;
	@NotEmpty
	private String federaltaxid;
	@NotEmpty
	private String agent;
	@NotEmpty
	private String mailaddress_country;
	private String mailaddress_state;
	private String mailaddress_city;
	private String mailaddress_street;
	private String mailaddress_zipcode;
//	@NotEmpty
	private String phyaddress_country;
	private String phyaddress_state;
	private String phyaddress_city;
	private String phyaddress_street;
	private String phyaddress_zipcode;
//	@NotEmpty
//	private String merchantstorepic;
	

	public String getMailaddress_country() {
		return mailaddress_country;
	}

	public void setMailaddress_country(String mailaddress_country) {
		this.mailaddress_country = mailaddress_country;
	}

	public String getMailaddress_state() {
		return mailaddress_state;
	}

	public void setMailaddress_state(String mailaddress_state) {
		this.mailaddress_state = mailaddress_state;
	}

	public String getMailaddress_city() {
		return mailaddress_city;
	}

	public void setMailaddress_city(String mailaddress_city) {
		this.mailaddress_city = mailaddress_city;
	}

	public String getMailaddress_street() {
		return mailaddress_street;
	}

	public void setMailaddress_street(String mailaddress_street) {
		this.mailaddress_street = mailaddress_street;
	}

	public String getMailaddress_zipcode() {
		return mailaddress_zipcode;
	}

	public void setMailaddress_zipcode(String mailaddress_zipcode) {
		this.mailaddress_zipcode = mailaddress_zipcode;
	}

	public String getPhyaddress_country() {
		return phyaddress_country;
	}

	public void setPhyaddress_country(String phyaddress_country) {
		this.phyaddress_country = phyaddress_country;
	}

	public String getPhyaddress_state() {
		return phyaddress_state;
	}

	public void setPhyaddress_state(String phyaddress_state) {
		this.phyaddress_state = phyaddress_state;
	}

	public String getPhyaddress_city() {
		return phyaddress_city;
	}

	public void setPhyaddress_city(String phyaddress_city) {
		this.phyaddress_city = phyaddress_city;
	}

	public String getPhyaddress_street() {
		return phyaddress_street;
	}

	public void setPhyaddress_street(String phyaddress_street) {
		this.phyaddress_street = phyaddress_street;
	}

	public String getPhyaddress_zipcode() {
		return phyaddress_zipcode;
	}

	public void setPhyaddress_zipcode(String phyaddress_zipcode) {
		this.phyaddress_zipcode = phyaddress_zipcode;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getMerchantlegalname() {
		return merchantlegalname;
	}

	public void setMerchantlegalname(String merchantlegalname) {
		this.merchantlegalname = merchantlegalname;
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

	public String getNatureofmerchant() {
		return natureofmerchant;
	}

	public void setNatureofmerchant(String natureofmerchant) {
		this.natureofmerchant = natureofmerchant;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getFederaltaxid() {
		return federaltaxid;
	}

	public void setFederaltaxid(String federaltaxid) {
		this.federaltaxid = federaltaxid;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
//
//	public String getMerchantstorepic() {
//		return merchantstorepic;
//	}
//
//	public void setMerchantstorepic(String merchantstorepic) {
//		this.merchantstorepic = merchantstorepic;
//	}

	// public void set() {
	// this.=;
	// }
	// public String get() {
	// return ;
	// }
	public void setestablisheddate(String establisheddate) {
		this.establisheddate = establisheddate;
	}

	public String getestablisheddate() {
		return establisheddate;
	}

	public void setmerchanttype(String merchanttype) {
		this.merchanttype = merchanttype;
	}

	public String getmerchanttype() {
		return merchanttype;
	}

	public void setmerchanturl(String merchanturl) {
		this.merchanturl = merchanturl;
	}

	public String getmerchanturl() {
		return merchanturl;
	}

	public void setcustomerservicetel(String customerservicetel) {
		this.customerservicetel = customerservicetel;
	}

	public String getcustomerservicetel() {
		return customerservicetel;
	}

	public void setmerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getmerchantname() {
		return merchantname;
	}

	public void setmerchantlegalname(String merchantlegalname) {
		this.merchantlegalname = merchantlegalname;
			
	}

	public String getmerchantlegalname() {
		return merchantlegalname;
	}
}

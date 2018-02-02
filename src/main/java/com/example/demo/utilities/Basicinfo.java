package com.example.demo.utilities;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.DB;
public class Basicinfo {
	DB db;
	@NotEmpty(message = "Please enter your merchant name.")
	private String name;
	@NotEmpty(message = "Please enter your merchant Leagel name.")
	private String abbreviation;
	@NotEmpty(message = "Please enter your merchant URL.")
	@URL(message = "Your URL should start with http: ")
	private String website;
	@NotEmpty(message = "Please enter your Customer service Telephone number.")
	private String customerservicetel;
	@NotEmpty(message = "Please select your merchant type.")
	private String merchantType;
	@NotEmpty(message = "Please select your merchant established date.")
	private String effectiveDate;
	@NotEmpty(message = "Please select.")
	private String merchantProperty;
	@NotEmpty(message = "Please select MCC.")
	private String mcc;
	@NotEmpty(message = "Please select industry.")
	private String industry;
	@NotEmpty(message = "Please enter your federal tax ID.")
	private String federalID;
	@NotEmpty(message = "Please enter your agent name.")
	private String agentId;
	@NotEmpty(message = "Please select your timezone.")
	private String timeZone;
	@NotEmpty(message = "Please enter your mailaddress.")
	private String countryName;
	private String stateName;
	private String cityName;
	private String countryCode;
	private String stateCode;
	private String cityCode;
	@NotEmpty(message = "Please enter your mailaddress.")
	private String streetName1;
	private String streetName2;
	@NotEmpty(message = "Please enter Contactor.")
	private String contactPerson; // 联系人
	@NotEmpty(message = "Please enter the phone of Contoctor.")
	private String contactPhone; // 联系人电话
	@NotEmpty(message = "Please enter the email of Contoctor.")
	private String contactEmail; // 联系人电子邮箱
	private String comments; // 商户备注信息
	private String branchId;
	private String terminateDate;
	public String getTerminateDate() {
		return terminateDate;
	}


	public void setTerminateDate(String terminateDate) {
		this.terminateDate = terminateDate;
	}


	public String getBranchId() {
		return branchId;
	}


	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}


	public Basicinfo getbasicinfo(int ID) throws ClassNotFoundException, SQLException {
		db=new DB();		
		this.name=db.getitem("merchantname", ID);
		this.abbreviation=db.getitem("merchantlegalname", ID);
		this.website=db.getitem("merchanturl", ID);
		this.customerservicetel=db.getitem("customersertel", ID);
		this.merchantType=db.getitem("type", ID);
		this.effectiveDate=db.getitem("establisheddate", ID);
		this.merchantProperty=db.getitem("nature", ID);
		this.mcc=db.getitem("mcc", ID);
		this.industry=db.getitem("industry", ID);
		this.federalID=db.getitem("federaltaxid", ID);
		this.agentId=db.getitem("agent", ID);
		db.close();
		System.out.println(this.toString());
		return this;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAbbreviation() {
		return abbreviation;
	}


	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getCustomerservicetel() {
		return customerservicetel;
	}


	public void setCustomerservicetel(String customerservicetel) {
		this.customerservicetel = customerservicetel;
	}


	public String getMerchantType() {
		return merchantType;
	}


	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}


	public String getEffectiveDate() {
		return effectiveDate;
	}


	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}


	public String getMerchantProperty() {
		return merchantProperty;
	}


	public void setMerchantProperty(String merchantProperty) {
		this.merchantProperty = merchantProperty;
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


	public String getFederalID() {
		return federalID;
	}


	public void setFederalID(String federalID) {
		this.federalID = federalID;
	}


	public String getAgentId() {
		return agentId;
	}


	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}


	public String getTimeZone() {
		return timeZone;
	}


	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getStreetName1() {
		return streetName1;
	}


	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}


	public String getStreetName2() {
		return streetName2;
	}


	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getContactPhone() {
		return contactPhone;
	}


	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	

}
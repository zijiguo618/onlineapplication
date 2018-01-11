package com.example.demo.utilities;

public class Bankaccount {

//	private String ;
	private String currency;
	private String bankaddress_country;
	private String bankaddress_state;
	private String bankaddress_city;
	private String bankaddress_street;
	private String bankname;
	private String accountname;
	private String account;
	private String swiftcode;
	private String routingnumber;
	
	
	public String getBankaddress_country() {
		return bankaddress_country;
	}
	public void setBankaddress_country(String bankaddress_country) {
		this.bankaddress_country = bankaddress_country;
	}
	public String getBankaddress_state() {
		return bankaddress_state;
	}
	public void setBankaddress_state(String bankaddress_state) {
		this.bankaddress_state = bankaddress_state;
	}
	public String getBankaddress_city() {
		return bankaddress_city;
	}
	public void setBankaddress_city(String bankaddress_city) {
		this.bankaddress_city = bankaddress_city;
	}
	public String getBankaddress_street() {
		return bankaddress_street;
	}
	public void setBankaddress_street(String bankaddress_street) {
		this.bankaddress_street = bankaddress_street;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSwiftcode() {
		return swiftcode;
	}
	public void setSwiftcode(String swiftcode) {
		this.swiftcode = swiftcode;
	}
	public String getRoutingnumber() {
		return routingnumber;
	}
	public void setRoutingnumber(String routingnumber) {
		this.routingnumber = routingnumber;
	}
	@Override
	public String toString() {
		return "Bankaccount [currency=" + currency + ", bankaddress_country=" + bankaddress_country
				+ ", bankaddress_state=" + bankaddress_state + ", bankaddress_city=" + bankaddress_city
				+ ", bankaddress_street=" + bankaddress_street + ", bankname=" + bankname + ", accountname="
				+ accountname + ", account=" + account + ", swiftcode=" + swiftcode + ", routingnumber=" + routingnumber
				+ "]";
	}
	
	
}

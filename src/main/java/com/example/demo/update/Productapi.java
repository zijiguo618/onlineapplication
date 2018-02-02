package com.example.demo.update;

public class Productapi {
private String productName;
private String settleCycle;
private String cardOrgs;
private String currencys;

public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getSettleCycle() {
	return settleCycle;
}
public void setSettleCycle(String settleCycle) {
	this.settleCycle = settleCycle;
}
public String getCardOrgs() {
	return cardOrgs;
}
public void setCardOrgs(String cardOrgs) {
	if(this.cardOrgs!=null) {
		this.cardOrgs +=","+cardOrgs;
	}else {
	this.cardOrgs = cardOrgs;}
}
public String getCurrencys() {
	return currencys;
}
public void setCurrencys(String currencys) {
	if(this.currencys!=null) {
		this.currencys +=","+ currencys;
	}else {
	this.currencys = currencys;
	}
}



}

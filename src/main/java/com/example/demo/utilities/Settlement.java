package com.example.demo.utilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.demo.service.DB;

public class Settlement {
	@NotEmpty(message = "Please enter your reverse amount")
	private String withdrawalreserveamount;
	
	private String withdrawalregular;
	
	private String withdrawalminimumamount;
	
	private String withdrawallist;
	@NotEmpty(message = "Please select lending option")
	private String lending;
	@NotEmpty(message = "Please select overdraft option")
	private String overdraft;
	
	private String settlemulticurrency_USD;
	private String settlemulticurrency_HKD;
	private String settlemulticurrency_EUR;
	private String settlemulticurrency_JPY;
	private String settlemulticurrency_GBP;
	private String settlemulticurrency_CAD;
	
	
	public Settlement getsettlement(int ID) throws ClassNotFoundException, SQLException {
		DB db=new DB();
//		settlemulticurrency=?, overdraft=?,lending=?,withdrawalminimumamount=?,withdrawalregular=?,withdrawalreserveamount
		this.overdraft=db.getitem("overdraft", ID);
		this.lending=db.getitem("lending", ID);
		this.withdrawalminimumamount=db.getitem("withdrawalminimumamount", ID);
		this.withdrawalregular=db.getitem("withdrawalregular", ID);
		this.withdrawalreserveamount=db.getitem("withdrawalreserveamount", ID);
		db.close();
		return this;
		
		
	}
	
	
//	private String singlecurrency;
	@Override
	public String toString() {
		return "Settlement [withdrawalreserveamount=" + withdrawalreserveamount + ", withdrawalregular="
				+ withdrawalregular + ", withdrawalminimumamount=" + withdrawalminimumamount + ", withdrawallist="
				+ withdrawallist + ", lending=" + lending + ", overdraft=" + overdraft + ", settlemulticurrency_USD="
				+ settlemulticurrency_USD + ", settlemulticurrency_HKD=" + settlemulticurrency_HKD
				+ ", settlemulticurrency_EUR=" + settlemulticurrency_EUR + ", settlemulticurrency_JPY="
				+ settlemulticurrency_JPY + ", settlemulticurrency_GBP=" + settlemulticurrency_GBP
				+ ", settlemulticurrency_CAD=" + settlemulticurrency_CAD +  "]";
	}
	
	
	public List<String> getcurrensies(){
		List<String> currensielist = new ArrayList<String>();
		if(settlemulticurrency_USD!=null) {
			currensielist.add(settlemulticurrency_USD);
		}
		if(settlemulticurrency_HKD!=null) {
			currensielist.add(settlemulticurrency_HKD);
		}
		if(settlemulticurrency_EUR!=null) {
			currensielist.add(settlemulticurrency_EUR);
		}
		if(settlemulticurrency_JPY!=null) {
			currensielist.add(settlemulticurrency_JPY);
		}
		if(settlemulticurrency_GBP!=null) {
			currensielist.add(settlemulticurrency_GBP);
		}
		if(settlemulticurrency_CAD!=null) {
			currensielist.add(settlemulticurrency_CAD);
		}
		
		return currensielist;
	}
	
	public String getWithdrawalreserveamount() {
		return withdrawalreserveamount;
	}
	public void setWithdrawalreserveamount(String withdrawalreserveamount) {
		this.withdrawalreserveamount = withdrawalreserveamount;
	}
	public String getWithdrawalregular() {
		return withdrawalregular;
	}
	public void setWithdrawalregular(String withdrawalregular) {
		this.withdrawalregular = withdrawalregular;
	}
	public String getWithdrawalminimumamount() {
		return withdrawalminimumamount;
	}
	public void setWithdrawalminimumamount(String withdrawalminimumamount) {
		this.withdrawalminimumamount = withdrawalminimumamount;
	}
	public String getWithdrawallist() {
		return withdrawallist;
	}
	public void setWithdrawallist(String withdrawallist) {
		this.withdrawallist = withdrawallist;
	}
	public String getLending() {
		return lending;
	}
	public void setLending(String lending) {
		this.lending = lending;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	public String getSettlemulticurrency_USD() {
		return settlemulticurrency_USD;
	}
	public void setSettlemulticurrency_USD(String settlemulticurrency_USD) {
		this.settlemulticurrency_USD = settlemulticurrency_USD;
	}
	public String getSettlemulticurrency_HKD() {
		return settlemulticurrency_HKD;
	}
	public void setSettlemulticurrency_HKD(String settlemulticurrency_HKD) {
		this.settlemulticurrency_HKD = settlemulticurrency_HKD;
	}
	public String getSettlemulticurrency_EUR() {
		return settlemulticurrency_EUR;
	}
	public void setSettlemulticurrency_EUR(String settlemulticurrency_EUR) {
		this.settlemulticurrency_EUR = settlemulticurrency_EUR;
	}
	public String getSettlemulticurrency_JPY() {
		return settlemulticurrency_JPY;
	}
	public void setSettlemulticurrency_JPY(String settlemulticurrency_JPY) {
		this.settlemulticurrency_JPY = settlemulticurrency_JPY;
	}
	public String getSettlemulticurrency_GBP() {
		return settlemulticurrency_GBP;
	}
	public void setSettlemulticurrency_GBP(String settlemulticurrency_GBP) {
		this.settlemulticurrency_GBP = settlemulticurrency_GBP;
	}
	public String getSettlemulticurrency_CAD() {
		return settlemulticurrency_CAD;
	}
	public void setSettlemulticurrency_CAD(String settlemulticurrency_CAD) {
		this.settlemulticurrency_CAD = settlemulticurrency_CAD;
	}
//	public String getSinglecurrency() {
//		return singlecurrency;
//	}
//	public void setSinglecurrency(String singlecurrency) {
//		this.singlecurrency = singlecurrency;
//	}

}

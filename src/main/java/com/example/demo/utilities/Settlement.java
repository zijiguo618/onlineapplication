package com.example.demo.utilities;

public class Settlement {
	private String withdrawalreserveamount;
	private String withdrawalregular;
	private String withdrawalminimumamount;
	private String withdrawallist;
	private String lending;
	private String overdraft;
	private String settlemulticurrency_USD;
	private String settlemulticurrency_HKD;
	private String settlemulticurrency_EUR;
	private String settlemulticurrency_JPY;
	@Override
	public String toString() {
		return "Settlement [withdrawalreserveamount=" + withdrawalreserveamount + ", withdrawalregular="
				+ withdrawalregular + ", withdrawalminimumamount=" + withdrawalminimumamount + ", withdrawallist="
				+ withdrawallist + ", lending=" + lending + ", overdraft=" + overdraft + ", settlemulticurrency_USD="
				+ settlemulticurrency_USD + ", settlemulticurrency_HKD=" + settlemulticurrency_HKD
				+ ", settlemulticurrency_EUR=" + settlemulticurrency_EUR + ", settlemulticurrency_JPY="
				+ settlemulticurrency_JPY + ", settlemulticurrency_GBP=" + settlemulticurrency_GBP
				+ ", settlemulticurrency_CAD=" + settlemulticurrency_CAD + ", singlecurrency=" + singlecurrency + "]";
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
	public String getSinglecurrency() {
		return singlecurrency;
	}
	public void setSinglecurrency(String singlecurrency) {
		this.singlecurrency = singlecurrency;
	}
	private String settlemulticurrency_GBP;
	private String settlemulticurrency_CAD;
	private String singlecurrency;
}

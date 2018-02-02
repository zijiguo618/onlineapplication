package com.example.demo.utilities;

import java.sql.SQLException;

import org.json.JSONObject;

import com.example.demo.service.DB;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Products {
	//UP_EBANK_PAY
	private String securepay_unionpay;
	private String securepay_wechatpay;
	private String securepay_alipay;
	private String securepaycurrency_USD;
	private String securepaycurrency_JPY;
	private String securepaycurrency_HKD;
	private String securepaycurrency_EUR;
	private String securepaycurrency_GBP;
	private String securepaycurrency_CAD;

	private String expresspay_unionpay;
	private String expresspaycurrency_USD;
	private String expresspaycurrency_JPY;
	private String expresspaycurrency_HKD;
	private String expresspaycurrency_EUR;
	private String expresspaycurrency_GBP;
	private String expresspaycurrency_CAD;

	private String showqrcode_alipay;
	private String showqrcode_wechatpay;
	private String showqrcodecurrency_USD;
	private String showqrcodecurrency_JPY;
	private String showqrcodecurrency_HKD;
	private String showqrcodecurrency_EUR;
	private String showqrcodecurrency_GBP;
	private String showqrcodecurrency_CAD;
	
	private String POS_alipay;
	private String POS_wechatpay;
	private String POS_unionpay;
	private String POScurrency_USD;
	private String POScurrency_JPY;
	private String POScurrency_HKD;
	private String POScurrency_EUR;
	private String POScurrency_GBP;
	private String POScurrency_CAD;
	
	private String expresspay_settlement;
	private String securepay_settlement;
	private String showqrcode_settlement;
	private String POS_settlement;
	private String easypay;
	
	public Products getproduct(int ID) throws ClassNotFoundException, SQLException {
		DB db = new DB();
		this.securepay_unionpay=db.getitem("securepay_unionpay", ID);
		this.securepay_wechatpay=db.getitem("securepay_wechatpay", ID);
		this.securepay_alipay=db.getitem("securepay_alipay", ID);
		this.securepaycurrency_USD=db.getitem("securepaycurrency_USD", ID);
		this.securepaycurrency_JPY=db.getitem("securepaycurrency_JPY", ID);
		this.securepaycurrency_HKD=db.getitem("securepaycurrency_HKD", ID);
		this.securepaycurrency_EUR=db.getitem("securepaycurrency_EUR",ID);
		this.securepaycurrency_GBP=db.getitem("securepaycurrency_GBP", ID);
		this.securepaycurrency_CAD=db.getitem("securepaycurrency_CAD", ID);

		this.expresspay_unionpay=db.getitem("expresspay_unionpay", ID);
		this.expresspaycurrency_USD=db.getitem("expresspaycurrency_USD", ID);
		this.expresspaycurrency_JPY=db.getitem("expresspaycurrency_JPY", ID);
		this.expresspaycurrency_HKD=db.getitem("expresspaycurrency_HKD", ID);
		this.expresspaycurrency_EUR=db.getitem("expresspaycurrency_EUR", ID);
		this.expresspaycurrency_GBP=db.getitem("expresspaycurrency_GBP", ID);
		this.expresspaycurrency_CAD=db.getitem("expresspaycurrency_CAD", ID);

		this.showqrcode_alipay=db.getitem("showqrcode_alipay", ID);
		this.showqrcode_wechatpay=db.getitem("showqrcode_wechatpay", ID);
		this.showqrcodecurrency_USD=db.getitem("showqrcodecurrency_USD", ID);
		this.showqrcodecurrency_JPY=db.getitem("showqrcodecurrency_JPY", ID);
		this.showqrcodecurrency_HKD=db.getitem("showqrcodecurrency_HKD", ID);
		this.showqrcodecurrency_EUR=db.getitem("showqrcodecurrency_EUR", ID);
		this.showqrcodecurrency_GBP=db.getitem("showqrcodecurrency_GBP", ID);
		this.showqrcodecurrency_CAD=db.getitem("showqrcodecurrency_CAD", ID);
		
		this.POS_alipay=db.getitem("POS_alipay", ID);
		this.POS_wechatpay=db.getitem("POS_wechatpay", ID);
		this.POS_unionpay=db.getitem("POS_unionpay", ID);
		this.POScurrency_USD=db.getitem("POScurrency_USD", ID);
		this.POScurrency_JPY=db.getitem("POScurrency_JPY", ID);
		this.POScurrency_HKD=db.getitem("POScurrency_HKD", ID);
		this.POScurrency_EUR=db.getitem("POScurrency_EUR", ID);
		this.POScurrency_GBP=db.getitem("POScurrency_GBP", ID);
		this.POScurrency_CAD=db.getitem("POScurrency_CAD", ID);
		
		this.expresspay_settlement=db.getitem("expresspay_settlement", ID);
		this.securepay_settlement=db.getitem("securepay_settlement", ID);
		this.showqrcode_settlement=db.getitem("showqrcode_settlement", ID);
		this.POS_settlement=db.getitem("POS_settlement", ID);
		this.easypay=db.getitem("easypay", ID);
		db.close();
		return this;
		
	}
	
	
	
	public String getExpresspay_settlement() {
		return expresspay_settlement;
	}
	public void setExpresspay_settlement(String expresspay_settlement) {
		this.expresspay_settlement = expresspay_settlement;
	}
	public String getSecurepay_settlement() {
		return securepay_settlement;
	}
	public void setSecurepay_settlement(String securepay_settlement) {
		this.securepay_settlement = securepay_settlement;
	}
	public String getShowqrcode_settlement() {
		return showqrcode_settlement;
	}
	public void setShowqrcode_settlement(String showqrcode_settlement) {
		this.showqrcode_settlement = showqrcode_settlement;
	}
	public String getPOS_settlement() {
		return POS_settlement;
	}
	public void setPOS_settlement(String pOS_settlement) {
		POS_settlement = pOS_settlement;
	}


	public String getSecurepay_unionpay() {
		return securepay_unionpay;
	}
	public void setSecurepay_unionpay(String securepay_unionpay) {
		this.securepay_unionpay = securepay_unionpay;
	}
	public String getSecurepay_wechatpay() {
		return securepay_wechatpay;
	}
	public void setSecurepay_wechatpay(String securepay_wechatpay) {
		this.securepay_wechatpay = securepay_wechatpay;
	}
	public String getSecurepay_alipay() {
		return securepay_alipay;
	}
	public void setSecurepay_alipay(String securepay_alipay) {
		this.securepay_alipay = securepay_alipay;
	}
	public String getSecurepaycurrency_USD() {
		return securepaycurrency_USD;
	}
	public void setSecurepaycurrency_USD(String securepaycurrency_USD) {
		this.securepaycurrency_USD = securepaycurrency_USD;
	}
	public String getSecurepaycurrency_JPY() {
		return securepaycurrency_JPY;
	}
	public void setSecurepaycurrency_JPY(String securepaycurrency_JPY) {
		this.securepaycurrency_JPY = securepaycurrency_JPY;
	}
	public String getSecurepaycurrency_HKD() {
		return securepaycurrency_HKD;
	}
	public void setSecurepaycurrency_HKD(String securepaycurrency_HKD) {
		this.securepaycurrency_HKD = securepaycurrency_HKD;
	}
	public String getSecurepaycurrency_EUR() {
		return securepaycurrency_EUR;
	}
	public void setSecurepaycurrency_EUR(String securepaycurrency_EUR) {
		this.securepaycurrency_EUR = securepaycurrency_EUR;
	}
	public String getSecurepaycurrency_GBP() {
		return securepaycurrency_GBP;
	}
	public void setSecurepaycurrency_GBP(String securepaycurrency_GBP) {
		this.securepaycurrency_GBP = securepaycurrency_GBP;
	}
	public String getSecurepaycurrency_CAD() {
		return securepaycurrency_CAD;
	}
	public void setSecurepaycurrency_CAD(String securepaycurrency_CAD) {
		this.securepaycurrency_CAD = securepaycurrency_CAD;
	}

	public String getExpresspay_unionpay() {
		return expresspay_unionpay;
	}
	public void setExpresspay_unionpay(String expresspay_unionpay) {
		this.expresspay_unionpay = expresspay_unionpay;
	}
	public String getExpresspaycurrency_USD() {
		return expresspaycurrency_USD;
	}
	public void setExpresspaycurrency_USD(String expresspaycurrency_USD) {
		this.expresspaycurrency_USD = expresspaycurrency_USD;
	}
	public String getExpresspaycurrency_JPY() {
		return expresspaycurrency_JPY;
	}
	public void setExpresspaycurrency_JPY(String expresspaycurrency_JPY) {
		this.expresspaycurrency_JPY = expresspaycurrency_JPY;
	}
	public String getExpresspaycurrency_HKD() {
		return expresspaycurrency_HKD;
	}
	public void setExpresspaycurrency_HKD(String expresspaycurrency_HKD) {
		this.expresspaycurrency_HKD = expresspaycurrency_HKD;
	}
	public String getExpresspaycurrency_EUR() {
		return expresspaycurrency_EUR;
	}
	public void setExpresspaycurrency_EUR(String expresspaycurrency_EUR) {
		this.expresspaycurrency_EUR = expresspaycurrency_EUR;
	}
	public String getExpresspaycurrency_GBP() {
		return expresspaycurrency_GBP;
	}
	public void setExpresspaycurrency_GBP(String expresspaycurrency_GBP) {
		this.expresspaycurrency_GBP = expresspaycurrency_GBP;
	}
	public String getExpresspaycurrency_CAD() {
		return expresspaycurrency_CAD;
	}
	public void setExpresspaycurrency_CAD(String expresspaycurrency_CAD) {
		this.expresspaycurrency_CAD = expresspaycurrency_CAD;
	}

	public String getShowqrcode_alipay() {
		return showqrcode_alipay;
	}
	public void setShowqrcode_alipay(String showqrcode_alipay) {
		this.showqrcode_alipay = showqrcode_alipay;
	}
	public String getShowqrcode_wechatpay() {
		return showqrcode_wechatpay;
	}
	public void setShowqrcode_wechatpay(String showqrcode_wechatpay) {
		this.showqrcode_wechatpay = showqrcode_wechatpay;
	}
	public String getShowqrcodecurrency_USD() {
		return showqrcodecurrency_USD;
	}
	public void setShowqrcodecurrency_USD(String showqrcodecurrency_USD) {
		this.showqrcodecurrency_USD = showqrcodecurrency_USD;
	}
	public String getShowqrcodecurrency_JPY() {
		return showqrcodecurrency_JPY;
	}
	public void setShowqrcodecurrency_JPY(String showqrcodecurrency_JPY) {
		this.showqrcodecurrency_JPY = showqrcodecurrency_JPY;
	}
	public String getShowqrcodecurrency_HKD() {
		return showqrcodecurrency_HKD;
	}
	public void setShowqrcodecurrency_HKD(String showqrcodecurrency_HKD) {
		this.showqrcodecurrency_HKD = showqrcodecurrency_HKD;
	}
	public String getShowqrcodecurrency_EUR() {
		return showqrcodecurrency_EUR;
	}
	public void setShowqrcodecurrency_EUR(String showqrcodecurrency_EUR) {
		this.showqrcodecurrency_EUR = showqrcodecurrency_EUR;
	}
	public String getShowqrcodecurrency_GBP() {
		return showqrcodecurrency_GBP;
	}
	public void setShowqrcodecurrency_GBP(String showqrcodecurrency_GBP) {
		this.showqrcodecurrency_GBP = showqrcodecurrency_GBP;
	}
	public String getShowqrcodecurrency_CAD() {
		return showqrcodecurrency_CAD;
	}
	public void setShowqrcodecurrency_CAD(String showqrcodecurrency_CAD) {
		this.showqrcodecurrency_CAD = showqrcodecurrency_CAD;
	}

	public String getPOS_alipay() {
		return POS_alipay;
	}
	public void setPOS_alipay(String pOS_alipay) {
		POS_alipay = pOS_alipay;
	}
	public String getPOS_wechatpay() {
		return POS_wechatpay;
	}
	public void setPOS_wechatpay(String pOS_wechatpay) {
		POS_wechatpay = pOS_wechatpay;
	}
	public String getPOS_unionpay() {
		return POS_unionpay;
	}
	public void setPOS_unionpay(String pOS_unionpay) {
		POS_unionpay = pOS_unionpay;
	}
	public String getPOScurrency_USD() {
		return POScurrency_USD;
	}
	public void setPOScurrency_USD(String pOScurrency_USD) {
		POScurrency_USD = pOScurrency_USD;
	}
	public String getPOScurrency_JPY() {
		return POScurrency_JPY;
	}
	public void setPOScurrency_JPY(String pOScurrency_JPY) {
		POScurrency_JPY = pOScurrency_JPY;
	}
	public String getPOScurrency_HKD() {
		return POScurrency_HKD;
	}
	public void setPOScurrency_HKD(String pOScurrency_HKD) {
		POScurrency_HKD = pOScurrency_HKD;
	}
	public String getPOScurrency_EUR() {
		return POScurrency_EUR;
	}
	public void setPOScurrency_EUR(String pOScurrency_EUR) {
		POScurrency_EUR = pOScurrency_EUR;
	}
	public String getPOScurrency_GBP() {
		return POScurrency_GBP;
	}
	public void setPOScurrency_GBP(String pOScurrency_GBP) {
		POScurrency_GBP = pOScurrency_GBP;
	}
	public String getPOScurrency_CAD() {
		return POScurrency_CAD;
	}
	public void setPOScurrency_CAD(String pOScurrency_CAD) {
		POScurrency_CAD = pOScurrency_CAD;
	}
	public String getEasypay() {
		return easypay;
	}
	public void setEasypay(String easypay) {
		this.easypay = easypay;
	}
	@Override
	public String toString() {
		return "Products [securepay_unionpay=" + securepay_unionpay + ", securepay_wechatpay=" + securepay_wechatpay
				+ ", securepay_alipay=" + securepay_alipay + ", securepaycurrency_USD=" + securepaycurrency_USD
				+ ", securepaycurrency_JPY=" + securepaycurrency_JPY + ", securepaycurrency_HKD="
				+ securepaycurrency_HKD + ", securepaycurrency_EUR=" + securepaycurrency_EUR
				+ ", securepaycurrency_GBP=" + securepaycurrency_GBP + ", securepaycurrency_CAD="
				+ securepaycurrency_CAD + ", expresspay_unionpay=" + expresspay_unionpay + ", expresspaycurrency_USD="
				+ expresspaycurrency_USD + ", expresspaycurrency_JPY=" + expresspaycurrency_JPY
				+ ", expresspaycurrency_HKD=" + expresspaycurrency_HKD + ", expresspaycurrency_EUR="
				+ expresspaycurrency_EUR + ", expresspaycurrency_GBP=" + expresspaycurrency_GBP
				+ ", expresspaycurrency_CAD=" + expresspaycurrency_CAD + ", showqrcode_alipay=" + showqrcode_alipay
				+ ", showqrcode_wechatpay=" + showqrcode_wechatpay + ", showqrcodecurrency_USD="
				+ showqrcodecurrency_USD + ", showqrcodecurrency_JPY=" + showqrcodecurrency_JPY
				+ ", showqrcodecurrency_HKD=" + showqrcodecurrency_HKD + ", showqrcodecurrency_EUR="
				+ showqrcodecurrency_EUR + ", showqrcodecurrency_GBP=" + showqrcodecurrency_GBP
				+ ", showqrcodecurrency_CAD=" + showqrcodecurrency_CAD + ", POS_alipay=" + POS_alipay
				+ ", POS_wechatpay=" + POS_wechatpay + ", POS_unionpay=" + POS_unionpay + ", POScurrency_USD="
				+ POScurrency_USD + ", POScurrency_JPY=" + POScurrency_JPY + ", POScurrency_HKD=" + POScurrency_HKD
				+ ", POScurrency_EUR=" + POScurrency_EUR + ", POScurrency_GBP=" + POScurrency_GBP + ", POScurrency_CAD="
				+ POScurrency_CAD + ", expresspay_settlement=" + expresspay_settlement + ", securepay_settlement="
				+ securepay_settlement + ", showqrcode_settlement=" + showqrcode_settlement + ", POS_settlement="
				+ POS_settlement + ", easypay=" + easypay + "]";
	}


	public boolean checkstatus() {
				return securepaycurrency_USD==null&& securepaycurrency_JPY==null&&securepaycurrency_HKD==null&&securepaycurrency_EUR==null&&securepaycurrency_GBP==null&&securepaycurrency_CAD==null&& expresspaycurrency_USD==null&& expresspaycurrency_JPY==null&&expresspaycurrency_HKD==null&&expresspaycurrency_EUR==null&&expresspaycurrency_GBP==null&&expresspaycurrency_CAD==null&&
				showqrcodecurrency_USD ==null&&showqrcodecurrency_JPY==null&&showqrcodecurrency_HKD==null&&showqrcodecurrency_EUR ==null&&showqrcodecurrency_GBP==null&&showqrcodecurrency_CAD ==null&&
				POScurrency_USD ==null&&POScurrency_JPY==null&&POScurrency_HKD==null&&POScurrency_EUR==null&&POScurrency_GBP==null&&POScurrency_CAD ==null;
	}
}

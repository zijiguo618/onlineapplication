package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

import org.springframework.web.servlet.ModelAndView;

public class DB {
	String myDriver = "com.mysql.jdbc.Driver";
	String myUrl = "jdbc:mysql://127.0.0.1:3306/onlineapplication?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8";
	Connection conn;

	public DB() throws SQLException, ClassNotFoundException{
			Class.forName(myDriver);
		 conn = DriverManager.getConnection(myUrl, "root", "password");
		
	}

	public int getstage( String col, int ID) throws SQLException{
		Statement st = conn.createStatement();
		st.executeQuery("SELECT "+col+" FROM application where ID= "+ID); 
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
		   return  rs.getInt(1);
		}
		return -1;
	}
	public String getitem( String col, int ID) throws SQLException{
		Statement st = conn.createStatement();
		st.executeQuery("SELECT "+col+" FROM application where ID= "+ID); 
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
		   return  rs.getString(1);
		}
		return null;
	}
	
	
	public int getitemsid( String col) throws SQLException{
		Statement st = conn.createStatement();
		System.out.println("DB--------");
		st.executeQuery("SELECT ID FROM application where logemail= '"+col+"'"); 
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
		   return  rs.getInt(1);
		}
		return -1;
	}
	
	public int update(int id, String value, String col) throws SQLException{
		String sql = " update application set "+ col+" = '"+value + "' where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	public int updatestage(int id, int value, String col) throws SQLException{
		
		if(this.getstage("stage", id)<value) {
			return 0;
		}
		String sql = " update application set "+ col+" = '"+value + "' where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	public int insert2application(String target, String str) {

		String sql = "insert into application ("+ target+") value ('"+str+"');";
		PreparedStatement st;
		try {
			st = (PreparedStatement) conn.prepareStatement(sql);
			return st.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int insert2registration(String email, String password,String firstname, String lastname,String company) {

		String sql = "insert into application (logemail,loginpass,firstname,lastname,company) value ('"+email+"','"+password+"','"+firstname+"','"+lastname+"','"+company+"');";
		PreparedStatement st;
		try {
			st = (PreparedStatement) conn.prepareStatement(sql);
			return st.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int update2application(int id, String value, String col) throws SQLException{
		String sql = " update application set "+ col+" = '"+value + "' where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	public int update2application_basic(int id, String merchantname, String merchantlegalname,String merchanturl,String customersertel,String type,String establisheddate,String nature,String mcc,String industry,String federaltaxid,String agent,String physicaladdress, String mailaddress) throws SQLException{
		String sql = " update onlineapplication.application set merchantname=?, merchantlegalname=?,merchanturl=?,customersertel=?,type=?,establisheddate=?,nature=?,mcc=?,industry=?,federaltaxid=?,agent=?,physicaladdress=?,mailaddress=? where ID ="+id;
		System.out.println("update basicinfo");
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,merchantname);
		st.setString(2,merchantlegalname);
		st.setString(3,merchanturl);
		st.setString(4,customersertel);
		st.setString(5,type);
		st.setString(6,establisheddate);
		st.setString(7,nature);
		st.setString(8,mcc);
		st.setString(9,industry);
		st.setString(10,federaltaxid);
		st.setString(11,agent);
		st.setString(12,physicaladdress);
		st.setString(13,mailaddress);
		int updateEXP_done = st.executeUpdate();
	
		st.closeOnCompletion();
		System.out.println(updateEXP_done+" "+	st.toString());
		return updateEXP_done;
	}
	public int update2application_contact(int id, String contactname, String tittle,String phone,String contactemail) throws SQLException{
		String sql = " update onlineapplication.application set contactname=?, tittle=?,phone=?,contactemail=? where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,contactname);
		st.setString(2,tittle);
		st.setString(3,phone);
		st.setString(4,contactemail);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	
	public int update2application_settlement(int id, String settlemulticurrency, String overdraft,String lending,String withdrawalminimumamount,String withdrawalregular,String withdrawalreserveamount) throws SQLException{
		String sql = " update application set settlemulticurrency=?, overdraft=?,lending=?,withdrawalminimumamount=?,withdrawalregular=?,withdrawalreserveamount=? where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,settlemulticurrency);
		st.setString(2,overdraft);
		st.setString(3,lending);
		st.setString(4,withdrawalminimumamount);
		st.setString(5,withdrawalregular);
		st.setString(6,withdrawalreserveamount);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	public int update2application_bankacoount(int id, String bankcurrency, String bankaddress,String bankname,String bankaccountname,String bankaccountnumber,String swiftcode,String routingnumber,String accounttype) throws SQLException{
		String sql = " update application set bankcurrency=?, bankaddress=?,bankname=?,bankaccountname=?,bankaccountnumber=?,swiftcode=?,routingnumber=?,accounttype=? where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,bankcurrency);
		st.setString(2,bankaddress);
		st.setString(3,bankname);
		st.setString(4,bankaccountname);
		st.setString(5,bankaccountnumber);
		st.setString(6,swiftcode);
		st.setString(7,routingnumber);
		st.setString(8,accounttype);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	
	
	public int update2application_fileload(int id, String businessfile, String issuedid,String voidedcheck,String bankstatement,String storepic) throws SQLException{
		String sql = " update application set businessfile=?, issuedid=?,voidedcheck=?,bankstatement=?,storepic=? where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,businessfile);
		st.setString(2,issuedid);
		st.setString(3,voidedcheck);
		st.setString(4,bankstatement);
		st.setString(5,storepic);
	
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	
	
	public int update2application_submission(int id, String signature, String currentdate) throws SQLException{
		String sql = " update application set signature=?, currentdate=? where ID ="+id;
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,signature);
		st.setString(2,currentdate);
	
	
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	
	
	public int update2application_product(int id, String gateway, String USD,String JPY,String HKD, String EUR, String GBP, String CAD,String settlement) throws SQLException{
		String sql = "";
		
		if(gateway.equals("expresspay")) {
			sql = " update application set expresspaycurrency_USD=?, expresspaycurrency_JPY=?,expresspaycurrency_HKD=?,expresspaycurrency_EUR=?,expresspaycurrency_GBP=?,expresspaycurrency_CAD=?,expresspay_settlement=? where ID ="+id;
		}else if(gateway.equals("POS")) {
			sql = " update application set POScurrency_USD=?, POScurrency_JPY=?,POScurrency_HKD=?,POScurrency_EUR=?,POScurrency_GBP=?,POScurrency_CAD=?,POS_settlement=? where ID ="+id;
		}else if(gateway.equals("securepay")) {
			sql = " update application set securepaycurrency_USD=?, securepaycurrency_JPY=?,securepaycurrency_HKD=?,securepaycurrency_EUR=?,securepaycurrency_GBP=?,securepaycurrency_CAD=?,securepay_settlement=? where ID ="+id;
		}else if(gateway.equals("showqrcode")) {
			sql = " update application set showqrcodecurrency_USD=?, showqrcodecurrency_JPY=?,showqrcodecurrency_HKD=?,showqrcodecurrency_EUR=?,showqrcodecurrency_GBP=?,showqrcodecurrency_CAD=?,showqrcode_settlement=? where ID ="+id;
		}
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		st.setString(1,USD);		
		st.setString(2,JPY);		
		st.setString(3,HKD);		
		st.setString(4,EUR);		
		st.setString(5,GBP);		
		st.setString(6,CAD);
		st.setString(7,settlement);
		int updateEXP_done = st.executeUpdate();
		st.closeOnCompletion();
		return updateEXP_done;
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public String delete(int id, String html, String AC) throws SQLException{
//		
//	}
//	public String select(int id, String html, String AC) throws SQLException{
//		
//	}
	
	
}

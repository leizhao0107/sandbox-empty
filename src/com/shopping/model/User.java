package com.shopping.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.util.DB;

public class User {
		private int id;
		private String username;
		private String password;
		private String phone;
		private String addr;
		//private Date rdate;
		public User(){};
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
	
		public User(String username,String password,String phone,String addr){
			this.username = username;
			this.password = password;
			this.phone = phone;
			this.addr = addr;
			
	
		}
		public void save(){
			Connection conn = null;
			PreparedStatement pstmt = null;
		    try {
		    	
				conn = DB.getConn();
				String sql = "insert into user values (null,?,?,?,?)";
				pstmt = DB.getPStmt(conn, sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, phone);
				pstmt.setString(4, addr);
				
				pstmt.executeUpdate();
				System.out.println(password);
			
		    } catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				DB.closeStmt(pstmt);
				DB.closeConn(conn);
			}
		}
		
		
}

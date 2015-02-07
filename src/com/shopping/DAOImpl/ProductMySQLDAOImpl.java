package com.shopping.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.DAO.ProductDAO;
import com.shopping.model.Product;
import com.shopping.util.DB;

public class ProductMySQLDAOImpl implements ProductDAO{
	
	public List<Product> getProducts(){
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DB.getConn();
			String sql = "select * from product";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setCategoryid(rs.getInt("categoryid"));
				products.add(p);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeStmt(stmt);
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		
		return products;
	}

	public int getProducts(List<Product> products,int pageNo, int pageSize){
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		int pageCount = 0;
		Statement stmt = null;
	//	Statement stmtCount = null;
		try {
			conn = DB.getConn();
			String sql = "select * from product limit " + (pageNo-1)*pageSize + "," + pageSize;
			//String sql="select * from product limit " + (pageNo-1)*pageSize + "," + pageSize;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setCategoryid(rs.getInt("categoryid"));
				products.add(p);
				}
			//stmtCount = conn.createStatement();
			//rsCount = stmtCount.executeQuery("select count(*) from product");
			rsCount =DB.executeQuery(conn, "select count(*) from product");
			
			rsCount.next();
			pageCount = (rsCount.getInt(1)+pageSize - 1)/pageSize;
			
			//int temp = rsCount.getInt(1);
			//pageCount = temp % pageSize == 0 ? temp/pageSize : temp/pageSize + 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeStmt(stmt);
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		
		return pageCount;
		
	
	
	}
	/*
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		int totalPages = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from product limit " + (pageNo-1)*pageSize + "," + pageSize;
		
		try {
			conn = DB.getConn();
			rs = DB.executeQuery(conn, sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalPrice"));
				p.setMemberprice(rs.getDouble("memberPrice"));
				p.setCategoryid(rs.getInt("categoryId"));
				products.add(p);
			}
			stmt = conn.createStatement();
			ResultSet rsCount = DB.executeQuery(stmt, "select count(*) from product");
			rsCount.next();
			int temp = rsCount.getInt(1);
			totalPages = temp % pageSize == 0 ? temp/pageSize : temp/pageSize + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return totalPages;
	
	
	}*/
	public List<Product> findProducts(int[] categoryId,
									  String name,
									  String descr,
									  double lownormalprice,
									  double highnormalprice,
									  double lowmemberprice,
									  double highmemberprice,
									 
									  int pageNo,
									  int pageSize){
		return null;
	}
	public List<Product> findProducts(String name){
		return null;
	}
	
	public boolean deleteProductByCategoryId(int categoryId){
		return false;
	}
	
	public boolean deleteProductsById(int idArray){
		return false;
	}
	
	public boolean updateProduct(Product p){
		return false;
	}
	
	public boolean addProduct(Product p){
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		try {
			conn =DB.getConn();
			String sql = "insert into Product value(null,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescr());
			pstmt.setDouble(3, p.getNormalprice());
			pstmt.setDouble(4, p.getMemberprice());
			pstmt.setInt(5, p.getCategoryid());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		
		}finally{
			DB.closePstmt(pstmt);
			DB.closeConn(conn);
		}
		return true;
	}

}

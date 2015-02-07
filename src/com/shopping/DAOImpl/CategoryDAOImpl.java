	package com.shopping.DAOImpl;

import com.shopping.DAO.CategoryDAO;
import com.shopping.model.Category;
import com.shopping.util.DB;

import java.sql.*;
import java.util.List;


public class CategoryDAOImpl implements CategoryDAO{
	
	
		/* (non-Javadoc)
		 * @see com.shopping.DAOImpl.CategoryDAO#save(com.shopping.model.Category)
		 */
		
		public static void save(Category c){
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DB.getConn();
				String sql = "";
				if(c.getId()==-1){
				 sql = "insert into Category value (null,?,?,?,?,?)";
				}else{
					sql = "insert into Category value("+c.getId()+",?,?,?,?,?)";
				}
				pstmt  =DB.getPStmt(conn, sql);
	
				pstmt.setInt(1, c.getPid());
				pstmt.setString(2, c.getName());
				pstmt.setString(3, c.getDescr());
				pstmt.setInt(4, c.isIsleaf()?0:1);
				pstmt.setInt(5, c.getGrade());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DB.closeStmt(pstmt);
				DB.closeConn(conn);
			}	
		
		}
		/* (non-Javadoc)
		 * @see com.shopping.DAOImpl.CategoryDAO#getCategories(java.util.List, int)
		 */
	
		public static  void getCategories(List list,int id){
			Connection conn = null;
			ResultSet rs = null;
			
			
			try {
				conn = DB.getConn();
				String sql = "select * from category where pid ="+id;
				rs = DB.executeQuery(conn, sql);
				
				while(rs.next()) {
					Category c = new Category();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setDescr(rs.getString("descr"));
					c.setPid(rs.getInt("pid"));
					c.setIsleaf(rs.getInt("isleaf")==0?true:false);
					c.setGrade(rs.getInt("grade"));
					list.add(c);
					if(!c.isIsleaf()){
						getCategories(list,c.getId());
					}
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		/* (non-Javadoc)
		 * @see com.shopping.DAOImpl.CategoryDAO#addChildCategory(int, java.lang.String, java.lang.String)
		 */

		public static  void addChildCategory(int pid,String name,String descr){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Statement stmt = null;
			try {
				conn = DB.getConn();
				conn.setAutoCommit(false);
				
				stmt = conn.createStatement();
				
				rs = DB.executeQuery(conn, "select * from category where id = "+pid);
				int parentGrade = 0;
				if(rs.next())
					parentGrade = rs.getInt("grade");
				
				String sql = "insert into category values (null,?,?,?,?,?)";
				pstmt = DB.getPStmt(conn, sql);
				pstmt.setInt(1,pid);
				pstmt.setString(2, name);
				pstmt.setString(3,descr);
				pstmt.setInt(4,0);
				pstmt.setInt(5, parentGrade+1);
				pstmt.executeUpdate();
				
				DB.executeUpdate(stmt, "update category set isleaf = 1 where id =" +pid);
				conn.commit();
				conn.setAutoCommit(true);
			} catch (Exception e) {
			
				e.printStackTrace();
			}finally{
				DB.closeRs(rs);
				DB.closeStmt(pstmt);
				DB.closeConn(conn);
			}
			
		}
		
		/* (non-Javadoc)
		 * @see com.shopping.DAOImpl.CategoryDAO#loadById(int)
		 */
	
		public  Category loadById(int id){
			Connection conn = null;
			Category c = null;
			ResultSet rs = null;
		
			try {
				conn = DB.getConn();
				rs = DB.executeQuery(conn, "select * from category where id ="+id);
				if(rs.next()){
					c = new Category();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setDescr(rs.getString("descr"));
					c.setPid(rs.getInt("pid"));
					c.setIsleaf(rs.getInt("isleaf")==0?true:false);
					c.setGrade(rs.getInt("grade"));
				} }catch (Exception e) {
					
					e.printStackTrace();
				}finally{
					DB.closeRs(rs);
				
					DB.closeConn(conn);
				}
			
			return c;			
		}


		public void deleteCatefory(int id) {
			
			Connection conn = null;
			Statement stmt = null;		
			try {
				conn = DB.getConn();
				stmt = DB.getStmt(conn);
				stmt.executeUpdate("delete from category where id = "+id);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DB.closeStmt(stmt);
				DB.closeConn(conn);
			}
		}
		public boolean isempty(int pid){
				boolean empty = true;
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				
				try {
					conn = DB.getConn();
					rs = DB.executeQuery(conn,"Select * from category where pid = "+pid);
					if(rs.next()){
						empty = false;
					}else{
						empty = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DB.closeRs(rs);
					DB.closeStmt(stmt);
					DB.closeConn(conn);
				}
			return empty;
		}
		public  void setisleaf(int id){
			Connection conn = null;
			Statement stmt = null;
			
			try {
				conn = DB.getConn();
				stmt = conn.createStatement();
				DB.executeUpdate(stmt, "Update category set isleaf = 0 where id ="+id);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				DB.closeStmt(stmt);
				DB.closeConn(conn);
			}
					
					
			
		}

		@Override
		public void updatecategory(int id, String name, String descr) {
			Connection conn =null;
			Statement stmt =null;
			
			try {
				conn = DB.getConn();
				stmt=conn.createStatement();
				DB.executeUpdate(stmt,"Update category set name = '"+name+"', descr ='"+descr+"'where id = "+id );
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}finally{
				DB.closeConn(conn);
				
			
			}
			
			
		}
	}

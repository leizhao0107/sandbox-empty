package com.shopping.service;

import java.sql.Connection;

import com.shopping.DAO.CategoryDAO;
import com.shopping.DAOImpl.CategoryDAOImpl;
import com.shopping.model.Category;

public class CategoryManager {

		
		
		public static void deleteCategory(int id){
			
			CategoryDAO categoryDAO = new CategoryDAOImpl(); ;	
			
			Category c = categoryDAO.loadById(id);
			int pid = c.getPid();
			categoryDAO.deleteCatefory(c.getId());
			System.out.println(categoryDAO.isempty(pid));
			if(categoryDAO.isempty(pid)){
				
				categoryDAO.setisleaf(pid);
				System.out.println("set success");
			}			
		}
		public static void updateCategory(int id,String name,String descr){
			CategoryDAO categoryDAO = new CategoryDAOImpl(); ;	
			
			Category c = categoryDAO.loadById(id);
			categoryDAO.updatecategory(id,name,descr);
				
			
			
			
		}
}	


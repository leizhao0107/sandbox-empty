package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

import com.shopping.DAOImpl.CategoryDAOImpl;

public class Category {

		private int id;
		private String name;
		private String descr;
		private int pid;
		private boolean isleaf;
		private int grade;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;	
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		
		
	
		public boolean isIsleaf() {
			return isleaf;
		}
		public void setIsleaf(boolean isleaf) {
			this.isleaf = isleaf;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		
		public  static void add(Category c){
			CategoryDAOImpl.save(c);
		}
		public static void addTopCategory(String name,String descr){
			Category c = new Category();
			c.setDescr(descr);
			c.setName(name);
			c.setId(-1);
			c.setPid(0);
			c.setIsleaf(true);
			c.setGrade(1);
			add(c);
		}
		public static List<Category> getCategories(){
			List<Category> list = new ArrayList<Category>();
			CategoryDAOImpl.getCategories(list,0);
			return list;
		}
		public static void addChildCategory(int pid,String name,String descr){
			CategoryDAOImpl.addChildCategory(pid,name,descr);
			
		}
		public static void addChild(int pid,Category c){
		
			Category.addChildCategory(pid,c.getName(),c.getDescr());
			
			
			
		}
		
}

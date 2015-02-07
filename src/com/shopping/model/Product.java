package com.shopping.model;

import java.sql.Timestamp;

public class Product {
		private String categorydescr;
		private int  categoryid;
		private String descr;
		private int id;
		private double memberprice;
		private String name;
		private double normalprice;
		//private Timestamp pdate;
		public String getCategorydescr() {
			return categorydescr;
		}
		
		public String getDescr() {
			return descr;
		}
		public int getId() {
			return id;
		}
		public double getMemberprice() {
			return memberprice;
		}
		public String getName() {
			return name;
		}
		public double getNormalprice() {
			return normalprice;
		}
		
		public void setCategorydescr(String categorydescr) {
			this.categorydescr = categorydescr;
		}
		
		public int getCategoryid() {
			return categoryid;
		}

		public void setCategoryid(int categoryid) {
			this.categoryid = categoryid;
		}

		public void setDescr(String descr) {
			this.descr = descr;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setMemberprice(double memberprice) {
			this.memberprice = memberprice;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setNormalprice(double normalprice) {
			this.normalprice = normalprice;
		}
	
		
		
		
}

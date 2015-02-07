package com.shopping.service;

import java.util.Date;
import java.util.List;

import com.shopping.DAO.ProductDAO;
import com.shopping.DAOImpl.ProductMySQLDAOImpl;
import com.shopping.model.Product;

public class ProductManager {

		private static ProductManager pm = null;
		private int pageCount = 0;
		static{
			if(pm==null){
				pm = new ProductManager();
				//you should read the config file to set the specific dao object;
				pm.setDao(new ProductMySQLDAOImpl());
			}
			
		}
		private ProductManager(){}
		
		public static ProductManager getInstance(){
			return pm;
		}
		
		
		ProductDAO dao = null;
		
		public List<Product> getProducts(){
			
			return dao.getProducts();
		}
		
		public ProductDAO getDao() {
			return dao;
		}

		public void setDao(ProductDAO dao) {
			this.dao = dao;
		}

		public int getProducts(List<Product> products,int pageNo, int pageSize){
			
			return dao.getProducts(products,pageNo,pageSize);
		
		}
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
			dao.addProduct(p);
			return true;
		}
		
		
		
}

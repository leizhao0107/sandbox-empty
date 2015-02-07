package com.shopping.DAO;

import java.util.Date;
import java.util.List;

import com.shopping.model.Product;

public interface ProductDAO {
		
	public abstract List<Product> getProducts();

	public abstract int getProducts(List<Product> products,int pageNo, int pageSize);

	public abstract List<Product> findProducts(int[] categoryId, 
													 String name,
													 String descr,
													 double lownormalprice, 
													 double highnormalprice,
													 double lowmemberprice,
													 double highmemberprice,
													
													 int pageNo, 
													 int pageSize);

	public abstract List<Product> findProducts(String name);

	public abstract boolean deleteProductByCategoryId(int categoryId);

	public abstract boolean deleteProductsById(int idArray);

	public abstract boolean updateProduct(Product p);
	public abstract boolean addProduct(Product p);

		
		
}

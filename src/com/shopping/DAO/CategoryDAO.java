package com.shopping.DAO;

import java.util.List;

import com.shopping.model.Category;

public interface CategoryDAO {

	Category loadById(int id);

	void deleteCatefory(int id);

	boolean isempty(int pid);

	void setisleaf(int id);

	void updatecategory(int id, String name, String descr);

	
}
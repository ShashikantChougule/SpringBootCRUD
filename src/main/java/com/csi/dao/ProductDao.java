package com.csi.dao;

import java.util.List;

import com.csi.model.Product;

public interface ProductDao {

	public List<Product> getData();
	
	public void saveData(Product product);
	
	public void updateData(int prodId, Product product );
	
	public void deleteById(int prodId);
	
}

package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.dao.ProductDao;
import com.csi.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@GetMapping("/getdata")
	public List<Product> getData()
	{
	 return productDao.getData();	
	}
	

	
	@PostMapping("/savadata")
	public String saveData(@RequestBody Product product)
	{
		productDao.saveData(product);
		return "data save successfully";
	}
	
	@PutMapping("/updatedata/{prodId}")
	public String updateData(@PathVariable("prodId") int prodId, @RequestBody Product product)
	{
	  productDao.updateData(prodId, product);
	  return "data update successfully";
	}
	
	@DeleteMapping("/deletedata/{prodId}")
	public String deleteData(@PathVariable("prodId") int prodId)
	{
	 productDao.deleteById(prodId);	
	 return "data delete successfully";
	}

}

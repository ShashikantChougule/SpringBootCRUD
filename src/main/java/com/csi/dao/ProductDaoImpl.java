package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.model.Product;

@Component
public class ProductDaoImpl implements ProductDao{


	
	private static SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	@Override
	public List<Product> getData() {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List<Product> pList=session.createQuery("from Product").list();
		
		return pList;
	}

	@Override
	public void saveData(Product product) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		
	}

	@Override
	public void updateData(int prodId, Product product) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Product> pList=session.createQuery("from Product").list();
		for(Product p:pList)
		{
			if(p.getProdId()==prodId)
			{
			  p.setProdName(product.getProdName());
			  p.setProdPrice(product.getProdPrice());
			  session.save(p);
			  
			}
		}
		transaction.commit();
	}

	@Override
	public void deleteById(int prodId) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Product> pList=session.createQuery("from Product").list();
		for(Product p:pList)
		{
			if(p.getProdId()==prodId)
			{
			 
			  session.delete(p);
			  
			}
		}
		transaction.commit();
	}

	
}

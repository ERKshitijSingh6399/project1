package com.app.search.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOimpl;
import com.app.exception.BusinessException;
import com.app.model.Customers;
import com.app.model.Orders;
import com.app.model.Products;
import com.app.search.service.EmployeeSearchService;

public class EmployeeSearchServiceImpl implements EmployeeSearchService{
	private static Logger log1 = Logger.getLogger(EmployeeSearchServiceImpl.class);
	private EmployeeDAO employeesearchdao = new EmployeeDAOimpl();
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean addnewproducts() throws BusinessException{
		Products p=new Products();
		try{
		log1.info("Enter Product Name");
		String name=sc.next();
		p.setProduct_name(name);
		log1.info("Product Type");
		String pt=sc.next();
		p.setProduct_type(pt);
		log1.info("Product Price");
		double price=sc.nextDouble();
		p.setProduct_price(price);
		log1.info("Product Quantity");
		int q=sc.nextInt();
		p.setProduct_quantity(q);
		log1.info("Product Company");
		String company=sc.next();
		p.setProduct_company(company);
		}catch(Exception e) {
			throw new BusinessException("Error in inputing details");
		}
		if(employeesearchdao.addproduct(p))
			{return true;}
		else
			{return false;}
	}

	@Override
	public List<Customers> viewcustomerdetails() throws BusinessException {
		//List<Customers> customerlist=null;
//		log1.info("\nChoose Filter:");
//		log1.info("");
//		log1.info("");
//		log1.info("");
//		
//		if(true) {
		 List<Customers> customerlist=employeesearchdao.getallcustomers();
//		}else {
//			throw new BusinessException("Make Correct Choice");
//		}
		return customerlist;
	}

	@Override
	public boolean modifyproductsquantity(int productid) throws BusinessException {
		log1.info("Enter New Quantity : ");
		int newquantity=sc.nextInt();
		try {
		if(employeesearchdao.modifyproductquantity(productid,newquantity))
		{return true;}
		else
		{return false;}
		}catch(Exception e) {return false;}
	}

	@Override
	public boolean deleteproduct(int productid) throws BusinessException {
		try {
		if(employeesearchdao.deleteproduct(productid))
		{return true;}
		else
		{return false;}
		}catch(Exception e) {return false;}
	}

	@Override
	public boolean updateorderbyemployee(List<Integer> olist) throws BusinessException {
		if(olist!=null)
		{return employeesearchdao.updateorderbyemployee(olist);}
		else
		return false;
	}

	@Override
	public List<Orders> viewallorders() throws BusinessException {
		List<Orders> orderlist=employeesearchdao.viewallorders();
		return orderlist;
	}

}

package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.model.Customers;

public interface EmployeeDAO {
	public List<Customers> getallcustomers() throws BusinessException;
	public int addproduct(Products product) throws BusinessException;
	public int markshipped(Products product) throws BusinessException;
	public int deleteproduct(Products product) throws BusinessException;
	int validateemployee(String empname, String emppassword) throws BusinessException;
	
}

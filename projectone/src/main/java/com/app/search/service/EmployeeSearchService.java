package com.app.search.service;

import java.util.List;
import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.model.Customers;

public interface EmployeeSearchService {
	
	public boolean addnewproducts() throws BusinessException;

	public boolean modifyproductsquantity(int productid) throws BusinessException;
	public boolean deleteproduct(int productid) throws BusinessException;

	public List<Customers> viewcustomerdetails() throws BusinessException;
	public Products markorderasshipped() throws BusinessException;
	
}

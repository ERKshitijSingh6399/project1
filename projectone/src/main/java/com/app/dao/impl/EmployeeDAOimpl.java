package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.model.Customers;
public class EmployeeDAOimpl implements EmployeeDAO{
	@Override
	public int validateemployee(String empname, String emppassword) throws BusinessException{
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select * from employeedetails";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				if((resultSet.getString("employeeusername").equals(empname)) && (resultSet.getString("employeepassword").equals(emppassword)))
				{return 1;}
				else
					{System.out.println("INVALID : PLEASE ENTER CORRECT CREDENIALS"); return 0;}
			}else {
				throw new BusinessException("CREDENTIALS DOES NOT EXIST");
			}
		} catch (ClassNotFoundException | SQLException e) {
			//log.error(e);
			throw new BusinessException("INTERNAL ERROR OCCURED : CONTACT SYSTEM ADMIN");
		}
	}
	@Override
	public List<Customers> getallcustomers() throws BusinessException{
		List<Customers> customerlist=new ArrayList<>();
		return customerlist;
	}
	@Override
	public int addproduct(Products product) throws BusinessException{
		return 0;
	}
	@Override
	public int markshipped(Products product) throws BusinessException{
		return 0;
	}
	@Override
	public int deleteproduct(Products product) throws BusinessException{
		return 0;
	}
	
}

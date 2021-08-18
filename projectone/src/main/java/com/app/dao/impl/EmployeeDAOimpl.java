package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.model.Customers;

public class EmployeeDAOimpl implements EmployeeDAO{
	private static Logger log2 = Logger.getLogger(EmployeeDAOimpl.class);
//	@Override
//	public int validateemployee(String empname, String emppassword) throws BusinessException{
//		try(Connection connection=MySqlDbConnection.getConnection()){
//			String sql="select * from employeedetails";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			ResultSet resultSet=preparedStatement.executeQuery();
//			if(resultSet.next())
//			{
//				if((resultSet.getString("employeeusername").equals(empname)) && (resultSet.getString("employeepassword").equals(emppassword)))
//				{return 1;}
//				else
//					{System.out.println("INVALID : PLEASE ENTER CORRECT CREDENIALS"); return 0;}
//			}else {
//				throw new BusinessException("CREDENTIALS DOES NOT EXIST");
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			//log.error(e);
//			throw new BusinessException("INTERNAL ERROR OCCURED : CONTACT SYSTEM ADMIN");
//		}
//	}
	@Override
	public List<Customers> getallcustomers() throws BusinessException{
		List<Customers> customerlist=new ArrayList<>();
		return customerlist;
	}
	@Override
	public boolean addproduct(Products product) throws BusinessException{
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Insert into Products(productname,producttype,productprice,productquantity,productcompany) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,product.getProduct_name());
			preparedStatement.setString(2,product.getProduct_type());
			preparedStatement.setDouble(3,product.getProduct_price());
			preparedStatement.setInt(4,product.getProduct_quantity());
			preparedStatement.setString(5,product.getProduct_company());

			int res=preparedStatement.executeUpdate();
			if(res==1) {
				return true;
			}else {
				throw new BusinessException("Server Error: Could not enter New Product");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log2.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
	}
	@Override
	public int markshipped(Products product) throws BusinessException{
		return 0;
	}
	@Override
	public boolean deleteproduct(int productid) throws BusinessException{
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Delete from Products where productid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,productid);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				return true;
			}else {
				throw new BusinessException("Server Error: Could Delete Product");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log2.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
	}
	@Override
	public boolean modifyproductquantity(int productid, int newquantity) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Update Products set productquantity=? where productid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,newquantity);
			preparedStatement.setInt(2,productid);

			int res=preparedStatement.executeUpdate();
			if(res==1) {
				return true;
			}else {
				throw new BusinessException("Server Error: Could not update Product quantity");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log2.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
	}//end of method
	
}

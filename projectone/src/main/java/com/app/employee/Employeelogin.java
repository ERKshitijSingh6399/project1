package com.app.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.dbutil.MySqlDbConnection;
import com.app.dao.impl.EmployeeDAOimpl;
import com.app.exception.BusinessException;

public class Employeelogin {

	public static void main(String[] args) {
		System.out.println("-------SHOP PROJECT------");
		System.out.println("---EMPLOYEE LOGIN PAGE---");
		Scanner sc=new Scanner(System.in);
		int tries=0;
		do {
		System.out.print("Enter Username: ");
		String empname=sc.next();
		System.out.print("Enter Password: ");
		String emppassword=sc.next();
		sc.close();
		try{
			int ve=EmployeeDAOimpl.validateemployee(empname,emppassword);
			if(ve==1) {}
			else {tries++;}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		}while(tries<5);
		System.out.println("Invalid Credentials used for 5 times : Closing App");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

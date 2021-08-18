package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.impl.EmployeeDAOimpl;
import com.app.exception.BusinessException;
import com.app.dao.EmployeeDAO;

public class CustomerLogin {
	private static Logger logc = Logger.getLogger(CustomerLogin.class);

	public static void main(String[] args) {
		EmployeeDAO empp = new EmployeeDAOimpl();
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
			int ve=empp.validateemployee(empname,emppassword);
			if(ve==1) {}
			else {tries++;}
		   } catch (BusinessException e)
				{System.out.println(e.getMessage());}
		}while(tries<5);
		System.out.println("Invalid Credentials used for 5 times : Closing App");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

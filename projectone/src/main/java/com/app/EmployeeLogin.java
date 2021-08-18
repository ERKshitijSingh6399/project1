package com.app;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.search.service.EmployeeSearchService;
import com.app.search.service.impl.EmployeeSearchServiceImpl;

public class EmployeeLogin {
	private static Logger log = Logger.getLogger(EmployeeLogin.class);

	public static void main(String[] args) {
		int choice=0,ch=0;
		Scanner sc=new Scanner(System.in);
		EmployeeSearchService employeesearchserviceobject = new EmployeeSearchServiceImpl();
		System.out.println("-------SHOP PROJECT------");
		System.out.println("---EMPLOYEE LOGIN PAGE---");
		int tries=0;
		do {
		log.info("1.Login");
		log.info("2.Exit");
		choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.print("Enter Username: ");
		String empname=sc.next();
		System.out.print("Enter Password: ");
		String emppassword=sc.next();
		if(empname.equals("abc") && emppassword.equals("abc"))
		{
			do {
			log.info("\nEmployee Login Successful");
			log.info("1. View Customers Details");
			log.info("2. Add a new Product");
			log.info("3. Mark Order as Shipped");
			log.info("4. Modify Quantity of Existing Products");
			log.info("5. Delete Existing Product");
			log.info("6. Logout");
			ch=sc.nextInt();
			switch(ch){
			case 1:log.info("Showing Customer Details");
				   break;
			case 2:log.info("Add New Products");
					try{boolean answer1=employeesearchserviceobject.addnewproducts();
					if(answer1==true) {log.info("New Product Added Successfully");}
					else {log.warn("Internal Server Error: Could not insert new product");}
					}catch(BusinessException e) {log.warn(e.getMessage());}
					break;
			case 3:log.info("Mark Order as Shipped");
			       break;
			case 4:log.info("Modify Quantity of Existing Products");
					try{
						log.info("Enter Product Id to modify quantity for that product:");
						int id2=sc.nextInt();
						boolean answer2=employeesearchserviceobject.modifyproductsquantity(id2);
						if(answer2==true) {log.info("Product Quantity Updated Successfully");}
						else {log.warn("Internal Server Error: Could not update product quantity");}
					}catch(BusinessException e) {log.warn(e.getMessage());}
				   break;
			case 5:log.info("Remove Existing Product");
					try{
					log.info("Enter Product Id to Remove:");
					int id3=sc.nextInt();
					boolean answer3=employeesearchserviceobject.deleteproduct(id3);
					if(answer3==true) {log.info("Product Deleted Successfully");}
					else {log.warn("Internal Server Error: Could not remove product");}
					}catch(BusinessException e) {log.warn(e.getMessage());}
					break;
			case 6:log.info("Logging out");
					choice=2;
			       break;
			default:log.info("Incorrect Choice : Enter Correct Choice");
					break;
			}
			}while(ch!=6);
		}
		else
			{System.out.println("Invalid Employee Credentials");}
		break;
		case 2:log.info("Exiting!!");
				break;
		default:log.info("Incorrect Choice : Enter Correct Choice");
				break;
		}
		}while(choice!=2);
		sc.close();
//		try{
//			int ve=empp.validateemployee(empname,emppassword);
//			if(ve==1) {}
//			else {tries++;}
//		   } catch (BusinessException e)
//				{System.out.println(e.getMessage());}
//		}while(tries<5);
//		System.out.println("Invalid Credentials used for 5 times : Closing App");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

}

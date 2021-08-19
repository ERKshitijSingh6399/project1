package com.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int loginchoice=0;
		do{
			System.out.println("Welcome User\n1. Login as Employee\n2. Login as Customer\nEnter your choice:");
			loginchoice=sc.nextInt();
			switch(loginchoice){
				case 1:EmployeeLogin.main(args);
						break;
				case 2:CustomerLogin.main(args);
						break;
				case 3:System.out.println("Closing App");
						break;
				default:System.out.println("Invalid Choice");
						break;
			}
		}while(loginchoice!=3);
		

	}

}

package Project.main;

import java.util.Scanner;
import Project.UI.AdminUI;
import Project.UI.CustomerUI;

public class ShoppingAppMain {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("\n********************** WELCOME TO THE SHOPPING MART ******************************");

		do
		{
			System.out.println("\n1) Admin Login \n2) Customer Login \n3) New User (admin/customer registration)");
			System.out.print("Enter your choice: ");
			int ch=sc.nextInt();
			
				if(ch==1)
				{
					AdminUI ad=new AdminUI();
					ad.AdminLogin();
					
					do {
						System.out.println("1) Add Product \n2) View Product \n3) Search Product \n4) Delete Product \n5) Details of Customer");
						int ch1 = sc.nextInt();
					
						if(ch1==1){
							ad.addProduct();
						}
						
						else if(ch1==2){
							ad.getAllProduct();
						}
						
						else if(ch1 == 3){
							ad.searchProduct();
						}
						
						else if(ch1 == 4){
							ad.deleteProduct();
						}
						
						else if(ch1==5){
							CustomerUI cu = new CustomerUI();
							cu.getCust();
						}
						System.out.println("\nDo you want to continue as admin [yes/no] ");
	
					}while(sc.next().equals("yes"));
		
					System.out.println("Admin Logout..");
				}
				else if(ch==2)
				{
					CustomerUI cu = new CustomerUI();
					cu.CustLogin();
					
					do {
						System.out.println("\n1) Details of customer \n2) Shop Items \n3) delete items \n4) View Bill");
						System.out.println("Enter your choice: ");
						int ch1 = sc.nextInt();
						
						if(ch1==1){
							cu.getCust();
						}
						
						else if(ch1==2) {
							System.out.println("\n-------Details of product we have-----");
							AdminUI ad=new AdminUI();
							ad.getAllProduct();
							
							cu.addProduct_Bill();
						}
						
						else if(ch1==3) {
							cu.deleteProduct_Bill();
						}
						
						else if(ch1==4) {
							cu.getBill();
						}
						
						System.out.println("\nDo you want to continue as customer [yes/no] ");
	
					}while(sc.next().equals("yes"));
		
					System.out.println("Customer Logout..");
				}
				
				else if(ch==3)
				{
					System.out.println("\n1) Admin Registration 2) Customer Registration");
					System.out.print("Enter your choice: ");
					int ch3 = sc.nextInt();
					
					if(ch3 == 1) {
						AdminUI ad=new AdminUI();
						ad.AdminRegister();
					}
					
					if(ch3 == 2) {
						CustomerUI cu = new CustomerUI();
						cu.CustRegistration();
					}
				}
				System.out.println("\nDo you want to continue with the application? [yes/no] ");
				
		}while(sc.next().equals("yes"));
		System.out.println("*********************** VISIT AGAIN *********************");
		System.out.println("EXIT...");

	}
}


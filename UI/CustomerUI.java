package Project.UI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Project.dao.ProductDao;
import Project.dao.CustomerDao;
import Project.dao.Billdao;
import Project.model.Customer;
import Project.model.Product;

public class CustomerUI {
	
	Scanner sc = new Scanner(System.in);
	ProductDao pdao = new ProductDao();
	CustomerDao cdao = new CustomerDao();
	Billdao bdao = new Billdao();
	
	public void CustLogin() {
		List<Customer> culst=new LinkedList<Customer>();

		System.out.println("\nPLEASE LOGIN...");
		System.out.print("Enter Customer's ID: ");
		int id = sc.nextInt();
		
		System.out.print("Enter Customer's password: ");
		String cust_pass = sc.next();
		
		Customer cust = new Customer(id, cust_pass);
		culst.add(cust);          // adding data into the list
		cdao.Cust_Login(culst);
	}
	
	public void CustRegistration() {
		
		List<Customer> culst = new LinkedList<Customer>();
		System.out.println("\nPLEASE REGISTER AS CUSTOMER....");
		
		System.out.print("Enter Customer's ID: ");
		int id = sc.nextInt();
		
		System.out.print("Enter Customer's name: ");
		String cust_name = sc.next();
		
		System.out.print("Enter Customer's password: ");
		String cust_pass = sc.next();
		

		System.out.print("Enter Customer's Phone number: ");
		int phno = sc.nextInt();
		
		Customer cust = new Customer(id, cust_name, cust_pass, phno);
		culst.add(cust);
		cdao.cust_register(culst);
		
	}
	
	public void getCust(){
		
		List<Customer> custlst = cdao.DisplayCust(); //productdao is called and details are retrieved from db.
		System.out.println("------------------CUSTOMER DETAILS----------------------");
		
		System.out.println("Customer ID \t Customer Name \t  Customer Password \t Customer Phone number");
		for(Customer c:custlst)
		{
			System.out.println(c.getCustId()+"\t\t "+c.getCustName()+"\t\t  "+c.getCustPass()+"\t\t "+c.getMobNo());
		}
	}
	
	public void addProduct_Bill()
	{
		List<Product> billlst=new LinkedList<Product>();
		do
		{
			System.out.println("Enter product Id");
			int prodId=sc.nextInt();
			
			System.out.println("Enter Product Name");
			String prodName=sc.next();
			
			System.out.println("Enter Product Amount you have to pay: ");
			double prodPrice=sc.nextDouble();
			
			System.out.println("Enter Product Qty");
			int prodQty=sc.nextInt();
			
			Product prod=new Product(prodId, prodName, prodPrice, prodQty);
			billlst.add(prod);
			
			System.out.println("do you want to buy more product [yes/no]");
		}
		while(sc.next().equals("yes"));
		
		bdao.createBill(billlst);
		System.out.println("product is added to the bill");
	}
	
	public void getBill(){
		double total_price = 0;
			
			List<Product> lstproduct = bdao.DisplayBill(); 
			System.out.println("------------------PRODUCT DETAILS----------------------");
			
			System.out.println("Product ID \t Product Name \t Product Price \t Product Quantity");
			for(Product p:lstproduct)
			{
				System.out.println(p.getProdId()+"\t\t "+p.getProdName()+"\t\t  "+p.getProdPrice()+"\t\t   "+p.getProdQty());
				total_price += p.getProdPrice()*p.getProdQty();
			}
			System.out.println("-------------------------------------------------------");
			System.out.println("Total price: " + total_price);
	}
	
	public void deleteProduct_Bill() {
		System.out.print("Enter the product id you want to delete: ");
		int id = sc.nextInt();
		bdao.DeleteFromBill(id);
	}
}
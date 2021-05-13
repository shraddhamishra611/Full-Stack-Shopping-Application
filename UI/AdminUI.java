package Project.UI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Project.dao.ProductDao;
import Project.dao.AdminDao;
import Project.model.Product;
import Project.model.Admin;;


public class AdminUI extends InvalidQty{
	
	Scanner sc = new Scanner(System.in);
	ProductDao pdao = new ProductDao();
	AdminDao adao = new AdminDao();
	Product p;
	
	public void check_exception() {
		try {
			throw new InvalidQty();
		}
		catch(InvalidQty e) {
			System.out.println(e.toString());
		}
	}
	
	public void AdminLogin() {
		List<Admin> adlst=new LinkedList<Admin>();

		System.out.println("\nPLEASE LOGIN...");
		System.out.print("Enter Admin's username: ");
		String ad_name = sc.next();
		System.out.print("Enter Admin's password: ");
		String ad_pass = sc.next();
		
		Admin ad = new Admin(ad_name,ad_pass);
		adlst.add(ad);
		adao.Ad_Login(adlst);
	}
	
	public void AdminRegister() {
		List<Admin> adlst=new LinkedList<Admin>();

			System.out.println("\nPLEASE REGISTER...");
			System.out.print("Enter Admin's username: ");
			String ad_name = sc.next();
			System.out.print("Enter Admin's password: ");
			String ad_pass = sc.next();
			
			Admin ad = new Admin(ad_name,ad_pass);
			adlst.add(ad);
			adao.Ad_register(adlst);
	}
	
	public void addProduct()
	{
		List<Product> prodlst=new LinkedList<Product>();
		do
		{
			System.out.println("\nEnter product Id");
			int prodId=sc.nextInt();
			
			System.out.println("Enter Product Name");
			String prodName=sc.next();
			
			System.out.println("Enter Product Price");
			double prodPrice=sc.nextDouble();
			
			System.out.println("Enter Product Qty");
			int prodQty=sc.nextInt();
			if(prodQty < 0) {
				check_exception();
			}
			else {
				Product prod = new Product(prodId, prodName, prodPrice, prodQty);
				prodlst.add(prod);
			}
			
			System.out.println("do you want to add more product [yes/no]");
		}
		while(sc.next().equals("yes"));
		
		pdao.createProduct(prodlst);
		//System.out.println("ui save done..");
	}
	
	public void getAllProduct(){
		
		List<Product> lstproduct = pdao.DisplayProduct(); //productdao is called and details are retrieved from db.
		System.out.println("------------------PRODUCT DETAILS----------------------");
		
		System.out.println("Product ID \t Product Name \t Product Price \t Product Quantity");
		for(Product p:lstproduct)
		{
			System.out.println(p.getProdId()+"\t\t "+p.getProdName()+"\t\t  "+p.getProdPrice()+"\t\t   "+p.getProdQty());
		}
	}

	public void searchProduct() {
		
		System.out.print("Enter the product id: ");
		int id = sc.nextInt();
		List<Product> lstproduct = pdao.search(id);
		
		System.out.println("\n---details of id " + id + "---");
		System.out.println("Product ID \t Product Name \t Product Price \t Product Quantity");
		
		for(Product p : lstproduct) {
			System.out.println(p.getProdId()+"\t\t   "+p.getProdName()+"\t\t   "+p.getProdPrice()+"\t\t   "+p.getProdQty());
		}
	}

	public void deleteProduct() {
		System.out.print("Enter the product id you want to delete: ");
		int id = sc.nextInt();
		pdao.delete(id);
	}
}

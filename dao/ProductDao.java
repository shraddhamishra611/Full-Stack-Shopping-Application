package Project.dao;

import java.sql.Connection;
//import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Project.model.Product;

public class ProductDao {

	Connection con = null;
	DBConnection dbcon = new DBConnection();
	PreparedStatement ps;
	Product p;
	
	public void createProduct(List<Product> plst) {
		con = dbcon.getConnection(); 
		
		for(Product p:plst) {
			try {
				ps = con.prepareStatement("insert into product values(?,?,?,?)");
				ps.setInt(1, p.getProdId());//calling getter function to retrieve id and pass it into db.  
				ps.setString(2, p.getProdName());
				ps.setDouble(3, p.getProdPrice());
				ps.setInt(4, p.getProdQty());
				
				int i = ps.executeUpdate();
				if(i > 0) {
					System.out.println("Product details saved in Database.");		
				}
				
			}catch(Exception e) {
				//e.printStackTrace();
				System.out.println(e);
			}			
		}
	}
	
	public List<Product> DisplayProduct(){
		
		LinkedList<Product> prod_lst = new LinkedList<Product>();
		String str = "select * from product";
		con = dbcon.getConnection();
		
		try {
			Statement stmt = con.createStatement(); // statement is used when we want to compile and run(usually for display).
			ResultSet result = stmt.executeQuery(str);
			
			while(result.next()) {
				Product p1 = new Product(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				prod_lst.add(p1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prod_lst;
	}
	
	public List<Product> search(int search_id) {
		LinkedList<Product> prod_lst = new LinkedList<Product>();
		con = dbcon.getConnection();
		
		try {
			String str = "select prodId,ProdName,prodPrice,ProdQty from product where prodId = " + search_id;
			
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(str);
			
			while(result.next()) {
				Product p1 = new Product(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				prod_lst.add(p1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
		return prod_lst;
	}
	
	public void delete(int search_id) {
		con = dbcon.getConnection();
		
		try {
			String str = "delete from product where prodId = " + search_id;
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(str);
			
			System.out.println("Data is deleted..");
			
			/*while(result.next()) {
				Product p1 = new Product(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				prod_lst.add(p1);
			}*/
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
	}
}


package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Project.UI.CustomerUI;
import Project.model.Product;

public class Billdao {
	Connection con = null;
	DBConnection dbcon = new DBConnection();
	PreparedStatement ps;
	Product p;
	CustomerUI c;
	ProductDao pdao = new ProductDao();

	public void createBill(List<Product> plst) {
		con = dbcon.getConnection(); 
		
		for(Product p:plst) {
			try {
				ps = con.prepareStatement("insert into bill values(?,?,?,?)");
				ps.setInt(1, p.getProdId());
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
	
	public List<Product> DisplayBill(){
			
			LinkedList<Product> bill_lst = new LinkedList<Product>();
			String str = "select * from bill";
			con = dbcon.getConnection();
			
			try {
				Statement stmt = con.createStatement(); // statement is used when we want to compile and run(usually for display).
				ResultSet result = stmt.executeQuery(str);
				
				while(result.next()) {
					Product p1 = new Product(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
					bill_lst.add(p1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return bill_lst;
	}
	
	public void DeleteFromBill(int search_id) {
		con = dbcon.getConnection();
		
		try {
			String str = "delete from bill where prod_id = " + search_id;
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(str);
			
			System.out.println("Data from bill is deleted..");

		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
	}
}

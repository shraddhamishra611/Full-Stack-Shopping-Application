package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Project.model.Customer;

public class CustomerDao {
	Connection con = null;
	DBConnection dbcon = new DBConnection();
	PreparedStatement ps,ps1;
	Customer c;

	public void Cust_Login(List<Customer> culst) {
		con = dbcon.getConnection();
		
		for(Customer c:culst) {
			try {
				ps = con.prepareStatement("select * from cust_login where cust_id = ? and cust_pass = ?");
				ps.setInt(1, c.getCustId());
				ps.setString(2, c.getCustPass());
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Login successful!!!");
					System.out.println("\n------Welcome -----------");
				}
				else {
					System.out.println("LOGIN FAILED!!");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void cust_register(List<Customer> culst) {
		con = dbcon.getConnection();
		
		for(Customer c:culst) {
			try {
				ps = con.prepareStatement("insert into cust_register values(?,?,?,?)");
				ps.setInt(1, c.getCustId());
				ps.setString(2, c.getCustName());
				ps.setString(3, c.getCustPass());
				ps.setDouble(4, c.getMobNo());
				
				int i = ps.executeUpdate();
				if(i > 0) {
					System.out.println("Successfully Registered..");
					System.out.println("\n------Welcome " + c.getCustName() + " -----------");
				}
				else {
					System.out.println("Registeration failed!!!");
				}
				
				ps1 = con.prepareStatement("insert into cust_login values(?,?)");
				ps1.setInt(1, c.getCustId());
				ps1.setString(2, c.getCustPass());
				
				int j = ps1.executeUpdate();
				if(j > 0) {
					System.out.println("Successfully Registered..");
				}
				else {
					System.out.println("Registeration failed!!!");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Customer> DisplayCust() {
		LinkedList<Customer> custlst = new LinkedList<Customer>();
		String str = "select * from cust_register";
		con = dbcon.getConnection();
		
		try {
			Statement stmt = con.createStatement(); // statement is used when we want to compile and run(usually for display).
			ResultSet result = stmt.executeQuery(str);
			
			while(result.next()) {
				Customer c = new Customer(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4));
				custlst.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return custlst;
	}

}

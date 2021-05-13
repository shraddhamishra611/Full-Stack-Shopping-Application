package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Project.model.Admin;;

public class AdminDao {

	Connection con = null;
	DBConnection dbcon = new DBConnection();
	PreparedStatement ps;
	Admin a;
	
	public void Ad_Login(List<Admin> alst) {
		con = dbcon.getConnection();
		
		for(Admin a:alst) {
			try {
				ps = con.prepareStatement("select * from admin_login where admin_name = ? and admin_pass = ?");
				ps.setString(1, a.getUsername());
				ps.setString(2, a.getPassword());
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Login successful!!!");
					System.out.println("\n------Welcome " + a.getUsername() + " -----------");
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

	public void Ad_register(List<Admin> alst) {
		con = dbcon.getConnection();
		
		for(Admin a:alst) {
			try {
				ps = con.prepareStatement("insert into admin_login values(?,?)");
				ps.setString(1, a.getUsername());
				ps.setString(2, a.getPassword());
				
				int i = ps.executeUpdate();
				if(i > 0) {
					System.out.println("Successfully Registered..");
					System.out.println("\n------Welcome " + a.getUsername() + " -----------");
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
}

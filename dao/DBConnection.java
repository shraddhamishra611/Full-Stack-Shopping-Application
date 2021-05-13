package Project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingApp?useSSL=false","root","611");
			System.out.println("\nApplication is connected to database..");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

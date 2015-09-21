package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConn {
	public Connection create() throws ClassNotFoundException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbi_test", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
}

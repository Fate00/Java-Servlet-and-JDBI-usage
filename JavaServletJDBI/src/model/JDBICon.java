package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JDBICon {
	public  MysqlDataSource create() {
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setDatabaseName("jdbi_test");
		ds.setUser("root");
		ds.setPassword("root");
		
		return ds;
	}
}

package model;

import java.sql.SQLException;
import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MysqlAdd {
	public void add(String name, String password) throws ClassNotFoundException, SQLException {
//		MysqlConn mc = new MysqlConn();
//		Connection con = mc.create();
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate("insert into test(c_name, c_password) values ('" + name + "','" + password + "')");
//		con.close();
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		dao.insert(name, password);
		dao.close();
		
	}
}

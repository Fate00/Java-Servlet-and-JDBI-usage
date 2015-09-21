package model;

import java.sql.SQLException;
import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MysqlEd {
	public void change(String name, String password, int id) throws ClassNotFoundException, SQLException {
//		MysqlConn mc = new MysqlConn();
//		Connection con = mc.create();
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate("update test set c_name = '" + name + "', c_password = '" + password + "' where id = '" + id + "'");
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		dao.change(name, password, id);
		dao.close();
	}
}

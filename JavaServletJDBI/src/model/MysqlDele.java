package model;

import java.sql.SQLException;
import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MysqlDele {
	public void Delete(int id) throws ClassNotFoundException, SQLException {
//		MysqlConn mc = new MysqlConn();
//		Connection con = mc.create();
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate("delete from test where id = '" + id + "'");
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		dao.delete(id);
		dao.close();
	}
}

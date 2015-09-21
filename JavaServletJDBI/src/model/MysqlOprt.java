package model;

import java.sql.SQLException;
import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MysqlOprt {
	public List<CreateClassTest> mysqlOp(String name) throws ClassNotFoundException, SQLException {
//		MysqlConn mc = new MysqlConn();
//		Connection con = null;
//		ResultSet rs = null;
//		Statement stmt = null;
//		TestMapper tm = new TestMapper();
//		List<CreateClassTest> ls = new LinkedList<CreateClassTest>();
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		List<CreateClassTest> ls = dao.getCreateClassTest(name);
//		con = mc.create();
//		stmt = con.createStatement();
//		rs = stmt.executeQuery("select * from test where c_name = '" + name + "'");
//		
//		while(rs.next()) {
//			ls.add(tm.map(0, rs, null));
//		}
		dao.close();
		return ls;
		
	}
}

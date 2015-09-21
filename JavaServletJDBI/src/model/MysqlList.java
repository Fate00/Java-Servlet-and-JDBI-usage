package model;

import java.sql.SQLException;
import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MysqlList {
	public List<CreateClassTest> ListAll(int curPage, int rowPerPage) throws ClassNotFoundException, SQLException {
		
		int startRow = (curPage - 1) * rowPerPage;
//		int reg = 1;
//		MysqlConn mc = new MysqlConn();
//		Connection con = null;
//		ResultSet rs = null;
//		Statement stmt = null;
//		TestMapper tm = new TestMapper();
//		List<CreateClassTest> ls = new ArrayList<CreateClassTest>();
//		con = mc.create();
//		stmt = con.createStatement();
//		rs = stmt.executeQuery("select * from test ");
		
//		while(rs.next() && reg <= (startRow + rowPerPage)) {
//			
//			if(reg > startRow) {
//				ls.add(tm.map(0, rs, null));
//			}
//			reg++;
//		}
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		List<CreateClassTest> ls = dao.getCreateClassTestLimit(startRow, rowPerPage);
		dao.close();
		
		return ls;
	}
	
	public int getMaxPage(int rowsPerPage) throws ClassNotFoundException, SQLException {
		int maxPage, maxRowCount;
//		int maxRowCount = 0;
//		MysqlConn mc = new MysqlConn();
//		Connection con = mc.create();
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("select count(*) from test");
//		if(rs.next()) {
//			maxRowCount = rs.getInt(1);
//		}
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		maxRowCount = dao.getMaxRowCount();
		maxPage = (maxRowCount + rowsPerPage - 1) / rowsPerPage;
		dao.close();
		
		return maxPage;
	}
}

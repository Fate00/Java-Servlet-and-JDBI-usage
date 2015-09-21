package model;

import org.skife.jdbi.v2.DBI;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import model.TestDomain;

public class TestMain {

	private static final TestDomain test = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBICon jcon = new JDBICon();
		MysqlDataSource ds = jcon.create();
		DBI dbi = new DBI(ds);
		JDBIDao dao = dbi.open(JDBIDao.class);
		String a = "zzc";
		String b = "3333";
		String c = "3344";
		int id = dao.saveOrUpdate(a, b, c);
		
		System.out.println(id);
		
	}

}

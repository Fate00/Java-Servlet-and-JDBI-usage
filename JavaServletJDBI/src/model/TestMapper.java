package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TestMapper implements ResultSetMapper<CreateClassTest> {
	public CreateClassTest map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		return new CreateClassTest(rs.getString("c_name"), rs.getString("c_password"), rs.getInt("id"));
	}
}

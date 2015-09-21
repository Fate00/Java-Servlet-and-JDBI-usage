package model;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.util.IntegerMapper;

public interface JDBIDao {
	
	@SqlQuery("select * from test where c_name = :c_name")
	@Mapper(TestMapper.class)
	List<CreateClassTest> getCreateClassTest(@Bind("c_name")String c_name);
	
	@SqlUpdate("insert into test(c_name, c_password) values (:c_name, :c_password)")
	void insert(@Bind("c_name")String c_name, @Bind("c_password")String c_password);
	
	@SqlQuery("select * from test limit :startRow, :rowPerPage")
	@Mapper(TestMapper.class)
	List<CreateClassTest> getCreateClassTestLimit(@Bind("startRow")int startRow, @Bind("rowPerPage")int rowPerPage);

	@SqlQuery("select count(*) from test")
	@Mapper(IntegerMapper.class)
	int getMaxRowCount();
	
	@SqlUpdate("update test set c_name = :c_name, c_password = :c_password where id = :id")
	void change(@Bind("c_name")String c_name, @Bind("c_password")String c_password, @Bind("id")int id);
	
	@SqlUpdate("delete from test where id = :id")
	void delete(@Bind("id")int id);
	
	@SqlUpdate("insert into test "
			 + "set "
			 + "c_name = :c_name, "
			 + "c_password = :c_password, "
			 + "uuid = :uuid "
			 + "ON DUPLICATE KEY UPDATE "
			 + "c_password = 5 " 
			 )
	@GetGeneratedKeys
	int saveOrUpdate(@Bind("c_name")String a, @Bind("c_password")String b, @Bind("uuid")String c);
	
	void close();
	
}

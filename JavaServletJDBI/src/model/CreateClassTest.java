package model;

public class CreateClassTest {
	private int c_id;
	private String c_name;
	private String c_password;
	
	public CreateClassTest(String c_name, String c_password, int c_id) {
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_password = c_password;
	}
	
	public String getName() { return c_name; }
	public void setName(String c_name) { this.c_name = c_name; }
	public String getPassword() { return c_password; }
	public void setPassword(String c_password) { this.c_password = c_password;}
	public int getId() { return c_id;}
	public void setId(int c_id) { this.c_id = c_id;}
	
	
}

package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MysqlAdd;

@SuppressWarnings("serial")
public class MysqlInput extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String name = request.getParameter("c_name");
		String password = request.getParameter("c_password");
		MysqlAdd ma = new MysqlAdd();
		try {
			ma.add(name, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Practice2/rgstSuccess.html");		
	}
}

package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MysqlEd;

@SuppressWarnings("serial")
public class MysqlEdit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name_c");
		String password = request.getParameter("password_c");
		String id = (String) request.getSession().getAttribute("id_i");
		//System.out.println(id);
		int id_a = Integer.parseInt(id);
		MysqlEd me = new MysqlEd();
		try {
			me.change(name, password, id_a);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("search.html");
	}
}

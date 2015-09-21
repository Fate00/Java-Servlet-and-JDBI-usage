package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateClassTest;
import model.MysqlOprt;

@SuppressWarnings("serial")
public class MysqlOutput extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name_c");
		MysqlOprt mo = new MysqlOprt();
		List<CreateClassTest> ls = null;
		
		try {
			ls = mo.mysqlOp(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", ls);
		RequestDispatcher veiw = request.getRequestDispatcher("result.jsp");
		veiw.forward(request, response);
//		for(int i = 0; i < ls.size(); i++) {
//			CreateClassTest cct = ls.get(i);
//			System.out.println(cct.getName() + "  " + cct.getPassword());
//		}
	}
}

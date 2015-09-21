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
import model.MysqlList;

@SuppressWarnings("serial")
public class MysqlListAll extends HttpServlet {
	
	public int rowPerPage;
	public int curPage;
	public int maxPage;
	
	public MysqlListAll() {
		rowPerPage = 3;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//String curPage_t = (String) request.getAttribute("page");
		String curPage_t = request.getParameter("page");
		if(curPage_t == null) {
			curPage = 1;
			request.setAttribute("curPage", curPage);
		} else {
			curPage = Integer.parseInt(curPage_t);
			if(curPage < 1) {
				curPage = 1;
			}
			request.setAttribute("curPage", curPage);
		}
		
		MysqlList mlist = new MysqlList();
		List<CreateClassTest> ls = null;
		try {
			ls = mlist.ListAll(curPage, rowPerPage);
			maxPage = mlist.getMaxPage(rowPerPage);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ls", ls);
		request.setAttribute("maxPage", maxPage);
		RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);
	}
	
}

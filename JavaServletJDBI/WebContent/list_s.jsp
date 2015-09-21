<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mysql List</title>
</head>
<body>
<table>
  <%
  	CreateClassTest cct;
  	@SuppressWarnings("unchecked")
  	List<CreateClassTest> result = (List<CreateClassTest>)request.getAttribute("ls");
  	for(int i = 0; i < result.size(); i++) {
  		cct = result.get(i);
  	%><tr>
  		<td><%out.print(cct.getName()); %></td>
  		<td><%out.print(cct.getPassword()); %></td>
  		<td><a href="edit.jsp?name=<%out.print(cct.getName()); %>&password=<%out.print(cct.getPassword()); %>&id=<%out.print(cct.getId());%>">Edit</a>
  	  	<td><a href="delete.do?id=<%out.print(cct.getId());%>">Delete</a>
  	  </tr><%
  	}
  %>
</table>
</body>
</html>
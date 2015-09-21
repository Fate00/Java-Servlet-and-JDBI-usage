<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<h1 align="center">Edit</h1>
<%String id = request.getParameter("id");
  session.setAttribute("id_i", id);
  //out.println(id);
%>
<form method="GET" action="edit.do?id=">
  <input type="text" name="name_c" id="textfield" value="<%=request.getParameter("name") %>"/><p>
  <input type="password" name="password_c" id="textfield2" value="<%=request.getParameter("password") %>"/><p>
  
  <div align="left">
  	<input type="submit" name="button" id="button" value="submit"/>
  </div>
</form>
</body>
</html>
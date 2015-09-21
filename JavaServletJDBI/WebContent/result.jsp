<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<h1>Result: </h1>
<%
	List<CreateClassTest> result = (List<CreateClassTest>)request.getAttribute("list");
	for(int i = 0; i < result.size(); i++) {
		CreateClassTest cct = result.get(i);
		out.println(cct.getName() + " " + cct.getPassword());
	}
%>
</body>
</html>
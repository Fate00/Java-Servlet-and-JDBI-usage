<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
  <table>
  	<caption>List the data</caption>
  	<%int curPage = Integer.parseInt(request.getAttribute("curPage").toString()); 
  	  int maxPage = Integer.parseInt(request.getAttribute("maxPage").toString()); 
  	%>
  	<tr>
  	  <th>Name</th>
  	  <th>Password</th>
  	</tr>
  	<%
  	  CreateClassTest cct;
  	  @SuppressWarnings("unchecked")
  	  List<CreateClassTest> result = (List<CreateClassTest>)request.getAttribute("ls"); 
      for(int i = 0; i < result.size(); i++) {
    	 cct = result.get(i);
    %>
    <tr>
      <td><%out.print(cct.getName()); %></td>
  	  <td><%out.print(cct.getPassword()); %></td>
  	  <td><a href="edit.jsp?name=<%out.print(cct.getName()); %>&password=<%out.print(cct.getPassword()); %>&id=<%out.print(cct.getId());%>">Edit</a>
  	  <td><a href="delete.do?id=<%out.print(cct.getId());%>">Delete</a>
    </tr><%
      } 
    %>	
  </table>
  第<%=curPage %>页，共<%=maxPage %>页
 <%if(curPage > 1) {
 %>
 <a href="list.do?page=1">首页  </a>
 <a href="list.do?page=<%=curPage - 1 %>">上一页</a>
 <%} else {%>
 首页  上一页
 <%} %>
 <%if(curPage < maxPage) {
 %>
 <a href="list.do?page=<%=curPage + 1 %>">下一页  </a>
 <a href="list.do?page=<%=maxPage %>">尾页</a>
 <%} else {%>
 下一页  尾页 
 <%} %> 
 转至第<form name="form1" action="list.do" method="GET">
    <label>
      <select name="page" onchange="document.form1.submit()">
        <%for(int i = 1; i <= maxPage; i++) {
        	if(i == curPage) {
        %>
        <option selected value="<%=i %>"><%=i %></option>
        <%
          	} else {%>
          <option value="<%=i %>"><%=i %></option>
          <%}
          }
          %>
      </select>
    </label>
  </form>页
  
</body>
</html>
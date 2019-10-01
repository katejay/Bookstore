<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.bookstoreshop.pojo.*" %>
    <%@ page import="java.util.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2px">

<tr>
<th>Id</th>
<th>Dept_Name</th>
<th colspan="2">Action</th>
</tr>
<tr>
<%
List<Departmentpojo> blist2=(List<Departmentpojo>)session.getAttribute("Book11");//blist
if(blist2!=null && blist2.size()>0)
{
	for(int i=0;i<blist2.size();i++){
		
		Departmentpojo b1=blist2.get(i);
	%>
<th><%=b1.getDeptid() %></th>
<th><%=b1.getDeptname() %></th>


<!--<th><a href="BookstoresServlet?action=deleterecord&bookid=<%=b1.getDeptid()%>">Delete</a></th>
<th><a href="BookstoresServlet?action=editrecord&bookid=<%=b1.getDeptid()%>">Edit</a></th>-->
</tr>
<%}} %>
</table>
</body>
</html>
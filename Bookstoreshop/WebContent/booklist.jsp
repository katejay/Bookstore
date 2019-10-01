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
<th>Book_Name</th>
<th>Book_Author</th>
<th>Book_Price</th>
<th>Book_image</th>
<th colspan="2">Action</th>
</tr>
<tr>
<%
List<Bookstorepojo> blist2=(List<Bookstorepojo>)session.getAttribute("BooklistKey");//blist
if(blist2!=null && blist2.size()>0)
{
	for(int i=0;i<blist2.size();i++){
		
		Bookstorepojo b1=blist2.get(i);
	%>
<th><%=b1.getBookid() %></th>
<th><%=b1.getBookname() %></th>
<th><%=b1.getBookauthor() %></th>
<th><%=b1.getBookprice() %></th>
<th><img src="<%=b1.getBookimage()%>" width="100px" height="100px"></th>
<th><a href="BookstoresServlet?action=deleterecord&bookid=<%=b1.getBookid()%>">Delete</a></th>
<th><a href="BookstoresServlet?action=editrecord&bookid=<%=b1.getBookid()%>">Edit</a></th>
</tr>
<%}} %>
</table>
</body>
</html>
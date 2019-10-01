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
<%
Bookstorepojo b2=(Bookstorepojo)session.getAttribute("editrecord");
%>
<form action="BookstoresServlet" method="get">
BookName:<input type="text" name="bname" value="<%=b2.getBookname()%>"><br>
BookAuthor:<input type="text" name="bauthor" value="<%=b2.getBookauthor()%>"><br>
BookPrice:<input type="text" name="bprice" value="<%=b2.getBookprice()%>"><br>
BookId:<input type="text" name="bid" value="<%=b2.getBookid()%>"><br>
<input type="submit" name="action" value="Update1"><br>
</form>
</body>
</html>
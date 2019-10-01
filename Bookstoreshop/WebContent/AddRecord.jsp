<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookstoresServlet" method="post">
BookName:<input type="text" name="bname"><br>
BookAuthor:<input type="text" name="bauthor"><br>
BookPrice:<input type="text" name="bprice"><br>
<input type="submit" name="action" value="Add"><br>

</form>
</body>
</html>
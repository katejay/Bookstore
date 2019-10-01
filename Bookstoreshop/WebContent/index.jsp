<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.bookstoreshop.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
            <li><a href="index.html" class="current">Home</a></li>
            <li><a href="subpage.html">Search</a></li>
            <li><a href="subpage.html">Books</a></li>            
            <li><a href="subpage.html">New Releases</a></li>  
            <li><a href="#">Company</a></li> 
            <li><a href="#">Contact</a></li>
            <li><a href="Register.jsp">New Registration</a></li> 
            <li><a href="login.jsp">login</a></li>
             <li><a href="BookstoresServlet?action=showcart">Addcart</a></li>
            <%
List<Userpojo> blist4=(List<Userpojo>)session.getAttribute("uKey");//blist
if(blist4!=null && blist4.size()>0)
{
	for(int i=0;i<blist4.size();i++){
		
		Userpojo b1=blist4.get(i);
	%><li><%=b1.getUsername()%></li>
	<%}} %>
          
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $80
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
     <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Department</h1>
                <ul>
                    <%
List<Departmentpojo> blist1=(List<Departmentpojo>)session.getAttribute("Book11");//blist
if(blist1!=null && blist1.size()>0)
{
	for(int i=0;i<blist1.size();i++){
		
		Departmentpojo b1=blist1.get(i);
	%>
                    <li><a href="BookstoresServlet?action=getdeptname&dname=<%=b1.getDeptname()%>"><%=b1.getDeptname() %></a></li>
            <%}} %>
            	</ul>
            	
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Bestsellers</h1>
                <ul>
                    <li><a href="#">Vestibulum ullamcorper</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Praesent mattis varius</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="http://www.flashmo.com" target="_parent">Flash Templates</a></li>
                    <li><a href="http://www.templatemo.com" target="_parent">CSS Templates</a></li>
                    <li><a href="http://www.webdesignmo.com" target="_parent">Web Design</a></li>
                    <li><a href="http://www.photovaco.com" target="_parent">Free Photos</a></li>
            	</ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div>
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
        
        <%
List<Bookstorepojo> blist3=(List<Bookstorepojo>)session.getAttribute("BooklistKey");//blist
if(blist3!=null && blist3.size()>0)
{
	for(int i=0;i<blist3.size();i++){
		
		Bookstorepojo b1=blist3.get(i);
		if(i%2==0){
	%>
        	<div class="templatemo_product_box">
            	<h1><%=b1.getBookname() %>  <span>(by Best <%=b1.getBookauthor() %>)</span></h1>
   	      <img src="<%=b1.getBookimage() %>" alt="image" height="120px" width="80px" />
                <div class="product_info">
                	<p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
                  <h3>Rs<%=b1.getBookprice() %></h3>
                    <div class="buy_now_button"><a href="BookstoresServlet?action=addtocart&bookid=<%=b1.getBookid()%>">Add to cart</a></div>

                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_width">&nbsp;</div>
            <%} else { %>
            <div class="templatemo_product_box">
            	<h1><%=b1.getBookname() %>  <span>(by New <%=b1.getBookauthor() %>)</span></h1>
       	    <img src="<%=b1.getBookimage() %>" alt="image" height="120px" width="80px" />
                <div class="product_info">
                	<p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
                  <h3>Rs<%=b1.getBookprice() %></h3>
                     <div class="buy_now_button"><a href="BookstoresServlet?action=addtocart&bookid=<%=b1.getBookid()%>">Add to cart</a></div>

                   <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
          
            <div class="cleaner_with_height">&nbsp;</div>
             <%} } } %>
      
            
            <div class="cleaner_with_width">&nbsp;</div>
            
          
            
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    
    <div id="templatemo_footer">
    
	       <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2048 <a href="#"><strong>Your Company Name</strong></a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent" title="free css templates">Free CSS Templates</a>	</div> 
    <!-- end of footer -->
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>
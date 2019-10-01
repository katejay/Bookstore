package com.bookstoreshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstoreshop.dao.Departmentimpl;
import com.bookstoreshop.dao.Departmentintf;
import com.bookstoreshop.dao.Userdaoimpl;
import com.bookstoreshop.dao.Userdaointf;
import com.bookstoreshop.pojo.Departmentpojo;
import com.bookstoreshop.pojo.Userpojo;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
	Userdaointf bintf=new Userdaoimpl();
		List<Userpojo>blist=bintf.getAllRecords();
		session.setAttribute("uKey", blist);
		response.sendRedirect("index.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	
String jay=request.getParameter("action");
		
		if(jay!=null && jay.equals("Register")) {
			String username=request.getParameter("username");
			String emailid=request.getParameter("emailid");
			String upassnew=request.getParameter("pass3");
			System.out.println(upassnew);
			
			
			Userpojo u1=new Userpojo();
			u1.setUsername(username);
			u1.setEmailid(emailid);
			u1.setUpass(upassnew);
			
			
			Userdaointf uintf1=new Userdaoimpl();
			 boolean z=uintf1.addbook(u1);//true
			 
			 if(z)
			 {
				 response.sendRedirect("login.jsp");
				 
			 }
			 else {
				 
				 response.sendRedirect("Register.jsp");
			 }
			
		}
	
//for registration

/*if(jay!=null && jay.equals("Register")) {
	String username=request.getParameter("username");
	String emailid=request.getParameter("emailid");
	String password=request.getParameter("password3");
	
	
	Userpojo u1=new Userpojo();
	u1.setUsername(username);
	u1.setEmailid(emailid);
	u1.setUpass(password);
	
	
	Userdaointf uintf1=new Userdaoimpl();
	 boolean z=uintf1.addbook(u1);//true
	 
	 if(z)
	 {
		 response.sendRedirect("login.jsp");
		 
	 }
	 else {
		 
		 response.sendRedirect("Register.jsp");
	 }
	
}*/
else if(jay!=null && jay.equals("Login")) {
	
	String emailid=request.getParameter("emailid");
	String password=request.getParameter("password1");
	
	
	Userpojo u1=new Userpojo();
	u1.setEmailid(emailid);
	u1.setUpass(password);
	
	
	Userdaointf uintf1=new Userdaoimpl();
	
	boolean x=uintf1.logindetails(emailid,password);
	if(x)
	{
		response.sendRedirect("BookstoresServlet");
		
	}
	else {
		
		response.sendRedirect("Register.jsp");
	}
}

		 else if(jay!=null && jay.equals("Delete1")) {
			 int userid=Integer.parseInt(request.getParameter("userid"));
			 
			 Userpojo u2=new Userpojo();
				u2.setUserid(userid);
				
				Userdaointf uintf2=new Userdaoimpl();
				 boolean z=uintf2.delete(userid);//true
				 
				 if(z)
				 {
					 response.sendRedirect("success.jsp");
					 
				 }
				 else {
					 
					 response.sendRedirect("error.jsp");
				 }
				
			}
		 else if(jay!=null && jay.equals("update2")) {
				String b_name=request.getParameter("bname");
				String b_emailid=request.getParameter("bemailid");
				String b_password=request.getParameter("bpassword");
				int b_userid=Integer.parseInt(request.getParameter("buserid"));
				
				
				Userpojo b3=new Userpojo();
				b3.setUsername(b_name);
				b3.setEmailid(b_emailid);
				b3.setUpass(b_password);
				
				b3.setUserid(b_userid);
				
				Userdaointf uintf3=new Userdaoimpl();
				 boolean k =uintf3.update(b3);//true
				 
				 if(k)
				 {
					 response.sendRedirect("success.jsp");
					 
				 }
				 else {
					 
					 response.sendRedirect("error.jsp");
				 }
				
		 }
	}
	}
	

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
import com.bookstoreshop.pojo.Departmentpojo;



public class DepartmentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepartmentServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());



	HttpSession session=request.getSession();
	
	
	String jay=request.getParameter("action");
{	
Departmentintf bintf=new Departmentimpl();
	List<Departmentpojo>blist=bintf.getAllRecordS();
	session.setAttribute("BooklistKey", blist);
	response.sendRedirect("booklist1.jsp");
	}	

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
String jay=request.getParameter("action");
		
		if(jay!=null && jay.equals("Add")) {
			String b_name=request.getParameter("bname");
			
			Departmentpojo b1=new Departmentpojo();
			b1.setDeptname(b_name);
			
			
			Departmentintf bintf=new Departmentimpl();
			 boolean z=bintf.addbook(b1);//true
			 
			 if(z)
			 {
				 response.sendRedirect("success.jsp");
				 
			 }
			 else {
				 
				 response.sendRedirect("error.jsp");
			 }
			
		}
  else if(jay!=null && jay.equals("delete1")) {
			
			int b_id=Integer.parseInt(request.getParameter("bid"));
			
			Departmentpojo b2= new Departmentpojo();
			b2.setDeptid(b_id);
	
			
			Departmentintf bintf1=new Departmentimpl();
			boolean z =bintf1.delete(b_id);
			
			if(z)
			{
				response.sendRedirect("success.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
				
			}
		}
  else if(jay!=null && jay.equals("update1")) {
			String b_name=request.getParameter("bname");
			int b_id=Integer.parseInt(request.getParameter("bid"));
			
			
			Departmentpojo b1=new Departmentpojo();
			b1.setDeptname(b_name);
			b1.setDeptid(b_id);
			
			Departmentintf bintf3=new Departmentimpl();
			 boolean z=bintf3.update(b1);//true
			 
			 if(z)
			 {
				 response.sendRedirect("success.jsp");
				 
			 }
			 else {
				 
				 response.sendRedirect("error.jsp");
			 }
			
		}
		
					}

}

package com.bookstoreshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstoreshop.dao.Bookstoredaoimpl;
import com.bookstoreshop.dao.Bookstoredaointf;
import com.bookstoreshop.dao.Departmentimpl;
import com.bookstoreshop.dao.Departmentintf;
import com.bookstoreshop.dao.Userdaoimpl;
import com.bookstoreshop.dao.Userdaointf;
import com.bookstoreshop.pojo.Bookstorepojo;
import com.bookstoreshop.pojo.Departmentpojo;
import com.bookstoreshop.pojo.Userpojo;

/**
 * Servlet implementation class BookstoresServlet
 */
public class BookstoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookstoresServlet() {
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
		
		
		String jay=request.getParameter("action");
		if(jay!=null && jay.equals("deleterecord")) {
			int b_id=Integer.parseInt(request.getParameter("bookid"));
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookid(b_id);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
			boolean z=bintf.delete(b_id);
			if(z) {
				response.sendRedirect("BookstoresServlet");
			}
			
		}
		
		else if(jay!=null && jay.equals("editrecord")) {
			
			int b_idupdate=Integer.parseInt(request.getParameter("bookid"));
			
			Bookstorepojo b1=new  Bookstorepojo();
			b1.setBookid(b_idupdate);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
					b1=bintf.getRecordsbyid(b_idupdate);
				session.setAttribute("editrecord", b1);
				response.sendRedirect("updatepreviouserecord.jsp");
			
		}
		else if(jay!=null && jay.equals("Update1")) {
			String b_name=request.getParameter("bname");
			String b_author=request.getParameter("bauthor");
			int b_price=Integer.parseInt(request.getParameter("bprice"));
			int b_id=Integer.parseInt(request.getParameter("bid"));			
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookname(b_name);
			b1.setBookauthor(b_author);
			b1.setBookprice(b_price);
			b1.setBookid(b_id);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
			 boolean z=bintf.update(b1);
			 
			 if(z)
			 {
				 response.sendRedirect("BookstoresServlet");
				 
			 }
		}
		else if(jay!=null && jay.equals("getdeptname"))
		{
			
			String bdeptname=request.getParameter("dname");//novel
			
			Bookstorepojo b1=new  Bookstorepojo();
			b1.setDeptname(bdeptname);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
			List<Bookstorepojo> blist=bintf.getRecordsbydname(bdeptname);
			session.setAttribute("BooklistKey", blist);
			
			Departmentintf bintf1=new Departmentimpl();
			List<Departmentpojo>blist2=bintf1.getAllRecordS();
			session.setAttribute("Book11", blist2);
			response.sendRedirect("index.jsp");
			
			
		}
		
		else if(jay!=null && jay.equals("addtocart"))
		{
			
			if(session.getAttribute("cartlist")==null) {
				ArrayList<Bookstorepojo> clist=new ArrayList<Bookstorepojo>();
				int id=Integer.parseInt(request.getParameter("bookid"));
				Bookstorepojo b=new Bookstorepojo();
				b.setBookid(id);
				Bookstoredaointf bintf1=new Bookstoredaoimpl();
						b=bintf1.getRecordsbyid(id);
				clist.add(b);
				session.setAttribute("cartlist", clist);
				
				response.sendRedirect("BookstoresServlet");
			}
			else {
				ArrayList<Bookstorepojo> clist=new ArrayList<Bookstorepojo>();
				int id=Integer.parseInt(request.getParameter("bookid"));
				Bookstorepojo b=new Bookstorepojo();
				b.setBookid(id);
				Bookstoredaointf bintf1=new Bookstoredaoimpl();
				b=bintf1.getRecordsbyid(id);
				clist=(ArrayList<Bookstorepojo>)session.getAttribute("cartlist");
				clist.add(b);
                 session.setAttribute("cartlist", clist);
				
				response.sendRedirect("BookstoresServlet");
				
				
				
			}
			}
		else if(jay!=null && jay.equals("showcart")){	
			
			response.sendRedirect("cartlist.jsp");
		}
		else{
			Bookstoredaointf bintf=new Bookstoredaoimpl();
		List<Bookstorepojo>	blist=bintf.getAllRecords();//alist
		session.setAttribute("BooklistKey", blist);
		//response.sendRedirect("booklist.jsp");//booklist
		
		//now for templete
		//response.sendRedirect("index.jsp");
	
		
		Departmentintf bintf1=new Departmentimpl();
		List<Departmentpojo>blist2=bintf1.getAllRecordS();
		session.setAttribute("Book11", blist2);
		
		
		Userdaointf bintf5=new Userdaoimpl();
		List<Userpojo>blist3=bintf5.getAllRecords();
		session.setAttribute("uKey", blist3);
		response.sendRedirect("index.jsp");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String jay=request.getParameter("action");
		
		if(jay!=null && jay.equals("Add")) {
			String b_name=request.getParameter("bname");
			String b_author=request.getParameter("bauthor");
			int b_price=Integer.parseInt(request.getParameter("bprice"));
			
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookname(b_name);
			b1.setBookauthor(b_author);
			b1.setBookprice(b_price);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
			 boolean z=bintf.addbook(b1);//true
			 
			 if(z)
			 {
				 response.sendRedirect("success.jsp");
				 
			 }
			 else {
				 
				 response.sendRedirect("error.jsp");
			 }
			
		}
		
		else if(jay!=null && jay.equals("Delete")) {
			
			int b_id=Integer.parseInt(request.getParameter("bid"));
			
			Bookstorepojo b1= new Bookstorepojo();
			b1.setBookid(b_id);
			
			Bookstoredaointf bintf1=new Bookstoredaoimpl();
			boolean y=bintf1.delete(b_id);
			
			if(y)
			{
				response.sendRedirect("success.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
				
			}
		}
		
		if(jay!=null && jay.equals("Update")) {
			String b_name=request.getParameter("bname");
			String b_author=request.getParameter("bauthor");
			int b_price=Integer.parseInt(request.getParameter("bprice"));
			int b_id=Integer.parseInt(request.getParameter("bid"));		
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookname(b_name);
			b1.setBookauthor(b_author);
			b1.setBookprice(b_price);
			b1.setBookid(b_id);
			
			Bookstoredaointf bintf=new Bookstoredaoimpl();
			 boolean z=bintf.update(b1);
			 
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

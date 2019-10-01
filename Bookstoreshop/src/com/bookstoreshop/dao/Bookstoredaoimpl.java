package com.bookstoreshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstoreshop.pojo.Bookstorepojo;
import com.bookstoreshop.util.MyConnection;

public class Bookstoredaoimpl implements Bookstoredaointf {

	public boolean addbook(Bookstorepojo b) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("insert into bookstore(bookname,bookauthor,bookprice,bookimage) values(?,?,?,?)");
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getBookauthor());
			ps.setInt(3, b.getBookprice());
			ps.setString(4, b.getBookimage());

			
			int x=ps.executeUpdate();
			System.out.println("inserted");
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean delete(int bookid) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("delete from bookstore where bookid=?");
			ps.setInt(1, bookid);
			
			int x=ps.executeUpdate();
			System.out.println("deleted");
			if(x>0) {
				
				return true;
				
			}
			else {
				
				return false;
			}
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
				
		
		
		return false;
	}

	public boolean update(Bookstorepojo b) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("update bookstore set bookname=?,bookauthor=?,bookprice=? where bookid=?");
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getBookauthor());
			ps.setInt(3, b.getBookprice());
			ps.setInt(4, b.getBookid());
			
			int x=ps.executeUpdate();
			System.out.println("updated");
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Bookstorepojo> getAllRecords() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			ArrayList<Bookstorepojo> alist=new ArrayList<Bookstorepojo>();
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from bookstore");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Bookstorepojo b1=new Bookstorepojo();
				b1.setBookid(rs.getInt("bookid"));
				b1.setBookname(rs.getString("bookname"));
				b1.setBookauthor(rs.getString("bookauthor"));
				b1.setBookprice(rs.getInt("bookprice"));
				b1.setBookimage(rs.getString("bookimage"));
				
				alist.add(b1);	
			}
			return alist;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	
		return null;
	}

	public Bookstorepojo getRecordsbyid(int bookid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from bookstore where bookid=?");
			ps.setInt(1, bookid);
			ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookname(rs.getString("bookname"));
			b1.setBookauthor(rs.getString("bookauthor"));
			b1.setBookprice(rs.getInt("bookprice"));
			b1.setBookimage(rs.getString("bookimage"));
			b1.setBookid(rs.getInt("bookid"));
			return b1;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Bookstorepojo> getRecordsbydname(String deptname) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			ArrayList<Bookstorepojo> alist=new ArrayList<Bookstorepojo>();
			
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from bookstore where deptname=?");
			ps.setString(1, deptname);
			ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			Bookstorepojo b1=new Bookstorepojo();
			b1.setBookid(rs.getInt("bookid"));
			b1.setBookname(rs.getString("bookname"));
			b1.setBookauthor(rs.getString("bookauthor"));
			b1.setBookprice(rs.getInt("bookprice"));
			b1.setBookimage(rs.getString("bookimage"));
			b1.setDeptname(rs.getString("deptname"));
			alist.add(b1);
		}
		return alist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

}

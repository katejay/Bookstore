package com.bookstoreshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstoreshop.pojo.Bookstorepojo;
import com.bookstoreshop.pojo.Departmentpojo;
import com.bookstoreshop.pojo.Userpojo;
import com.bookstoreshop.util.MyConnection;

public class Userdaoimpl implements Userdaointf{

	public boolean addbook(Userpojo u) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("insert into userdata(username,emailid,upass) values(?,?,?)");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getEmailid());
			ps.setString(3, u.getUpass());
			
			
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
	
	
	
	public boolean delete(int userid) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("delete from userdata where userid=?");
			ps.setInt(1, userid);
			
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
	
	public boolean update(Userpojo b) {
			// TODO Auto-generated method stub
			
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				conn=MyConnection.getallConnection();//con
				ps=conn.prepareStatement("update userdata set username=?,emailid=?,upass=? where userid=?");
				ps.setString(1,b.getUsername());
				ps.setString(2, b.getEmailid());
				ps.setString(3,b.getUpass());
				ps.setInt(4,b.getUserid());
				
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

	public List<Userpojo> getAllRecords() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			ArrayList<Userpojo> alist=new ArrayList<Userpojo>();
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from userdata");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Userpojo b1=new Userpojo();
				b1.setUserid(rs.getInt("userid"));
				b1.setUsername(rs.getString("username"));
				b1.setEmailid(rs.getString("emailid"));
				b1.setUpass(rs.getString("upass"));
				alist.add(b1);	
			}
			return alist;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	
		return null;
	}



	public boolean logindetails(String emailid, String upass) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from userdata where emailid=? and upass=?");
		ps.setString(1, emailid);
		ps.setString(2, upass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
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

	
	}
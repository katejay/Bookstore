package com.bookstoreshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstoreshop.pojo.Departmentpojo;
import com.bookstoreshop.util.MyConnection;


public class Departmentimpl implements Departmentintf {

	public boolean addbook(Departmentpojo b) {
		// TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement ps=null;
	try {
		con=MyConnection.getallConnection();//con
		ps=con.prepareStatement("insert into dept(deptid,deptname) values(?,?)");
		
		ps.setInt(1, b.getDeptid());
		ps.setString(2, b.getDeptname());
		
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

	public boolean delete(int deptid) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("delete from dept where deptid=?");
			ps.setInt(1, deptid);
			
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

	public boolean update(Departmentpojo b) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=MyConnection.getallConnection();//con
			ps=conn.prepareStatement("update dept set deptname=? where deptid=?");
			ps.setString(1,b.getDeptname());
			ps.setInt(2, b.getDeptid());
			
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

	public List<Departmentpojo> getAllRecordS() {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			ArrayList<Departmentpojo> alist=new ArrayList<Departmentpojo>();
			conn=MyConnection.getallConnection();
			ps=conn.prepareStatement("select * from dept");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Departmentpojo b1=new Departmentpojo();
				b1.setDeptid(rs.getInt("deptid"));
				b1.setDeptname(rs.getString("deptname"));
				
				alist.add(b1);	
			}
			return alist;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	
		return null;
	}


	  
}

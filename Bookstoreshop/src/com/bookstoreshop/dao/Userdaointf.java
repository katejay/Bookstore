package com.bookstoreshop.dao;

import java.util.List;

import com.bookstoreshop.pojo.Bookstorepojo;
import com.bookstoreshop.pojo.Userpojo;

public interface Userdaointf {
	public boolean addbook(Userpojo u);
	public boolean delete(int userid);
	public boolean update(Userpojo b);
	public List<Userpojo> getAllRecords();
	public boolean logindetails(String emailid,String upass);
	
}


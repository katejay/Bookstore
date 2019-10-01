package com.bookstoreshop.dao;

import java.util.List;

import com.bookstoreshop.pojo.Bookstorepojo;

public interface Bookstoredaointf 
{
	
public boolean addbook(Bookstorepojo b);
public boolean delete(int bookid);
public boolean update(Bookstorepojo b);
public List<Bookstorepojo> getAllRecords();
public Bookstorepojo getRecordsbyid(int bookid);

public List<Bookstorepojo> getRecordsbydname(String deptname);
}

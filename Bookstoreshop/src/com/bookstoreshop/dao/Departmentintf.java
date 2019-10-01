package com.bookstoreshop.dao;

import java.util.List;

import com.bookstoreshop.pojo.Departmentpojo;

public interface Departmentintf {

	public boolean addbook(Departmentpojo b);
	public boolean delete(int deptid);
	public boolean update(Departmentpojo b);
	public List<Departmentpojo> getAllRecordS();

}

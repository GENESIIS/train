package com.genesiis.hra.model;

import java.util.List;


public interface IDataAccessor {
	public String add(Object object);

	public String update(Object object);

	public String delete(Object object);

	public Employees retrive(String id);

	public List<Object> getAll();
}
 
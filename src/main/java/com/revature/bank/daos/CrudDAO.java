package com.revature.bank.DAOs;

import com.revature.bank.utilities.List;

public interface CrudDAO<T> {
	
	T create(T newObj);
	
	List<T> findAll();
	T findById(String id);
	
	
	
	boolean delete (T deleteObj);

}

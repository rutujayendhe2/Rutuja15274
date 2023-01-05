package com.training.cakeapp.collection;

import java.sql.SQLException;
import java.util.List;

public interface ICollection<T> {

	List<T> findAll() throws SQLException;
	T findOne(int id) throws SQLException;
	boolean createNew(T t) throws SQLException;
	boolean findOneAndDelete(int id) throws SQLException;
	boolean findOneAndUpdate(int id,T t) throws SQLException;
}

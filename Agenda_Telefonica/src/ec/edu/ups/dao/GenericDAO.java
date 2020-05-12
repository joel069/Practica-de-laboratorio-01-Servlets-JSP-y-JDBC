package ec.edu.ups.dao;


import java.util.List;

import ec.edu.ups.modelo.telefono;


public interface GenericDAO<T, ID> {

	public void createTable();

	public boolean create(T entity);

	public T read(ID id);

	public boolean update(T entity);

	public boolean delete(T entity);

	public List<T> find();
	
	public T findById(ID id);

	

}
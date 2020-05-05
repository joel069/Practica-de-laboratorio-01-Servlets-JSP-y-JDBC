package datos;

import java.util.List;

public interface GenericDAO<T, ID> {
	
	public void createTable();

	public void create(T entity);

	public T read(String cedula);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();

}

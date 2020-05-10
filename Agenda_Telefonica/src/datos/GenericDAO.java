package datos;

import java.util.List;

public interface GenericDAO<T, ID> {
	
	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);
	
	public int buscar(String correo, String clave);

	public List<T> find();
	
	public String cedula(String cedu);

}

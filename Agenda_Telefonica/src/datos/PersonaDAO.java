package datos;


import modelo.Persona;

public interface PersonaDAO extends GenericDAO<Persona , String>{
	
	public Persona buscarCorreo(String correo);

}

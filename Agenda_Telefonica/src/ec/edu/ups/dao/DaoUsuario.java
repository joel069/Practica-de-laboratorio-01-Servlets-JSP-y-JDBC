package ec.edu.ups.dao;



import java.util.List;

import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;

public interface DaoUsuario extends GenericDAO<user, String> {

	public abstract user findPrsona(String correo, String contrasena);

	public abstract List<user> findByIdOrMail(String context);


}

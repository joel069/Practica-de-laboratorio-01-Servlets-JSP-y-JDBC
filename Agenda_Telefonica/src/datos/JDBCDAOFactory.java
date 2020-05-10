package datos;

import jdbc.JDBCPersonaDAO;
import jdbc.JDBCTelefonoDAO;

public class JDBCDAOFactory extends DAOFactory{
	
	@Override
	public void createTables() {
		this.getPersonaDAO().createTable();
		this.getTelefonoDAO().createTable();
	}
	
	@Override 
	public PersonaDAO getPersonaDAO() {
		return new JDBCPersonaDAO();
	}
	
	@Override 
	public TelefonoDAO getTelefonoDAO() {
		return new JDBCTelefonoDAO();
	}
	
}

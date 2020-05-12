package ec.edu.ups.dao;


import ec.edu.ups.mysql.jdbc.JDBCTelefonoDAO;
import ec.edu.ups.mysql.jdbc.JDBCUserDAO;


public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getUsuarioDAO().createTable();
		this.getTelefonoDAO().createTable();

	}

	@Override
	public DaoUsuario getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JDBCUserDAO();
	}

	@Override
	public DaoTelefono getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}



	
}

package ec.edu.ups.dao;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JDBCDAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}

	public abstract void createTables();

	public abstract DaoUsuario getUsuarioDAO();

	public abstract DaoTelefono getTelefonoDAO();

	

}


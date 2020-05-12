package ec.edu.ups.mysql.jdbc;


import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoUsuario;
import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claum
 */
public class JDBCUserDAO extends JDBCGenericDAO<user, String> implements DaoUsuario {

    @Override
    public void createTable() {
        conexionUno.update("CREATE TABLE IF NOT EXISTS usuario (" + "	usu_cedula VARCHAR(10) NOT NULL," + "	usu_nombre VARCHAR(50),"
                + "	usu_apellido VARCHAR(50)," + "	usu_correo VARCHAR(100),"+ "	usu_pass VARCHAR(255),"+ "	PRIMARY KEY (usu_cedula)" + ");");
    }

    @Override
    public boolean create(user user) {
        return conexionUno.update("INSERT INTO usuario VALUES ('" + user.getCedula() + "', '" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getEmail() + "', '" + user.getPassword() + "');");
    }

    @Override
    public user findById(String cedula) {
        user user = null;
        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_cedula = '" + cedula + "';");
        try {
            if (rs != null && rs.next()) {
                user = new user(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
                List<telefono> phones = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(user.getCedula());
                user.setTelefono(phones);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
        }
        return user;
    }

    @Override
    public boolean update(user user) {
        return conexionUno.update("UPDATE usuario SET "
                + "	usu_nombre = '" + user.getNombre() + "',"
                + "	usu_apellido = '" + user.getApellido() + "',"
                + "	usu_pass  = '" + user.getPassword()+ "'"
                + "	WHERE usu_cedula = '" + user.getCedula() + "';");
    }

    @Override
    public boolean delete(user user) {
      return conexionUno.update("UPDATE usuario SET "
                + "	WHERE usu_cedula = '" + user.getCedula() + "';");
    }

    @Override
    public List<user> find() {
        List<user> users = new ArrayList<>();

        ResultSet rs = conexionUno.query("SELECT * FROM usuario;");
        try {
            while (rs.next()) {
                user user = new user(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
                List<telefono> phones = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(user.getCedula());
                user.setTelefono(phones);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:find): " + e.getMessage());
        }
        return users;
    }

    @Override
    public user findPrsona(String correo, String pass) {
       //System.out.println("Usuario: "+correo+" Pass: "+pass);
       user user = null;
        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_correo = '"+correo+"' AND usu_pass = '"+pass+"';");
        try {
            if (rs != null && rs.next()) {
                user = new user(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
                List<telefono> phones = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(user.getCedula());
                user.setTelefono(phones);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:findUser): " + e.getMessage());
        }
        return user; 
    }
    
    @Override
    public List<user> findByIdOrMail(String context) {
        List<user> users = new ArrayList<>();
        if (context.equals("all")) {
            ResultSet rs = conexionUno.query("SELECT * FROM usuario;");
            try {
                if (rs != null && rs.next()) {
                	user user = new user(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_pass"));
                    List<telefono> phones = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(user.getCedula());
                    user.setTelefono(phones);
                    users.add(user);
                }
            } catch (SQLException e) {
                System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
            }
            System.out.println("Todos los usuarios....."+users.toString());
        } else {
            ResultSet rs = conexionUno.query("SELECT * FROM usuario "
                    + "WHERE usu_cedula = '" + context + "' OR usu_correo = '" + context + "';");
            try {
                if (rs != null && rs.next()) {
                	user user = new user(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_pass"));
                    List<telefono> phones = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(user.getCedula());
                    user.setTelefono(phones);
                    users.add(user);
                }
            } catch (SQLException e) {
                System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
            }
        }

        return users;
    }

	@Override
	public user read(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

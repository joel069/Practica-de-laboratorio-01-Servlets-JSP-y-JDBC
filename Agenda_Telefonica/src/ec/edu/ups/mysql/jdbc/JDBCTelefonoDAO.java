package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.modelo.telefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claum
 */
public class JDBCTelefonoDAO extends JDBCGenericDAO<telefono, Integer> implements DaoTelefono {

	@Override
	public void createTable() {
		conexionDos.update("CREATE TABLE IF NOT EXISTS telefono (" + "	tel_id INT NOT NULL AUTO_INCREMENT,"
				+ "	tel_numero VARCHAR(20)," + "	tel_tipo  VARCHAR(50)," + "	tel_operadora VARCHAR(50),"
				+ "	usu_cedula VARCHAR(10) NOT NULL," + "	PRIMARY KEY (tel_id),"
				+ "	FOREIGN KEY (usu_cedula) REFERENCES usuario(usu_cedula)" + ");");
	}

	@Override
	public boolean create(telefono phone) {

		return conexionDos.update("INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora, usu_cedula) "
				+ "VALUES ('" + phone.getNumero() + "', '" + phone.getTipo() + "', '" + phone.getOperadora() + "', '"
				+ phone.getUser().getCedula() + "');");
	}

	@Override
	public telefono findById(Integer id) {
		telefono phone = null;
		ResultSet rs = conexionUno.query("Select * FROM telefono WHERE tel_id = " + id + ";");
		try {
			if (rs != null && rs.next()) {

				
				phone = new telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				phone.setCodigo(rs.getInt("tel_id"));
				
				System.out.println("Tle: " + phone.toString());
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
		}
		return phone;
	}

	@Override
	public boolean update(telefono phone) {
		return conexionDos.update("UPDATE telefono SET " + "	tel_numero = '" + phone.getNumero() + "',"
				+ "	tel_tipo = '" + phone.getTipo() + "'," + "	tel_operadora = '" + phone.getOperadora() + "'"
				+ "WHERE tel_id = '" + phone.getCodigo() + "' AND usu_cedula = '" + phone.getUser().getCedula() + "';");
	}

	@Override
	public boolean delete(telefono phone) {
		return conexionDos.update("DELETE FROM telefono WHERE tel_id = '" + phone.getCodigo() + "' AND usu_cedula = '"
				+ phone.getUser().getCedula() + "';");

	}

	@Override
	public List<telefono> find() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<telefono> findByPersonaId(String cedula) {
		List<telefono> phones = new ArrayList<>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
		try {
			while (rs.next()) {
				telefono phone = new telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				phone.setCodigo(rs.getInt("tel_id"));
				// phone.setUser(DAOFactory.getFactory().getUsuarioDAO().findById(rs.getString("usu_cedula")));
				phones.add(phone);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
		}
		return phones;
	}

	@Override
	public telefono read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<telefono> findBySearchTelf(String cedula, String numero) {
		List<telefono> phones = new ArrayList<>();

		ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE tel_numero = '" + numero + "';");
		try {
			while (rs.next()) {
				telefono phone = new telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				phone.setCodigo(rs.getInt("tel_id"));
				phone.setUser(DAOFactory.getFactory().getUsuarioDAO().findById(cedula));
				// phone.setUser(DAOFactory.getFactory().getUsuarioDAO().findById(rs.getString("usu_cedula")));
				phones.add(phone);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
		}
		return phones;
	}

}

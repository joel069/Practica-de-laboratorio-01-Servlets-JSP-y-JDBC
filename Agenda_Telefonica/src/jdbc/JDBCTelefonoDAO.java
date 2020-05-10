package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.TelefonoDAO;
import modelo.Persona;
import modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String> implements TelefonoDAO{

	@Override
	public void createTable() {
		conexionUno.update("DROP TABLE IF EXISTS Telefono");
		conexionUno.update("CREATE TABLE Telefono(" + "codigo INT NOT NULL, " + "numero INT NOT NULL, "
				+ "tipo VARCHAR(255), " + "operadora VARCHAR(255),"  + "PRIMARY KEY (codigo))");
		
	}

	@Override
	public void create(Telefono telefono) {
		conexionUno.update("INSERT Telefono VALUES (" + telefono.getCodigo() + ", '" + telefono.getNumero() + "', '"
				+ telefono.getTipo() + "," + telefono.getOperadora() + "')");
		
	}

	@Override
	public Telefono read(String id) {
		
		Telefono telefono = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono WHERE codigo=" + id);
		try {
			if (rs != null && rs.next()) {
				telefono = new Telefono(rs.getInt("codigo"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}

		
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		
		conexionUno.update("UPDATE Telefono SET numero= ' " + telefono.getNumero() + " ', tipo = '" 
				+telefono.getTipo() + " ', operadora = '" + telefono.getOperadora());
		
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		
		conexionUno.update("DELETE FROM Telefono WHERE id =" + telefono.getCodigo());
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> lis = new ArrayList<Telefono>();
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono");
		try {
			while (rs.next()) {
				lis.add(new Telefono(rs.getInt("codigo"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora")));
			}
			
		}catch(SQLException e){
			System.out.println(">>>WARNING (JDBCPersona:find): " + e.getMessage());
		}for(Telefono tel: lis) {
			System.out.println(tel.getCodigo() + "," + tel.getNumero() + "," + tel.getTipo() + "," + tel.getOperadora());
		}
		return lis;
	}
	
	@Override
	public int buscar(String correo, String clave) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	@Override
	public String cedula(String cedu) {
		// TODO Auto-generated method stub
		String cedula = null;
		Persona per = null;
		cedula = per.getCedula();
		ResultSet rs = conexionUno.query("SELECT * FROM Persona WHERE cedula='"+per.getCedula());
		try {
			if( rs != null && rs.next()) {
				cedula = rs.getString("cedula");
			}
		}catch(SQLException e) {
			
		}
		return cedula;
		
	}

}

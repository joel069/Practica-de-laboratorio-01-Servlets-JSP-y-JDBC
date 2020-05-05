package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import datos.PersonaDAO;

import modelo.Persona;

public class JDBCPersonaDAO extends  JDBCGenericDAO<Persona, Integer> implements PersonaDAO {
	
	@Override
	public void createTable() {
		conexionUno.update("DROP TABLE IF EXISTS Persona");
		conexionUno.update("CREATE TABLE Persona(" + "Cedula STRING NOT NULL, " + "Nombre VARCHAR(255), "
				+ "Apellido VARCHAR(255), " + "Correo VARCHAR(255)," + "Clave VARCHAR(255) NOT NULL," + "PRIMARY KEY (Cedula))");
	}

	@Override
	public void create(Persona persona) {
		conexionUno.update("INSERT Persona VALUES (" + persona.getCedula() + ", '" + persona.getNombre() + "', '"
				+ persona.getApellido() + "," + persona.getCorreo() + "," + persona.getClave() + "')");
	}

	
	@Override
	public Persona read(String cedula) {
		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Persona WHERE Cedula=" + cedula);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return persona;
		
	}

	@Override
	public void update(Persona persona) {
		  conexionUno.update("Update Persona SET nombre = ' " + persona.getNombre() + "', apellido = ' " 
				  + persona.getApellido() + "', correo= ' " + persona.getCorreo() + "', clave= ' "
				  + persona.getClave() + "' WHERE cedula = " + persona.getCedula());
		
	}

	@Override
	public void delete(Persona persona) {
		
		conexionUno.update("DELETE FROM Persona WHERE id = " + persona.getCedula());	
	}

	@Override
	public List<Persona> find() {
		List<Persona> list = new ArrayList<Persona>();
		ResultSet rs = conexionUno.query("SELECT * FROM Persona");
		try {
			while (rs.next()) {
				list.add(new Persona(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave")));
			}
			
		}catch(SQLException e){
			System.out.println(">>>WARNING (JDBCCategoryDAO:find): " + e.getMessage());
		}
		return list;
	}
	
}

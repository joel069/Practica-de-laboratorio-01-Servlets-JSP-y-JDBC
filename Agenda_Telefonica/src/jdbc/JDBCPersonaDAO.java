package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import datos.DAOFactory;
import datos.PersonaDAO;
import modelo.Persona;
import modelo.Telefono;;

public class JDBCPersonaDAO extends  JDBCGenericDAO<Persona, String> implements PersonaDAO {
	
	
	@Override
	public void create(Persona persona) {
		conexionUno.update("INSERT Persona VALUES ('" + persona.getCedula() + " ' ,' " + persona.getNombre() + " ', '"
				+ persona.getApellido() + " ',' " + persona.getCorreo() + " ', '" + persona.getClave() + " ' ) ;");
	    Set<Telefono> telefonos = persona.getTelefonos();
	    if(telefonos != null) {
	    	for(Telefono telefono : telefonos)
	    		DAOFactory.getFactory().getTelefonoDAO().create(telefono);
	    }
	}

	
	@Override
	public Persona buscarCorreo(String correo) {
		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Persona WHERE correo=" + correo+"';");
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		if (persona==null) {
			
			return null;
		}
		
		Set<Telefono> telefonos=DAOFactory.getFactory().getTelefonoDAO().buscarCedula(persona.getCedula());
		if (telefonos !=null) {
			Set<Telefono> telefonosList=new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setPersona(persona);
				telefonosList.add(telefono);				
			}
			persona.setTelefonos(telefonosList);
		}
		

		return persona;
		
	}
	
	@Override
	public Persona read(String cedula) {
		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Persona WHERE correo=" + cedula+"';");
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		if (persona==null) {
			
			return null;
		}
		
		Set<Telefono> telefonos=DAOFactory.getFactory().getTelefonoDAO().buscarCedula(persona.getCedula());
		if (telefonos !=null) {
			Set<Telefono> telefonosList=new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setPersona(persona);
				telefonosList.add(telefono);				
			}
			persona.setTelefonos(telefonosList);
		}
		

		return persona;
		
	}

	@Override
	public void update(Persona persona) {
		  conexionUno.update("UPDATE Persona SET nombre = ' " + persona.getNombre() + "', apellido = ' " 
				  + persona.getApellido() + "', correo= ' " + persona.getCorreo() + "', clave= ' "
				  + persona.getClave() + "' WHERE cedula = " + persona.getCedula());
		
	}

	@Override
	public void delete(Persona persona) {
		
		conexionUno.update("DELETE FROM Persona WHERE cedula = " + persona.getCedula());	
	}

	@Override
	public List<Persona> find() {
		List<Persona> list = new ArrayList<Persona>();
		ResultSet rs = conexionUno.query("SELECT * FROM Persona");
		try {
			while (rs.next()) {
				Persona persona =new Persona(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
			Set<Telefono> telefonos= DAOFactory.getFactory().getTelefonoDAO().buscarCedula(persona.getCedula());
			if (telefonos != null) {
				
				Set<Telefono> telf= new HashSet<Telefono>();
				for (Telefono telefono : telefonos) {
					telefono.setPersona(persona);
					telf.add(telefono);
					persona.setTelefonos(telf);
				}
			}
			
			list.add(persona);
			}
			
		}catch(SQLException e){
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
			
			return null;
			
		}
		
		return list;
	}
	
	

	
}

package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.DAOFactory;
import datos.TelefonoDAO;
import modelo.Persona;
import modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String > implements TelefonoDAO{

	
	@Override
	public void create(Telefono telefono) {
		conexionUno.update("INSERT INTO `agenda`.`Telefono` (`cedula`,`numero`,`tipo`,`operadora`)" +
	    "VALUES (' " + telefono.getPersona().getCedula() + " ' , ' " + telefono.getNumero() + "', '"
				+ telefono.getTipo() + " ', '" + telefono.getOperadora() + " ') ;");
		
	}

	@Override
	public Telefono read(String num) {
		
		Telefono telefono = null;
		
		
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono WHERE numero=" + num);
		try {
			if (rs != null && rs.next()) {
				telefono = new Telefono( rs.getInt("codigo"),rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora"));
				ResultSet rsPers=conexionDos.query("SELECT * FROM persona WHERE cedula='"+rs.getString("cedula")+"');");
				if (rsPers !=null && rsPers.next()) {
					Persona persona=new Persona();
					persona.setCedula(rsPers.getString("cedula"));
					persona.setNombre(rsPers.getString("nombre"));
					persona.setApellido(rsPers.getString("apellido"));
					persona.setCorreo(rsPers.getString("correo"));
					persona.setClave(rsPers.getString("clave"));
					telefono.setPersona(persona);
			  }
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
				+telefono.getTipo() + " ', operadora = '" + telefono.getOperadora()+ " ' WHERE codigo = " + telefono.getCodigo());
		
		
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		
		conexionUno.update("DELETE FROM Telefono WHERE codigo =" + telefono.getCodigo());
	}
	
	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> lis = new ArrayList<Telefono>();
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono");
		try {
			while (rs.next()) {
				Telefono telefono = new Telefono( rs.getInt("codigo"),rs.getString("numero"), rs.getString("tipo"),rs.getString("operadora"));
				ResultSet rsPer = conexionDos.query("SELECT * FROM persona WHERE cedula='"+rs.getString("cedula")+"';");
				if (rsPer !=null && rsPer.next()) {
					Persona persona=new Persona();
					persona.setCedula(rsPer.getString("cedula"));
					persona.setNombre(rsPer.getString("nombre"));
					persona.setApellido(rsPer.getString("apellido"));
					persona.setCorreo(rsPer.getString("correo"));
					persona.setClave(rsPer.getString("clave"));
					telefono.setPersona(persona);
			  }
				lis.add(telefono);
		
			}
			
		}catch(SQLException e){
			System.out.println(">>>WARNING (JDBCPersona:find): " + e.getMessage());
		}for(Telefono tel: lis) {
			System.out.println(tel.getCodigo() + "," + tel.getNumero() + "," + tel.getTipo() + "," + tel.getOperadora());
		}
		return lis;
	}
	
	
	public Set<Telefono> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		Set<Telefono> list = new HashSet<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM Telefono WHERE cedula='"+cedula+"';");
		try {
			while (rs.next()) {
				Telefono telefono = new Telefono( rs.getInt("codigo"),rs.getString("numero"), rs.getString("tipo"),rs.getString("operadora"));


				list.add(telefono);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo buscar....!!! "+ e.getMessage());
		}

		return list;
	}
	
	@Override
	public Telefono buscarCodigo(int codigo) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono WHERE codigo=" + codigo + ";");
		try {
			if (rs != null && rs.next()) {
				 telefono = new Telefono( rs.getInt("codigo"),rs.getString("numero"), rs.getString("tipo"),rs.getString("operadora"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return telefono;
	}
	
}

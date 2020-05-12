package test;

import datos.DAOFactory;
import datos.PersonaDAO;
import modelo.Persona;

public class TestUser {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonaDAO perDAO = DAOFactory.getFactory().getPersonaDAO();
		
		
		Persona p1, p2;
		
		p1 = new Persona("0106588437", "Joel ","Vasquez", "fvasquezf1@est.ups.edu.ec","12345");
		p2 = new Persona("0106588437", "Frankiln","Fajardo", "vjoel069@gmail.com","123456");
		
		perDAO.create(p1);
		perDAO.create(p2);
		System.out.println("Creacion de usuario " + perDAO.find());
		
		//perDAO.delete(p2);
		//System.out.println("Eliminando un usuario: " + perDAO.find());
		

	}

}

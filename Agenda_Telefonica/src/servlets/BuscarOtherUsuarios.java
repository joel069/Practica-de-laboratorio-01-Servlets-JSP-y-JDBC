package servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.PersonaDAO;
import modelo.Persona;
import modelo.Telefono;

/**
 * Servlet implementation class BuscarOtherUsuarios
 */
@WebServlet("/BuscarOtherUsuarios")
public class BuscarOtherUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarOtherUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String criterio = request.getParameter("criterio");
		PersonaDAO personaDAO = datos.DAOFactory.getFactory().getPersonaDAO();
		Set<Telefono> telefonos = null;
		Persona persona = null;			
		if (criterio.contains("@")) {
			System.out.println("Es un correo valido...!!!!");
			System.out.println(criterio);
			persona = personaDAO.buscarCorreo(criterio);
			
			telefonos = persona.getTelefonos();
			for (Telefono telefono : telefonos) {
				System.out.println("Telefono : " + telefono.getNumero());
			}
		} else if (criterio.matches("[0-9]+") && criterio.length() == 10) {
			System.out.println("Cedula dentro del rango....!!!");
			System.out.println(criterio);
			persona = personaDAO.read(criterio);
			
			telefonos = persona.getTelefonos();
			for (Telefono telefono : telefonos) {
				System.out.println("Telefono: " + telefono.getNumero());
			}
		} else {
			System.out.println("ALERT........Verifique que el numero y la cedula ingresada sean las correctas....!!");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

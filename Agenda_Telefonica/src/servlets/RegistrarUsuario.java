package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.PersonaDAO;
import modelo.Persona;
import datos.DAOFactory;
/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String cedula ="";
		String nombre ="";
		String apellido ="";
		String correo ="";
		String clave  ="";
		
		Persona persona = new Persona();
		
		String resp = request.getParameter("resp");
		PersonaDAO persoDAO = DAOFactory.getFactory().getPersonaDAO();
		
		if(resp.equals("Registrarse")) {
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			cedula = request.getParameter("cedula");
			correo = request.getParameter("correo");
			clave = request.getParameter("clave");
			
			persona = new Persona(cedula, nombre, apellido, correo, clave);
			
			persoDAO.create(persona);
			getServletContext().getRequestDispatcher("/JSPs/ExitoCreacion.jsp").forward(request, response);
	}
  }
}

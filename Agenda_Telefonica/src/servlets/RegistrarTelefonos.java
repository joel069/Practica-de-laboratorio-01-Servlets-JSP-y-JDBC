package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DAOFactory;
import datos.TelefonoDAO;
import modelo.Persona;
import modelo.Telefono;

/**
 * Servlet implementation class RegistrarTelefonos
 */
@WebServlet("/RegistrarTelefonos")
public class RegistrarTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarTelefonos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String operadora = request.getParameter("operadora");
		String cedula = request.getParameter("cedula");
		Persona persona = new Persona(cedula,null,null,null,null);
		Telefono telefono = new Telefono (0,numero,tipo,operadora);
		telefono.setPersona(persona);
		TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
		telDAO.create(telefono);
		
	
	    getServletContext().getRequestDispatcher("/JSPs/TelefonoRegistrado.jsp").forward(request, response);
	  
	}
}

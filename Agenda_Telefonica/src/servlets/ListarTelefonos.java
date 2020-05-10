package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DAOFactory;
import datos.PersonaDAO;
import datos.TelefonoDAO;
import modelo.Telefono;

/**
 * Servlet implementation class ListarTelefonos
 */
@WebServlet("/ListarTelefonos")
public class ListarTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telDAO;
	private PersonaDAO perDAO;
	private List<Telefono> telflist;
	private String cedula = " " ;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefonos() {
        super();
        
        telDAO = DAOFactory.getFactory().getTelefonoDAO();
        perDAO = DAOFactory.getFactory().getPersonaDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
try {
			
			telflist = telDAO.find();
			
			request.setAttribute("telflist", telflist);
			System.out.println("desde el controlador"+telflist);
			getServletContext().getRequestDispatcher("/Agenda_Telefonica/JSPs/IndexUsuario.jsp").forward(request, response);
		}catch(Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}

}

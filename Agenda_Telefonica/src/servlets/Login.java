package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DAOFactory;
import datos.PersonaDAO;
import datos.TelefonoDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		PersonaDAO persoDAO = DAOFactory.getFactory().getPersonaDAO();
		String correo = "";
		String clave = "";
		int indice = 0;
		
        String resp = request.getParameter("resp");
		
		if(resp.equals("Login")) {
			correo = request.getParameter("correo");
			clave = request.getParameter("clave");
			
			indice = persoDAO.buscar(correo, clave);
			System.out.println(indice);
		}
		try {
			if(indice>0) {
				TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
				
				request.setAttribute("telefono", telfDAO.find());
				getServletContext().getRequestDispatcher("ListarTelefonos.java").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/Agenda_Telefonica/Inicio.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(">>>WARNING (LOGINSERVEL):DOPOS: T"+e.getMessage());
		}
	}

}

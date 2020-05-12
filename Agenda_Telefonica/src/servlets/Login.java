package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.DAOFactory;
import datos.PersonaDAO;
import datos.TelefonoDAO;
import modelo.Persona;

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
		
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		
		PersonaDAO persoDAO = DAOFactory.getFactory().getPersonaDAO();
		List<Persona> list = persoDAO.find();
		Persona personaLog = null;
		for (Persona persona : list) {
			if (persona.getCorreo().equals(correo) && persona.getClave().equals(clave)) {
				System.out.println("Datos Insertados Corectamente...!!!");
				personaLog=persona;				
				HttpSession sesion = request.getSession(true);//el usuario a iniciado sesion
				request.getSession().setAttribute("iniciado", sesion);			
				String url=null;
				
				try {
					request.setAttribute("persona", personaLog);
					url="privado/agenda.jsp";
				
		       }catch(Exception e) {
		    	   
		    	   System.out.println(">>>WARNING (LOGINSERVEL):DOPOS: T"+ e.getMessage());
		    	   
		       }
		    	   getServletContext().getRequestDispatcher(url).forward(request, response);
		    	   break;
		       }
			 
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

package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.dao.DaoUsuario;
import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;

/**
 * Servlet implementation class Agenda
 */
@WebServlet("/Agenda")

public class Agenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Agenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String sesion=request.getParameter("logout");
		String buscarNumero = request.getParameter("buscarNumero");
		if(sesion != null) {
			if(sesion.equals("true")) {
				request.getSession().invalidate();
				response.sendRedirect("/Agenda_Telefonica/index.html");
				
			}
		}else {
			
		// System.out.println("Id del ususario " + request.getSession().getAttribute("userId"));
		 DaoUsuario userDao = DAOFactory.getFactory().getUsuarioDAO();
		 user user = userDao.findById(String.valueOf(request.getSession().getAttribute("userId")));
        
		 request.setAttribute("user", user);
         //System.out.println("Nombre: "+user.getNombre() + " Apellido: "+user.getApellido());
        
     
         if (buscarNumero!=null) {
			DaoTelefono telefono = DAOFactory.getFactory().getTelefonoDAO();
			user.setTelefono(telefono.findBySearchTelf(user.getCedula(), buscarNumero));
			
		}
         getServletContext().getRequestDispatcher("/jsp/Agenda.jsp").forward(request, response);
         	
	
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

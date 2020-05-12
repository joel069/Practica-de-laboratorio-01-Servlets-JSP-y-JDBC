package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;

/**
 * Servlet implementation class AgregarPhone
 */
@WebServlet("/AgregarPhone")
public class AgregarPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      	String numero = request.getParameter("numero");
	        String tipo = request.getParameter("tipo");
	        String operadora = request.getParameter("operadora");

	        DaoTelefono phoneDao = DAOFactory.getFactory().getTelefonoDAO();
	        telefono phone = new telefono(numero, tipo, operadora);
	        user user = DAOFactory.getFactory().getUsuarioDAO().findById(String.valueOf(request.getSession().getAttribute("userId")));
	        phone.setUser(user);
	        phoneDao.create(phone);

	        response.sendRedirect("/Agenda_Telefonica/Agenda");
	}

}

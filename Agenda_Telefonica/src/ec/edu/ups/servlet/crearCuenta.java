package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoUsuario;
import ec.edu.ups.modelo.user;

/**
 * Servlet implementation class crearCuenta
 */
@WebServlet("/crearCuenta")
public class crearCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crearCuenta() {
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
		
		String cedula=request.getParameter("cedula");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String email=request.getParameter("email");
		String pass=request.getParameter("passw");
		
		DAOFactory.getFactory().createTables();
	
		
        
		DaoUsuario userDao = DAOFactory.getFactory().getUsuarioDAO();
        user user = new user(cedula, nombre, apellido, email, pass);
        if (userDao.create(user)) {
            response.sendRedirect("/Agenda_Telefonica/html/Login.html");
            //System.out.println("Usuario Creado");
            //System.out.println("nombre: "+nombre+" apellido: "+apellido+" cedula: "+cedula+" mail: "+mail+" pass: "+pass);
        }else{
            System.out.println("Usuario No Creado");
            response.sendRedirect("/Agenda_Telefonica/html/CreateAccount.html");
        }
		
       
	}

}

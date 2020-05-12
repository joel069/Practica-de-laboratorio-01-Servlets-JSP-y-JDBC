package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DAOFactory;
import datos.TelefonoDAO;
import modelo.Telefono;

/**
 * Servlet implementation class EliminarTelefono
 */
@WebServlet("/EliminarTelefono")
public class EliminarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
		String correo=request.getParameter("correo");
		String clave=request.getParameter("clave");
		//--------------------------------------------------------------------------
		int codigo=Integer.valueOf(request.getParameter("codigo"));
		Telefono tel=new Telefono(codigo,null,null,null);
		TelefonoDAO telefonoDAO=DAOFactory.getFactory().getTelefonoDAO();
		telefonoDAO.delete(tel);		
		getServletContext().getRequestDispatcher("/Login?correo="+correo+"&clave="+clave).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

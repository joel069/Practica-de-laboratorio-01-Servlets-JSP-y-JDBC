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
 * Servlet implementation class ModificarTelefono
 */
@WebServlet("/ModificarTelefono")
public class ModificarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String correo=request.getParameter("correo");
		String clave=request.getParameter("clave");
		//------------------------------------------
		String numero=request.getParameter("numero");
		String operadora=request.getParameter("operadora");
		String tipo=request.getParameter("tipo");
		int codigo=Integer.valueOf(request.getParameter("clave"));
		Telefono telefono =new Telefono(codigo,numero,tipo,operadora);
		TelefonoDAO telf =DAOFactory.getFactory().getTelefonoDAO();
		telf.update(telefono);
		
		getServletContext().getRequestDispatcher("/privada/ajendaTelefonica.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

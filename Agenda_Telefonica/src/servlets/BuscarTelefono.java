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
 * Servlet implementation class BuscarTelefono
 */
@WebServlet("/BuscarTelefono")
public class BuscarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/**
		 *AQUI SE VA A MOFIFICAR DETERMINADO NUMERO DE UN USUARIO SOLO SE NECESITA DEL ID DEL TELEFONO
		 */
		
		
		String codigo=request.getParameter("codigo");
		
		
		TelefonoDAO telefonoDAO=DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono=telefonoDAO.buscarCodigo(Integer.valueOf(codigo));
		
		System.out.println("SU numero del telefono es el : "+ telefono.getNumero()+"es de  tipo: "+telefono.getTipo());
		String url=null;
		try {
			request.setAttribute("telefono", telefono);
			url="/privada/editarParamTelefono.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR SERVLET:BuscarTefono");
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

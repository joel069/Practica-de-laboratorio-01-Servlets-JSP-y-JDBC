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
 * Servlet implementation class EditPhone
 */
@WebServlet("/EditPhone")
public class EditPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sesion = request.getParameter("delete");
        String id = request.getParameter("idTel");
        
       
        
        if (sesion != null && id != null) {
            if (sesion.equals("true")) {  
                DaoTelefono phoneDao = DAOFactory.getFactory().getTelefonoDAO();
                telefono phone = phoneDao.findById(Integer.parseInt(id));
                user user = DAOFactory.getFactory().getUsuarioDAO().findById(String.valueOf(request.getSession().getAttribute("userId")));
                phone.setUser(user);
                phoneDao.delete(phone);
                System.out.println("Telefono: " );
                response.sendRedirect("/Agenda_Telefonica/Agenda");
            }
        } else {
        	
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String numero = request.getParameter("numero");
	        String tipo = request.getParameter("tipo");
	        String operadora = request.getParameter("operadora");
	        String idTel = request.getParameter("codigotel");
	        
	        System.out.println("Numero id " + idTel);

	        DaoTelefono phoneDao = DAOFactory.getFactory().getTelefonoDAO();
	        telefono phone = phoneDao.findById(Integer.parseInt(idTel));
	        user user = DAOFactory.getFactory().getUsuarioDAO().findById(String.valueOf(request.getSession().getAttribute("userId")));
	        phone.setUser(user);
	        phone.setNumero(numero);
	        phone.setTipo(tipo);
	        phone.setOperadora(operadora);
	        
	        phoneDao.update(phone);

	        response.sendRedirect("/Agenda_Telefonica/Agenda");
	}

}

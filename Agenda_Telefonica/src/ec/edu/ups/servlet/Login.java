package ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoUsuario;
import ec.edu.ups.modelo.user;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String email = request.getParameter("email");
		String pass = request.getParameter("passw");

		DaoUsuario userDao = DAOFactory.getFactory().getUsuarioDAO();
		user user = userDao.findPrsona(email, pass);

		System.out.println("Usuario " + user.toString());

		if (user != null) {
			System.out.println("Usuario encontrado");
			HttpSession session = request.getSession(true);
			System.out.println("Sesion iniciada con el id: " + request.getSession().getId());
			session.setAttribute("sessionID", String.valueOf(session.getId()));

			session.setAttribute("userId", user.getCedula());

			// System.out.println("Id del ususario " +
			// request.getSession().getAttribute("personaId"));

			response.sendRedirect("/Agenda_Telefonica/Agenda");

		} else {
			System.out.println("Usuario no encontrado");
			response.sendRedirect("/Agenda_Telefonica/html/Login.html");
		}

	}

}

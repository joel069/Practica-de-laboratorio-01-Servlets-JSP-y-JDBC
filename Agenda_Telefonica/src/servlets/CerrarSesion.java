package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CerrarSesion
 */
@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpServletRequest reqHttp= (HttpServletRequest)request;
		HttpSession sesion=reqHttp.getSession();
		System.out.println("Cerrando Sesion");
		sesion.invalidate();
		getServletContext().getRequestDispatcher("/publica/index.jsp").forward(request, response);
		
		
		
//		 if (sesion.getAttribute("iniciado") !=null) {
//			 	System.out.println("EL FILTRO CONSEDE EL ACCESO");
//				chain.doFilter(request, response);
//			}else{
//				System.out.println("El fitro marica dice que la sesion no esta iniciada");
//				((HttpServletResponse)response).sendRedirect("/publica/login.jsp");
//			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}

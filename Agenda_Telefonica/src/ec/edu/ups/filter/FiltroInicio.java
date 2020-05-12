package ec.edu.ups.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.dao.DaoUsuario;

/**
 * Servlet Filter implementation class FiltroInicio
 */
@WebFilter(filterName = "FiltroInicio", urlPatterns = {
		"/Agenda_Telefonica" }, dispatcherTypes = { DispatcherType.REQUEST })
public class FiltroInicio implements Filter {

	/**
	 * Default constructor.
	 */
	private static final boolean debug = true;
	private FilterConfig filterConfig = null;

	public FiltroInicio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		DaoUsuario userDao = DAOFactory.getFactory().getUsuarioDAO();
		userDao.createTable();
		DaoTelefono phoneDao = DAOFactory.getFactory().getTelefonoDAO();
		phoneDao.createTable();
		System.err.println("Filtro en ejecucion..!!");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package ec.edu.ups.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAgenda
 */
@WebFilter({ "/Agenda", "/AgregarPhone"})
public class FiltroAgenda implements Filter {

	/**
	 * Default constructor.
	 */
	private static final boolean debug = true;

	private FilterConfig filterConfig = null;

	public FiltroAgenda() {
		// TODO Auto-generated constructor stub
	}

	private void doBeforeProcessing(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
		if (debug) {
			log("FilterLogin:DoBeforeProcessing");
		}

	}

	private void doAfterProcessing(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
		if (debug) {
			log("FilterLogin:DoAfterProcessing");
		}

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

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession sesion = req.getSession();
		System.out.println("Id session: " + sesion.getId());

		if (String.valueOf(sesion.getAttribute("sessionID")).equals(String.valueOf(sesion.getId()))) {
			
			chain.doFilter(request, response);
			
		} else {
			// System.out.println("redirect login .....");
			res.sendRedirect("/Agenda_Telefonica/html/Login.html");
		System.out.println("Redirigiendo al Loguin validando sesion..!!!");
		}
	}

	public FilterConfig getFilterConfig() {
		return (this.filterConfig);
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = filterConfig;
		if (filterConfig != null) {
			if (debug) {
				log("FilterLogin:Initializing filter");
			}
		}
	}

	public String toString() {
		if (filterConfig == null) {
			return ("FilterLogin()");
		}
		StringBuffer sb = new StringBuffer("FilterLogin(");
		sb.append(filterConfig);
		sb.append(")");
		return (sb.toString());
	}

	private void sendProcessingError(Throwable t, ServletResponse response) {
		String stackTrace = getStackTrace(t);

		if (stackTrace != null && !stackTrace.equals("")) {
			try {
				response.setContentType("text/html");
				PrintStream ps = new PrintStream(response.getOutputStream());
				PrintWriter pw = new PrintWriter(ps);
				pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); // NOI18N

				// PENDING! Localize this for next official release
				pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
				pw.print(stackTrace);
				pw.print("</pre></body>\n</html>"); // NOI18N
				pw.close();
				ps.close();
				response.getOutputStream().close();
			} catch (Exception ex) {
			}
		} else {
			try {
				PrintStream ps = new PrintStream(response.getOutputStream());
				t.printStackTrace(ps);
				ps.close();
				response.getOutputStream().close();
			} catch (Exception ex) {
			}
		}
	}

	public static String getStackTrace(Throwable t) {
		String stackTrace = null;
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			pw.close();
			sw.close();
			stackTrace = sw.getBuffer().toString();
		} catch (Exception ex) {
		}
		return stackTrace;
	}

	public void log(String msg) {
		filterConfig.getServletContext().log(msg);
	}

}

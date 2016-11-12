package es.uc3m.tiw.filtrers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(
		urlPatterns= {"/perfilusuario.jsp","/crearProducto.jsp","/editarUsuario.jsp","/MostrarProductos.jsp"})
public class ErrorFilter implements Filter {

  
    public ErrorFilter() {

    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession sesion =  ((HttpServletRequest)request).getSession(); 
		//buscamos el token de autenticacion
		if (sesion.getAttribute("logeado")!=null &&(boolean)sesion.getAttribute("logeado")==true) { 
			
			chain.doFilter(request, response); 
		}else{
			request.getRequestDispatcher("/error404.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}
		


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

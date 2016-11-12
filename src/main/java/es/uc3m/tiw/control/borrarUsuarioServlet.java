package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapoptiw.daos.*;
import es.uc3m.tiw.wallapop.dominios.*;

/**
 * Servlet implementation class borrarUsuarioServlet
 */
@WebServlet("/borrarUsuario")
public class borrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config; 
    private UsuarioDAO dao;
	@PersistenceContext(unitName="wallapoptiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;


    public borrarUsuarioServlet() {
        super();
        
    }
    public void init(ServletConfig config){
    	this.config=config;
    	dao= new UsuarioDAOImpl();
    	dao.setConexion(em);
    	dao.setTransaction(ut);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion= request.getSession();
		Usuario user = (Usuario)sesion.getAttribute("usuario");
		try {
			dao.eliminarUsuario(user);
			sesion.invalidate();
			config.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | SQLException
				| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

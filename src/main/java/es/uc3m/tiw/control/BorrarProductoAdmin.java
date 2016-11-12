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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Producto;
import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.AdminDAOImpl;

/**
 * Servlet implementation class BorrarProductoAdmin
 */
@WebServlet("/BorrarProductoAdmin")
public class BorrarProductoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private AdminDAOImpl dao;
    @PersistenceContext(unitName="wallapoptiw")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
   
    public BorrarProductoAdmin() {
        super();

    }
    @Override
   	public void init(ServletConfig config) throws ServletException {
   		this.config = config;
   		dao=new AdminDAOImpl();
   		dao.setEm(em);
   		dao.setUt(ut);
   	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		
		try {
			Producto prod = dao.recuperarProductoPorClave(Integer.parseInt(id));
			dao.eliminarProducto(prod);
			config.getServletContext().getRequestDispatcher("/AdminPanel").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

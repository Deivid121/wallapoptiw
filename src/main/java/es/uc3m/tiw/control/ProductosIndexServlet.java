package es.uc3m.tiw.control;

import java.io.IOException;

import java.io.IOException;
import es.uc3m.tiw.wallapoptiw.daos.AdminDAOImpl;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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

import es.uc3m.tiw.wallapop.dominios.*;
import es.uc3m.tiw.wallapoptiw.daos.ProductoDAOImpl;


@WebServlet("/home")
public class ProductosIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private ProductoDAOImpl dao;
    @PersistenceContext(unitName="wallapoptiw")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
       
   
    public ProductosIndexServlet() {
        super();
        
    }
    @Override
  	public void init(ServletConfig config) throws ServletException {
  		this.config = config;
  		dao=new ProductoDAOImpl();
  		dao.setConexion(em);
  		dao.setTransaction(ut);
  	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Producto>lista=(List<Producto>)dao.listarProductos();
			request.setAttribute("productos", lista);
			config.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
				| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

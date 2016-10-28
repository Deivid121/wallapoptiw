package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

import es.uc3m.tiw.wallapop.dominios.Producto;
import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.ProductoDAO;
import es.uc3m.tiw.wallapoptiw.daos.ProductoDAOImpl;

/**
 * Servlet implementation class MisProductosServlet
 */
@WebServlet("/MisProductos")
public class MisProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO dao;
	private ServletConfig config;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
       
    public MisProductosServlet() {
        super();

    }

    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
   		dao = new ProductoDAOImpl();
   		dao.setConexion(em);
   		dao.setTransaction(ut);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion= request.getSession();
		Usuario user = (Usuario)sesion.getAttribute("usuario");
		int id = user.getId();
		try {
			List <Producto>p=(List<Producto>) dao.buscarProductoUsuario(id);
			request.setAttribute("productos", p);
		} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
				| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		config.getServletContext().getRequestDispatcher("/MisProductos.jsp").forward(request, response);
	}

}

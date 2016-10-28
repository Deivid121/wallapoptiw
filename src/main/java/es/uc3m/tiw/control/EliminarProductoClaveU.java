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
import es.uc3m.tiw.wallapoptiw.daos.ProductoDAO;
import es.uc3m.tiw.wallapoptiw.daos.ProductoDAOImpl;

/**
 * Servlet implementation class eliminarProductoClave
 */
@WebServlet("/eliminarProductoClaveU")
public class EliminarProductoClaveU extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Producto producto;
	private ProductoDAO pdao;
	private String pagina;
	private ServletConfig config;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoClaveU() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
   		pdao = new ProductoDAOImpl();
   		pdao.setConexion(em);
   		pdao.setTransaction(ut);
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
		int clave  = Integer.parseInt(request.getParameter("id"));
		try{
			producto = pdao.buscarProductoClave(clave);
			 pdao.eliminarProducto(producto);
		}catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
				| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		config.getServletContext().getRequestDispatcher("/MisProductos").forward(request, response);
	}

}

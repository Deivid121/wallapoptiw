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
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAOImpl;

/**
 * Servlet implementation class buscarProductoServlet
 */
@WebServlet("/buscarProducto")
public class buscarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> productos = null;
	private List<Usuario> usuarios;
	private ProductoDAO pdao;
	private UsuarioDAO udao;
	private String pagina;
	private ServletConfig config;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProductoServlet() {
        super();
        
    }
    public void init() throws ServletException {
    	this.config = config;
   		pdao = new ProductoDAOImpl();
   		pdao.setConexion(em);
   		pdao.setTransaction(ut);
   		udao = new UsuarioDAOImpl();
   		udao.setConexion(em);
   		udao.setTransaction(ut);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		String descripcion = request.getParameter("descripcion");
		String ciudad = request.getParameter("ciudad");
		String usuario = request.getParameter("usuario");
		if(usuario != null){
			try {
				usuarios = (List<Usuario>)udao.recuperarUnUsuarioNombre(usuario);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		for(int i = 0 ; i < usuarios.size() ; i++){
			try {
				productos.addAll((List<Producto>) pdao.buscarProductosAvanzada(titulo, ciudad, categoria, descripcion, usuarios.get(i).getId()));
			} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		

	}

}

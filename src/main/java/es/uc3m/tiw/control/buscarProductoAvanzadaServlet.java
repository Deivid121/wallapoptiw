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
public class buscarProductoAvanzadaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> productos = null;
	private List<Usuario> usuarios;
	private ProductoDAO pdao;
	private UsuarioDAO udao;
	private ServletConfig config;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProductoAvanzadaServlet() {
        super();
        
    }
    public void init(ServletConfig config) throws ServletException {
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
		String titulo = null;
		String categoria = null;
		String descripcion = null;
		String ciudad = null;
		String usuario = null;
		productos = null;
		
		if(!request.getParameter("titulo").equals("") && request.getParameter("titulo") != null ){
			titulo = request.getParameter("titulo");
		}
		if(!request.getParameter("categoria").equals("") && request.getParameter("categoria") != null){
			categoria = request.getParameter("categoria");
		}
		if(!request.getParameter("descripcion").equals("") && request.getParameter("descripcion") != null){
			descripcion = request.getParameter("descripcion");
		}
		if(!request.getParameter("ciudad").equals("") && request.getParameter("ciudad") != null){
			ciudad = request.getParameter("ciudad");
		}
		if(!request.getParameter("vendedor").equals("") && request.getParameter("vendedor") != null){
			usuario = request.getParameter("vendedor");
		}
		
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
			if(productos == null){
				try {
					productos = (List<Producto>) pdao.buscarProductosAvanzada(ciudad, categoria, usuarios.get(i).getId());
				} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
						| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					productos.addAll((List<Producto>) pdao.buscarProductosAvanzada(ciudad, categoria, usuarios.get(i).getId()));
				} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
						| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		}else{
			try {
				productos = (List<Producto>) pdao.buscarProductosAvanzada(ciudad, categoria, -1);
			} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//cambio de la busqueda con el titulo y la descripción
		if(titulo != null){
			if(productos == null){
				try {
					productos = (List<Producto>) pdao.listarProductos();
				} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
						| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				for(int i = 0; i < productos.size(); i++){	
						if(!productos.get(i).getTitulo().contains(titulo) ){		
								productos.remove(productos.get(i));
								i--;	
						}
				}
		}
		if(descripcion != null){
			if(productos == null){
				try {
					productos = (List<Producto>) pdao.listarProductos();
				} catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
						| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				for(int i = 0; i < productos.size(); i++){	
						if(!productos.get(i).getDescripcion().contains(descripcion) ){		
								productos.remove(productos.get(i));
								i--;	
						}
				}
		}
		
			
			
		request.setAttribute("productos", productos);
		config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

	}

}

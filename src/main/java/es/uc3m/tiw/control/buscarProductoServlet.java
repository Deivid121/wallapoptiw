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
	private List<Producto> productos;
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
		if(request.getParameter("titulo") != null){
			String titulo = request.getParameter("titulo");
			try{
				productos = (List<Producto>) pdao.buscarProductoTitulo(titulo);
			}catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cargamos en "pagina" una dirección para redirigir, tanto si ha ido bien como si ha habido algún error
			if (productos != null) {
				request.setAttribute("listaProductosTitulo", productos);
				if(!pagina.equals("error.jsp")){
					pagina = "/index.jsp";
				}
				
			}else {
				String mensaje = "No hay productos almacenados";
				request.setAttribute("mensajeError", mensaje);
				pagina = "/error.jsp"; //modificar el destino a una pagina de error
			}
		}
		if(request.getParameter("categoria") != null){
			String categoria = request.getParameter("categoria");
			try{
				productos = (List<Producto>) pdao.buscarProductoCategoria(categoria);
			}catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cargamos en "pagina" una dirección para redirigir, tanto si ha ido bien como si ha habido algún error
			if (productos != null) {
				request.setAttribute("listaProductosCategoria", productos);
				if(!pagina.equals("error.jsp")){
					pagina = "/index.jsp";
				}
				
			}else {
				String mensaje = "No hay productos almacenados";
				request.setAttribute("mensajeError", mensaje);
				pagina = "/error.jsp"; //modificar el destino a una pagina de error
			}
		}
		if(request.getParameter("usuario") != null){
			// Recogemos el Id del usuario en la sesion
			try {
				usuarios = (List<Usuario>) udao.recuperarUnUsuarioNombre(request.getParameter("usuario"));
			} catch (SecurityException | IllegalStateException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cargamos la lista de productos buscando por el ID del usuario en la base de datos
			for(int i = 0; i<usuarios.size(); i++){
				try{
					productos = (List<Producto>) pdao.buscarProductoUsuario(usuarios.get(i).getId());
				}catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
						| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Cargamos en "pagina" una dirección para redirigir, tanto si ha ido bien como si ha habido algún error
				if (productos != null) {
					request.setAttribute("listaProductos", productos);
					if(!pagina.equals("error.jsp")){
						pagina = "/index.jsp";
					}
				}else {
					String mensaje = "No hay productos almacenados";
					request.setAttribute("mensajeError", mensaje);
					pagina = "/MostrarProductos.jsp"; //modificar el destino a una pagina de error
				}
			}
			
		}
		if(request.getParameter("usuario") != null){
			// Recogemos el Id del usuario en la sesion
			HttpSession sesion = request.getSession();
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");
			// Cargamos la lista de productos buscando por el ID del usuario en la base de datos
			try{
				productos = (List<Producto>) pdao.buscarProductosCiudad(usuario.getCiudad());
			}catch (SecurityException | IllegalStateException | SQLException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cargamos en "pagina" una dirección para redirigir, tanto si ha ido bien como si ha habido algún error
			if (productos != null) {
				request.setAttribute("listaProductos", productos);
				if(!pagina.equals("error.jsp")){
					pagina = "/index.jsp";
				}
			}else {
				String mensaje = "No hay productos almacenados";
				request.setAttribute("mensajeError", mensaje);
				pagina = "/MostrarProductos.jsp"; //modificar el destino a una pagina de error
			}
		}
		
	}

}

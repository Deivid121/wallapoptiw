package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
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
 * Servlet implementation class usuarioServlet
 */
@WebServlet("/productoServletAdmin")
public class ProductoServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config; 
	private ProductoDAO dao;
       
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
    public ProductoServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		dao = new ProductoDAOImpl();
		dao.setConexion(em);
		dao.setTransaction(ut);
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
		// TODO Auto-generated method stub
		Producto prod;
		HttpSession sesion = request.getSession();
		
		prod=(Producto) sesion.getAttribute("producto");
		prod.setTitulo(request.getParameter("nombre"));
		prod.setCategoria(request.getParameter("categoria"));
		prod.setDescripcion(request.getParameter("descripcion"));
		prod.setPrecio(Integer.parseInt(request.getParameter("precio")));
		prod.setEstado(request.getParameter("estado"));
		//prod.setImagen(request.getParameter("imagen"));
		
		
		
		try {
			sesion.setAttribute("producto", dao.actualizarProducto(prod));
			config.getServletContext().getRequestDispatcher("/AdminPanel").forward(request, response);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

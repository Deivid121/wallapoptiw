package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.servlet.ServletException;

import java.sql.Connection;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;



import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAOImpl;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private Usuario u;
	private UsuarioDAO udao;
	private Connection con;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
   	public void init(ServletConfig config) throws ServletException {
   		this.config = config;
   		udao = new UsuarioDAOImpl();
   		udao.setConexion(em);
   		udao.setTransaction(ut);
   	}
    public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		u = new Usuario();
		u.setNombre(request.getParameter("Uname"));
		u.setApellido1(request.getParameter("FSurname"));
		u.setApellido2(request.getParameter("SSurname"));
		u.setEmail(request.getParameter("Email"));
		u.setPassword(request.getParameter("pass_confirmation"));
		u.setCiudad(request.getParameter("City"));
		try {
			udao.crearUsuario(u);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

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
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.AdminDAOImpl;

/**
 * Servlet implementation class editarUsuarioAdmin
 */
@WebServlet("/editarUsuarioAdmin")
public class EditarUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private AdminDAOImpl dao;
    @PersistenceContext(unitName="wallapoptiw")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
   
    public EditarUsuarioAdmin() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id= request.getParameter("id");
		HttpSession sesion = request.getSession();
		
		try {
			Usuario user=dao.recuperarUsuarioPorClave(Integer.parseInt(id));
			sesion.setAttribute("usuario", user);
			config.getServletContext().getRequestDispatcher("/editarUsuarioAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}

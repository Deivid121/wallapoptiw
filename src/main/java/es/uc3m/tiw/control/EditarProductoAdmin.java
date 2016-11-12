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

import es.uc3m.tiw.wallapop.dominios.Producto;
import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.AdminDAOImpl;

/**
 * Servlet implementation class EditarProductoAdmin
 */
@WebServlet("/EditarProductoAdmin")
public class EditarProductoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private AdminDAOImpl dao;
    @PersistenceContext(unitName="wallapoptiw")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
   
    public EditarProductoAdmin() {
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
		HttpSession sesion = request.getSession();
		
		try {
			Producto prod=dao.recuperarProductoPorClave(Integer.parseInt(id));
			sesion.setAttribute("producto", prod);
			config.getServletContext().getRequestDispatcher("/EditarProductoAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}

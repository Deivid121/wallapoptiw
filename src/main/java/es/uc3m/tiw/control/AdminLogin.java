package es.uc3m.tiw.control;

import java.io.IOException;
import es.uc3m.tiw.wallapoptiw.daos.AdminDAOImpl;
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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.*;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private AdminDAOImpl dao;
	@PersistenceContext(unitName="wallapoptiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
    public AdminLogin() {
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
		config.getServletContext().getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();

		String email=request.getParameter("email");
		String pass=request.getParameter("password");


		if(email.isEmpty()||pass.isEmpty()){
			config.getServletContext().getRequestDispatcher("/AdminLogin.jsp").forward(request,response);
		}
			try {
				Administrador admin= dao.buscarAdministrador(email, pass);
				if(admin==null){
					config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}
				else{
				
					if(admin.getEmail().isEmpty() && admin.getPassword().isEmpty()){
						
						sesion.setAttribute("logeado", false);
						config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
					}
					else{
						
						sesion.setAttribute("logeado", true);
						sesion.setAttribute("admin", admin);
						config.getServletContext().getRequestDispatcher("/perfilusuario.jsp").forward(request,response);
				}
					
				}
			}
		
			catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

		}
	
	}

}

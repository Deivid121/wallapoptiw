//package es.uc3m.tiw.control;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.Servlet;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.transaction.UserTransaction;
//
//import es.uc3m.tiw.wallapop.dominios.Usuario;
//import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;
//import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAOImpl;
//import es.uc3m.tiw.wallapoptiw.daos.MensajesDAO;
//import es.uc3m.tiw.wallapoptiw.daos.MensajesDAOImpl;
//import es.uc3m.tiw.wallapop.dominios.Mensaje;
//import es.uc3m.tiw.wallapop.util.EscribeEnCola;
//
///**
// * Servlet implementation class MensajesServlet
// */
//@WebServlet("/mensajes")
//public class MensajesServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    @PersistenceContext(unitName="wallapoptiw")
//    private EntityManager em;
//    @Resource
//    private UserTransaction ut;
//    private UsuarioDAOImpl dao;
//    private MensajesDAOImpl msgDao;
//    @Inject
//    private EscribeEnCola colaMensajes;
//    private List<Usuario> listaUsuarios;
//
//    /**
//     * @see Servlet#init(ServletConfig)
//     */
//    public void init() throws ServletException {
//        dao = new UsuarioDAOImpl ();
//        dao.setConexion(em);
//        dao.setTransaction(ut);
//        msgDao = new MensajesDAOImpl(em, ut);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    
//        HttpSession sesion = request.getSession();
//        Usuario u = (Usuario) sesion.getAttribute("usuario");
//        List<Mensaje> mensajes = msgDao.findAllMessagesByUsuario(u);
//        request.setAttribute("listaMensajes", mensajes);
//        this.getServletContext().getRequestDispatcher("/listaMensajes.jsp").forward(request, response);
//        
//        
//        
//        
//    }
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        
//      
//        
//        try {
//        	  String mensaje = request.getParameter("mensaje");
//              Usuario from = dao.recuperarUnUsuarioPorClave(Integer.valueOf(request.getParameter("from")));
//              Usuario to = dao.recuperarUnUsuarioPorClave(Integer.valueOf(request.getParameter("to")));
//              Mensaje msg = new Mensaje(mensaje,from, to);
//              
//
//              colaMensajes.enviar(msg);
//            //listaUsuarios = dao.findAll();
//            
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        request.setAttribute("usuarios", listaUsuarios);
//        
//        HttpSession session = request.getSession();
//        request.setAttribute("usuario", session.getAttribute("usuario"));
//        this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
//        
//        
//        
//    
//    }
//
//} 
//
//
///*package es.uc3m.tiw.control;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.inject.Inject;
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.ObjectMessage;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.Servlet;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.transaction.UserTransaction;
//
//import es.uc3m.tiw.wallapop.dominios.Usuario;
//import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;
//import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAOImpl;
//import es.uc3m.tiw.wallapoptiw.daos.MensajesDAO;
//import es.uc3m.tiw.wallapoptiw.daos.MensajesDAOImpl;
//import es.uc3m.tiw.wallapop.dominios.Mensaje;
//import es.uc3m.tiw.wallapop.util.EscribeEnCola;
//
//*//**
// * Servlet implementation class MensajesServlet
// *//*
//@WebServlet("/mensajes")
//public class MensajesServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	@PersistenceContext(unitName="wallapoptiw")
//	private EntityManager em;
//	@Resource
//	private UserTransaction ut;
//	private UsuarioDAOImpl dao;
//	private MensajesDAOImpl msgDao;
//	@Inject
//	private EscribeEnCola colaMensajes;
//       
//
//	*//**
//	 * @see Servlet#init(ServletConfig)
//	 *//*
//	public void init() throws ServletException {
//		dao = new UsuarioDAOImpl();
//		dao.setConexion(em);
//		dao.setTransaction(ut);
//		msgDao = new MensajesDAOImpl(em, ut);
////		colaMensajes = new EscribeEnCola();
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	
//		HttpSession sesion = request.getSession();
//		Usuario u = (Usuario) sesion.getAttribute("usuario");
//		List<Mensaje> mensajes = msgDao.findAllMessagesByUsuario(u);
//		request.setAttribute("listaMensajes", mensajes);
//		this.getServletContext().getRequestDispatcher("/listaMensajes.jsp").forward(request, response);
//		
//		
//		
//		
//	}
//	*//**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 *//*
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		Mensaje msg = null;
//		try {
//			String mensaje = request.getParameter("mensaje");
//			//Int f = Integer.parseInt(request.getParameter("from"));
//			//Int t = Integer.parseInt(request.getParameter("to"));
//			Usuario from = dao.recuperarUnUsuarioPorClave(Integer.parseInt(request.getParameter("from")));
//			Usuario to = dao.recuperarUnUsuarioPorClave(Integer.parseInt(request.getParameter("to")));
//			msg = new Mensaje(mensaje,from, to);
//
//			
//		} catch (NumberFormatException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
//		
//		colaMensajes.enviar(msg);
//		
//		this.getServletConfig().getServletContext().getRequestDispatcher("/listaMensajes.jsp").forward(request, response);
//		
//		
//		
//	
//	}
//	private void enviar(Mensaje mensaje){
//
//		  
//		   MessageProducer messageProducer;
//		   ObjectMessage messge;
//		   
//		   try
//		   {
//		       ConnectionFactory connectionFactory = null;
//		       
//		      // Get the JNDI Context
//		 
//		           Context jndiContext = new InitialContext();
//		            
//		      //   Create the Connection Factory
//		           connectionFactory = (ConnectionFactory) jndiContext.lookup("jms_tiwConnectionFactory");
//		           Queue queue = (Queue) jndiContext.lookup("jms_mensajes"); 
//
//		     Connection connection = connectionFactory.createConnection();
//		     Session session = connection.createSession(false,
//		       Session.AUTO_ACKNOWLEDGE);
//		     
//
//		     messageProducer = session.createProducer(queue);
//		     messge = session.createObjectMessage();
//		     messge.setObject(mensaje);
//
//		     
//		     messageProducer.send(messge);
//		     //connection.start();
//		     messageProducer.close();
//		     session.close();
//		     connection.close();
//		   
//		   }
//		   catch (JMSException | NamingException e)
//		   {
//		     e.printStackTrace();
//		   }
//		}
//
//}
//
//*/
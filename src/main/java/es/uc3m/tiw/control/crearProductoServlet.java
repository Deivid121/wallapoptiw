package es.uc3m.tiw.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
 * Servlet implementation class crearProductoServlet
 */
@WebServlet("/crearProducto")
@MultipartConfig(location = "./../../../eclipseApps/wallapoptiw/imagenes")
///home/tiw/Desktop/wallapoptiw/src/main/webapp/imagenes
public class crearProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Producto p;
	private ProductoDAO pdao;
	private Connection con;
	private ServletConfig config;
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crearProductoServlet() {
        super();
    }
    @Override
   	public void init(ServletConfig config) throws ServletException {
    	this.config = config;
    	p = new Producto();
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
		//Creamos el producto con los atributos recogidos desde el cliente
		p = new Producto();
		p.setTitulo(request.getParameter("titulo"));
		p.setCategoria(request.getParameter("categoria"));
		p.setDescripcion(request.getParameter("descripcion"));
		p.setPrecio(Integer.parseInt(request.getParameter("precio")));
		p.setUsuario(2);
//Recuperar una imagen y guardarla en el servidor
		/*
		 * cogemos la imagen de la "parte" de la cabecera que la contiene, para ello en el input del formulario
		 * teemos que tener una entrada de tipo file y con el nombre que queramos recuperar, en nuestro caso "imagen"
		 */
		Part filePart = request.getPart("imagen");
		/*
		 * recuperamos el nombre del fichero para poder guardarlo con el mismo nombre en el servidor
		 */
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		/*
		 * Utilizamos el nombre del fichero para guardarlo en la base de datos
		 * IMPORTANTE: estamos guardando el nombre del fichero, no la URL completa
		 */
		p.setImagen(fileName);
		/*
		 * Creamos un fichero con el nombre del fichero, incluyendo el tipo (png,jpg...)
		 */
		File imagen = new File("/opt/glassfish/payara41/glassfish/domains/domain1/eclipseApps/wallapoptiw/imagenes/"+fileName);
		/*
		 * Utilizamos el contenido de la "parte" recuperada para "llenar" el fichero que acabamos de crear
		 */
		InputStream fileContent = filePart.getInputStream();
		
	    byte[] buffer = new byte[fileContent.available()];
	    fileContent.read(buffer);
	    OutputStream outStream = new FileOutputStream(imagen);
	    outStream.write(buffer);
	    outStream.close();
		//Insercion del producto en la base de datos mediante el metodo crearProducto del daoImpl		
		try {
			pdao.crearProducto(p);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pagina = "/recuperarProducto";
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
		
		
	}

}

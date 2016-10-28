package es.uc3m.tiw.wallapoptiw.daos;

import java.sql.SQLException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Producto;
import es.uc3m.tiw.wallapop.dominios.Usuario;

public interface ProductoDAO {

	void crearProducto(Producto nuevoProducto) throws SQLException, NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	void eliminarProducto(Producto producto)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	void modificarProducto(Producto producto)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Collection<Producto> buscarProductoTitulo(String titulo)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;


	Collection<Producto> listarProductos() throws SQLException, NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;


	Collection<Producto> buscarProductoCategoria(String categoria)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	void setTransaction(UserTransaction ut);

	void setConexion(EntityManager em);

	Collection<Producto> buscarProductoUsuario(int usuario)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Producto buscarProductoClave(int clave)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	void eliminarProductoClave(int clave)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;


	Producto actualizarProducto(Producto prod)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;



	Collection<Producto> buscarProductosCiudad(String ciudad)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Collection<Producto> buscarProductosAvanzada(String titulo, String ciudad, String categoria, String descripcion,
			int usuario) throws SQLException, NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Collection<Producto> buscarProductosEstado(String estado)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;


}

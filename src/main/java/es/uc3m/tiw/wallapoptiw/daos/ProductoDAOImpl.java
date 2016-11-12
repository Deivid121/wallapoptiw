package es.uc3m.tiw.wallapoptiw.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

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

public class ProductoDAOImpl implements ProductoDAO {

	private EntityManager em;
	private UserTransaction ut;
	@Override
	public void crearProducto(Producto nuevoProducto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.persist(nuevoProducto);
		ut.commit();
		//em.flush();
	}
	@Override
	public void eliminarProducto(Producto producto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.remove(em.merge(producto));
		ut.commit();
	}
	@Override
	public void modificarProducto(Producto producto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.merge(producto);
		ut.commit();
	}
	@Override
	public Collection<Producto> buscarProductoTitulo(String titulo) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p where p.titulo=:titulo", Producto.class);
		consulta.setParameter("titulo", titulo);
		return consulta.getResultList();
		
	}
	
	@Override
	public void eliminarProductoClave(int clave) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p where p.id=:pk", Producto.class);
		consulta.setParameter("pk", clave);
		Producto producto = (Producto) consulta.getResultList().get(0);
		ut.begin();
		em.remove(em.merge(producto));
		ut.commit();
	}
	@Override
	public Collection<Producto>  listarProductos() throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p", Producto.class);
		return  consulta.getResultList();
		
	}
	@Override
	public Producto buscarProductoClave(int clave) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{

		return em.find(Producto.class, clave);
	}
	
	@Override
	public Collection<Producto> buscarProductoCategoria(String categoria) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p where p.categoria=:cat", Producto.class);
		consulta.setParameter("cat", categoria);
		return consulta.getResultList();
		
	}
	@Override
	public Collection<Producto> buscarProductoUsuario(int usuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p where p.usuario=:us", Producto.class);
		consulta.setParameter("us", usuario);
		return  consulta.getResultList();
		
	}
	@Override
	public Collection<Producto> buscarProductosCiudad(String ciudad) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta = em.createQuery("select p from Producto p where p.ciudad=:cd", Producto.class);
		consulta.setParameter("cd", ciudad);
		return  consulta.getResultList();
		
	}
	@Override
	public Producto actualizarProducto (Producto prod )throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		
		ut.begin();

		em.merge(prod);
		
		ut.commit();
		
		
		return buscarProductoClave(prod.getId());
	
	
	}
	@Override
	public void setConexion(EntityManager em) {
		this.em = em;
		
	}
	@Override
	public void setTransaction(UserTransaction ut) {
		// TODO Auto-generated method stub
		this.ut = ut;
	}
	
}

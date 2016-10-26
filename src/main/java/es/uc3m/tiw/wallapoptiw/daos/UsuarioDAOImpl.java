package es.uc3m.tiw.wallapoptiw.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	private EntityManager em;
	private UserTransaction ut;
	@Override
	public void crearUsuario(Usuario nuevoUsuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		//em.flush();
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

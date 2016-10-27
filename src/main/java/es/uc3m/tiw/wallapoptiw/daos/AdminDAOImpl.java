package es.uc3m.tiw.wallapoptiw.daos;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.*;
import es.uc3m.tiw.wallapop.dominios.*;


public class AdminDAOImpl implements AdminDAO{

	private EntityManager em;
	private UserTransaction ut;
	
	@Override
	public Administrador buscarAdministrador(String email,String pass)  throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		Query consulta= em.createQuery("select u from Administrador u where u.email =:email and u.password =:pass",Administrador.class);	
		consulta.setParameter("email", email);
		consulta.setParameter("pass", pass);
		if(consulta.getResultList().isEmpty()){
			return null;
		}
		else{
			Administrador admin=(Administrador)consulta.getResultList().get(0);
			return admin;
		}
	}
	
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public UserTransaction getUt() {
		return ut;
	}
	public void setUt(UserTransaction ut) {
		this.ut = ut;
	}
}

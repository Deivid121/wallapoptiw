package es.uc3m.tiw.wallapoptiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Administrador;
import es.uc3m.tiw.wallapop.dominios.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public interface AdminDAO {

	Administrador buscarAdministrador(String email, String pass)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Collection<Usuario> buscarUsuarios() throws SQLException, NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	Usuario recuperarUsuarioPorClave(int pk) throws SQLException;

	void eliminarUsuario(Usuario user) throws NotSupportedException, SystemException, SQLException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;


	
	
	
}

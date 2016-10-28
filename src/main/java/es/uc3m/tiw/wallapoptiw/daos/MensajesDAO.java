package es.uc3m.tiw.wallapoptiw.daos;


import java.util.List;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapop.dominios.Mensaje;

public interface MensajesDAO {

	List<Mensaje> findAllMessagesByUsuario(Usuario usuario);

	void createMensaje(Mensaje mensaje) throws SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException, SystemException, javax.transaction.NotSupportedException, javax.transaction.RollbackException;

}
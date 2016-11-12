package es.uc3m.tiw.wallapop.mdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Mensaje;
import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.MensajesDAO;
import es.uc3m.tiw.wallapoptiw.daos.MensajesDAOImpl;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;

/**
 * Message-Driven Bean implementation class for: LectorMensajesMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms_tiwConnectionFactory"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "jms_mensajes")
@TransactionManagement(TransactionManagementType.BEAN)
public class LectorMensajesMDB implements MessageListener {
	private MensajesDAO msgDao;
	@PersistenceContext(unitName="wallapoptiw")
	EntityManager em;
	@Resource
	UserTransaction ut;
	
	@PostConstruct
	private void configurador(){
		System.out.println("****POSTCONSTRUCT LectorMnsajesMDB");
		msgDao = new MensajesDAOImpl(em, ut);
	}

    /**
     * Default constructor. 
     */
    public LectorMensajesMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
       System.out.println("******Ha llegado un mensaje");
        
        ObjectMessage om =  (ObjectMessage) message;
        try {
        		Mensaje mensaje = (Mensaje) om.getObject();
        		msgDao.createMensaje(mensaje);
        		
		} catch (JMSException | SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | javax.persistence.RollbackException | javax.resource.NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
   
        
    }
        
    }



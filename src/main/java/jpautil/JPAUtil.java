package jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = null;
	
	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		}	
	}
	
	public static EntityManager getentiEntityManager(){
		return factory.createEntityManager();
	}
	
	public static Object getPrimarykey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}

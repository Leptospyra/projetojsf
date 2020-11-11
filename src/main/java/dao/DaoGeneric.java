package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpautil.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getentiEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		entityTransaction.commit();
		
		entityManager.close();

	}

	public E merge(E entidade) {
		EntityManager entityManager = JPAUtil.getentiEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);
		entityTransaction.commit();
		
		entityManager.close();

		return retorno;
	}

	public void delete(E entidade) {
		EntityManager entityManager = JPAUtil.getentiEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(entidade);
		entityTransaction.commit();
		
		entityManager.close();

	}


	public void deletePorId(E entidade) {
		EntityManager entityManager = JPAUtil.getentiEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getPrimarykey(entidade);
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();
		entityTransaction.commit();
		
		entityManager.close();

	}
	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = JPAUtil.getentiEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}

}
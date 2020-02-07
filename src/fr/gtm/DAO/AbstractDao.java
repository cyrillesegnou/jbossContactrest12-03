package fr.gtm.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;



// penser à mettre la javadoc
public abstract class AbstractDao <E,ID>{

	private Class<E> entityClass;
	
	
	 public AbstractDao(Class<E> entityClass) {
		 this.entityClass = entityClass;
	 }

	 
	 protected abstract EntityManager getEntityManager();
	 
	
	public E findById(long id) {
		return getEntityManager().find(entityClass, id);
		
	}


	public void save(E entity) {
		getEntityManager().persist(entity);
	}

	public void update(E entity) {
		getEntityManager().merge(entity);
	}

	public E remove(ID id) {
		EntityManager em = getEntityManager();
		E entity = em.find(entityClass, id);
		em.remove(entity);
		return entity;
	}
	
	public abstract void  saveOrUpdate(E e);

}
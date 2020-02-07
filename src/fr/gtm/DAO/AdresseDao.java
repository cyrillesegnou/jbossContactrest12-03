package fr.gtm.DAO;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.entities.Adresse;


@Singleton
public class AdresseDao extends AbstractDao<Adresse,Long>  {
	
	// annotation pour faire une injection
		@PersistenceContext(name="contacts") private EntityManager em;

		//constructeur par defaut obligatoire à cause du singleton
	public AdresseDao() {
		super (Adresse.class);
		
	}

	
	@Override
	public void saveOrUpdate(Adresse a) {
		if (a.getId()==0) {
			save (a);
			
		}else {
			update(a);
		}
		
	}
	
	
	
	public List<Adresse> findAll(){
	
		List<Adresse> adresses = em.createNamedQuery("Adresse.findAll", Adresse.class).getResultList();
		
		return adresses;
	
	
	}


	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
	
	

}

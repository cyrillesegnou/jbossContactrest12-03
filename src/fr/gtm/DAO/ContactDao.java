package fr.gtm.DAO;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.entities.Adresse;
import fr.gtm.entities.Civilite;
import fr.gtm.entities.Contact;

@Singleton
public class ContactDao extends AbstractDao<Contact,Long> {
	// annotation pour faire une injection
	
	@PersistenceContext(name="contacts") private EntityManager em;
	
	//constructeur par défaut obligatoire car @Singleton 
	
	public ContactDao() {
		super (Contact.class);
		}


	public Contact findById(long id) {
		return getEntityManager().find(Contact.class, id);
		
	}
	public void save(Contact contact) {
		getEntityManager().persist(contact);
		
	}
	public void update(Contact contact) {
		getEntityManager().merge(contact);
	}
	
	public Contact remove(Long id) {
		EntityManager em = getEntityManager();
		Contact entity = em.find(Contact.class, id);
		em.remove(entity);
		return entity;
	}
		public List<Contact> findByCivilite(Civilite civilite){
		
				List<Contact> contacts = em.createNamedQuery("Contact.findByCivilite", Contact.class)
						.setParameter("civilite", civilite) 
						.getResultList();
				return contacts;
			}
	

	@Override
	public void saveOrUpdate(Contact e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}


//	@Override
//	public void saveOrUpdate(Contact c) {
//		if (c.getId()==0) {
//			save (c);
//			
//		}else {
//			update(c);
//		}
//		/ le 2ème nom correspond au paramètre de ma requete LYJCA0001: Bound data source [java:/jboss/jdbc/contacts]
//	}


//	public List<Contact> findAll(){
//		String jpql = "SELECT c FROM Contact AS c";
//		List<Contact> contacts = em.createQuery(jpql, Contact.class).getResultList();
//		return contacts;	
//	}

//	public List<Contact> findByNomLike(String nom){
//
//		List<Contact> contacts = em.createNamedQuery("Contact.findByNomLike", Contact.class)
//				.setParameter("nom", nom) // le 2ème nom correspond au paramètre de ma requete LYJCA0001: Bound data source [java:/jboss/jdbc/contacts]
//				.getResultList();
//		return contacts;
//	}


//	public List<Adresse> getAdresses(long idContact){
//		Contact contact = em.find(Contact.class, idContact);
// methode sur la collection qui permet de charger la collection en mode LAZY dans l'entité manager 
// cela va forcer l'ORM à venir chercher la collection en base
//contact.getAdresses().size();

//		contact.getAdresses().size();
//		return contact.getAdresses();
//	}
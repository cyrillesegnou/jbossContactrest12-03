package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import fr.gtm.DAO.ContactDao;
import fr.gtm.entities.Contact;



@Singleton
@LocalBean

public class ContactService {
	@EJB private ContactDao contactDao;

	public ContactService() {
		
	}
	
	public Contact findContactById(Long idContact) {
			
		return contactDao.findById(idContact);
	}
	
	public void saveContact(Contact contact) {
		contactDao.save(contact);
	}
	
	public void updateContact(Contact contact) {
		contactDao.update(contact);
		
	}
	public Contact removeContact (Long idContact) {
		return contactDao.remove(idContact);
		
	}
	
		

}

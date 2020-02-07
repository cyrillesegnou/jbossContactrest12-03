package fr.gtm.entities.rest;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.gtm.DAO.ContactDao;
import fr.gtm.entities.Civilite;
import fr.gtm.entities.Contact;

@Path("/contacts")
public class ContactServiceRest {
	@EJB private ContactDao dao ;
	
	@GET
	@Path("/id/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Contact getContactById (@PathParam("id") long id) {
		return dao.findById(id);
		
	}
	@GET
	@Path("/civilite/{civilite}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Contact> getContactByCivilite(@PathParam("civilite") Civilite civilite) {
		return dao.findByCivilite(civilite);
	
	}
	@POST
	@Path("/new")
	@Consumes({MediaType.APPLICATION_JSON})
	public Contact save(Contact contact) {
		dao.save(contact);
		return contact ;
		
				//contact.getId();
		
	}
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Contact update(Contact contact) {
			dao.update(contact);
			return contact;
			
	}
	@DELETE
	@Path("/del/{id}")
	public String suprrimer(@PathParam ("id") long id) {
		dao.remove(id);
		
		return "suppression effetuée";
		
	}

}

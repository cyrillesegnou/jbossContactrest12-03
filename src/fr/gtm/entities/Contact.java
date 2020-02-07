package fr.gtm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Stateless
@LocalBean
@Entity
@Table(name = "personnes")

@NamedQuery(name="Contact.findByCivilite", 
			query = "SELECT c FROM Contact c WHERE c.civilite LIKE :civilite")
@NamedQuery(name="Contact.findAll", 
			query = "SELECT c FROM Contact c ")
@XmlRootElement
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private long id;
	@Column (length = 10)  // permet d'imposer la taille de la chaîne de caractère lors de la création d'une table en BDD car par defaut elle vaut 255
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String nom;
	private String prenom;
	
	
	// collecttion en mode EAGER
	//@ManyToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
	//collection en mode LAZY
	//@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="contacts_adresses", 
//	joinColumns =@JoinColumn(name="fk_personne"), 
//	inverseJoinColumns = @JoinColumn(name="fk_adresse"))
//	private List<Adresse> adresses = new ArrayList<>();
//	
//	// on indique 
//	@Column(table = "avatars", name="avatar")
//	//rajout d'image
//	private String image;
//	
//	

	// a rajouter puisqu'on fait un constructeur avec les paramètres
	public Contact() {
		
	}
	
	public Contact(Civilite civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
//	public List<Adresse> getAdresses() {
//		return adresses;
//	}
//
//	public void setAdresses(List<Adresse> adresses) {
//		this.adresses = adresses;
//	}
//	
	
	
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}

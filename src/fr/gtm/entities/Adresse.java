package fr.gtm.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="adresses")
@NamedQuery(name="Adresse.findAll", query = "SELECT a FROM Adresse a ")
public class Adresse implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private long id;
	private String rue;
	private String code_postal;
	private String ville;
	private String pays;
	
	
	
	public Adresse() {

	}
	public Adresse(String code_postal, String ville) {
		this.code_postal = code_postal;
		this.ville = ville;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", pays="
				+ pays + "]";
	}
	
	
	

	
}

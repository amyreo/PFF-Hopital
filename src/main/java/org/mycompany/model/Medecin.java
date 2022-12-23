package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Medecin {
	@Id
	private int idMede;
	private String nom;
	private String prenom;
	private String role;


	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMede")
	private List<Ordonance> ordonances;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Patient_Medecin_Associations", joinColumns = @JoinColumn(name = "idPatient"), inverseJoinColumns = @JoinColumn(name = "idMedecin"))
	private List<Patient> listePatients;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRDV")
	private List<RDV> listeRdv;

	public Medecin() {
		super();
	}

	public Medecin(int idMede, String nom, String prenom, String role) {
		super();
		this.idMede = idMede;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}

	public Medecin(int idMede, String nom, String prenom, String role, List<Ordonance> ordonances,
			List<Patient> listePatients, List<RDV> listeRdv) {
		super();
		this.idMede = idMede;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.ordonances = ordonances;
		this.listePatients = listePatients;
		this.listeRdv = listeRdv;
	}

	public int getIdMede() {
		return idMede;
	}

	public void setIdMede(int idMede) {
		this.idMede = idMede;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Ordonance> getOrdonances() {
		return ordonances;
	}

	public void setOrdonances(List<Ordonance> ordonances) {
		this.ordonances = ordonances;
	}

	public List<Patient> getListePatients() {
		return listePatients;
	}

	public void setListePatients(List<Patient> listePatients) {
		this.listePatients = listePatients;
	}

	public List<RDV> getListeRdv() {
		return listeRdv;
	}

	public void setListeRdv(List<RDV> listeRdv) {
		this.listeRdv = listeRdv;
	}

	@Override
	public String toString() {
		return "Medecin [idMede=" + idMede + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", ordonances="
				+ ordonances + ", listePatients=" + listePatients + ", rdv=" + listeRdv + "]";
	}

}

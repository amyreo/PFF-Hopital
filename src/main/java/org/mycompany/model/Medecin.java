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

@Entity
@Table

public class Medecin {
	@Id
	private int idMede;
	private String nom;
	private String prenom;
	private String role;

	@OneToMany(targetEntity = Ordonance.class, mappedBy = "Medecin", cascade = CascadeType.ALL)
	private List<Ordonance> ordonances = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Patient_Medecin_Associations", joinColumns = @JoinColumn(name = "idPatient"), inverseJoinColumns = @JoinColumn(name = "idMedecin"))
	private List<Patient> listePatients;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRDV")
	private RDV rdv;

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
			List<Patient> listePatients, RDV rdv) {
		super();
		this.idMede = idMede;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.ordonances = ordonances;
		this.listePatients = listePatients;
		this.rdv = rdv;
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

	public RDV getRdv() {
		return rdv;
	}

	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}

	@Override
	public String toString() {
		return "Medecin [idMede=" + idMede + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", ordonances="
				+ ordonances + ", listePatients=" + listePatients + ", rdv=" + rdv + "]";
	}

}

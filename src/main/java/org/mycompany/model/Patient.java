package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Patient {

	@Id
	private int id;
	private String nom;
	private String prenom;
	private int age;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPatient")
	private List<RDV> listeRDV = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idChambre")
	private Chambre chambre;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Patient_Medecin_Associations", joinColumns = @JoinColumn(name = "idMedecin"), inverseJoinColumns = @JoinColumn(name = "idPatient"))
	private List<Medecin> listeMedecins;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPatient")
	private List<Ordonance> listeOrdonances = new ArrayList<>();

	public Patient() {
		super();
	}

	public Patient(int id, String nom, String prenom, int age, List<RDV> listeRDV, Chambre chambre,
			List<Medecin> listeMedecins, List<Ordonance> listeOrdonances) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.listeRDV = listeRDV;
		this.chambre = chambre;
		this.listeMedecins = listeMedecins;
		this.listeOrdonances = listeOrdonances;
	}

	public Patient(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<RDV> getListeRDV() {
		return listeRDV;
	}

	public void setListeRDV(List<RDV> listeRDV) {
		this.listeRDV = listeRDV;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public List<Medecin> getListeMedecins() {
		return listeMedecins;
	}

	public void setListeMedecins(List<Medecin> listeMedecins) {
		this.listeMedecins = listeMedecins;
	}

	public List<Ordonance> getListeOrdonances() {
		return listeOrdonances;
	}

	public void setListeOrdonances(List<Ordonance> listeOrdonances) {
		this.listeOrdonances = listeOrdonances;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", listeRDV=" + listeRDV
				+ ", chambre=" + chambre + ", listeMedecins=" + listeMedecins + ", listeOrdonances=" + listeOrdonances
				+ "]";
	}

}

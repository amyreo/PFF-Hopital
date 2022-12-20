package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@ManyToOne
	@JoinColumn(name = "idChambre")
	private Chambre chambre;

	public Patient() {
		super();
	}

	public Patient(int id, String nom, String prenom, int age, List<RDV> listeRDV, Chambre chambre) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.listeRDV = listeRDV;
		this.chambre = chambre;
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

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", listeRDV=" + listeRDV
				+ ", chambre=" + chambre + "]";
	}

}

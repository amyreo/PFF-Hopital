package org.mycompany.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Chambre {

	@Id
	private int id;
	private int taille;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idChambre")
	private List<Patient> listePatient;

	public Chambre() {
		super();
	}

	public Chambre(int id, int taille) {
		super();
		this.id = id;
		this.taille = taille;
	}

	public Chambre(int id, int taille, List<Patient> listePatient) {
		super();
		this.id = id;
		this.taille = taille;
		this.listePatient = listePatient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Patient> getListePatient() {
		return listePatient;
	}

	public void setListePatient(List<Patient> listePatient) {
		if (listePatient.size() > this.taille) {
			System.out.println("Trop de patients pour la chambre; veuillez répartir dans d'autres chambres.");
		} else {
			this.listePatient = listePatient;
			System.out.println("La taille de la chambre est bien adaptée pour ce nombre de patients.");
		}
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", taille=" + taille + ", listePatient=" + listePatient + "]";
	}

}

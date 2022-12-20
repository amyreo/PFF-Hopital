package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Medicament {
	@Id
	private int idMedi;
	private String nom;
	private String description;
	private int stock;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Ordo_Medi_Associations", joinColumns = @JoinColumn(name = "idMedi"), inverseJoinColumns = @JoinColumn(name = "idOrdo"))
	private List<Ordonance> ordonances = new ArrayList<>();

	public Medicament() {
		super();
	}

	public Medicament(int idMedi, String nom, String description, int stock) {
		super();
		this.idMedi = idMedi;
		this.nom = nom;
		this.description = description;
		this.stock = stock;
	}

	public Medicament(int idMedi, String nom, String description, int stock, List<Ordonance> ordonances) {
		super();
		this.idMedi = idMedi;
		this.nom = nom;
		this.description = description;
		this.ordonances = ordonances;
		this.stock = stock;
	}

	public int getIdMedi() {
		return idMedi;
	}

	public void setIdMedi(int idMedi) {
		this.idMedi = idMedi;
	}

	public String getNom() {
		return nom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Ordonance> getOrdonances() {
		return ordonances;
	}

	public void setOrdonances(List<Ordonance> ordonances) {
		this.ordonances = ordonances;
	}

	@Override
	public String toString() {
		return "Medicament [idMedi=" + idMedi + ", nom=" + nom + ", description=" + description + ", ordonances="
				+ ordonances + "]";
	}

}

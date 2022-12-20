package org.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Facture {
	@Id
	private int id;
	private double montant;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRDV")
	private RDV rdv;

	public Facture(int id, double montant, RDV rdv) {
		super();
		this.id = id;
		this.montant = montant;
		this.rdv = rdv;
	}

	public Facture(int id, double montant) {
		super();
		this.id = id;
		this.montant = montant;
	}

	public Facture() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public RDV getRdv() {
		return rdv;
	}

	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", montant=" + montant + ", rdv=" + rdv + "]";
	}

}

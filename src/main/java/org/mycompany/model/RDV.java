package org.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.mycompany.model.Patient;

@Entity
@Table
public class RDV {

	@Id
	private int id;
	private String heureDebut;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFacture")
	private Facture facture;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMedecin")
	private Medecin medecin;

	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;

	public RDV() {
		super();
	}

	public RDV(int id, String heureDebut) {
		super();
		this.id = id;
		this.heureDebut = heureDebut;
	}

	public RDV(int id, String heureDebut, Facture facture, Medecin medecin, Patient patient) {
		super();
		this.id = id;
		this.heureDebut = heureDebut;
		this.facture = facture;
		this.medecin = medecin;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "RDV [id=" + id + ", heureDebut=" + heureDebut + ", facture=" + facture + ", medecin=" + medecin
				+ ", patient=" + patient + "]";
	}
	
	

}

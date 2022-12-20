package org.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.mycompany.model.Patient;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class RDV {

	@Id
	private int id;
	private String maladie;
	private String heureDebut;
	private boolean chirurgie;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFacture")
	private Facture facture;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMedecin")
	private Medecin medecin;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPatient")
	private Patient patient;

	public RDV() {
		super();
	}

	public RDV(int id, String heureDebut, String maladie, boolean chirurgie) {
		super();
		this.id = id;
		this.maladie = maladie;
		this.heureDebut = heureDebut;
		this.chirurgie = chirurgie;
	}

	public RDV(int id, String heureDebut, String maladie, Facture facture, Medecin medecin, Patient patient, boolean chirurgie) {
		super();
		this.id = id;
		this.heureDebut = heureDebut;
		this.facture = facture;
		this.medecin = medecin;
		this.patient = patient;
		this.maladie = maladie;
		this.chirurgie = chirurgie;
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

	public String getMaladie() {
		return maladie;
	}

	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}

	public boolean isChirurgie() {
		return chirurgie;
	}

	public void setChirurgie(boolean chirurgie) {
		this.chirurgie = chirurgie;
	}

	@Override
	public String toString() {
		return "RDV [id=" + id + ", maladie=" + maladie + ", heureDebut=" + heureDebut + ", chirurgie=" + chirurgie
				+ ", facture=" + facture + ", medecin=" + medecin + ", patient=" + patient + "]";
	}
	
	
	
	

}

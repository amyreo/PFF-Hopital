package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Ordonance {
	private int idOrdo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "T_Ordo_Medi_Associations",
            joinColumns = @JoinColumn( name = "idOrdo" ),
            inverseJoinColumns = @JoinColumn( name = "idMedi" ) )
	  private List<Medicament> medicaments = new ArrayList<>();
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMede")
	private Medecin medecin;

	public Ordonance() {
		super();
	}

	public Ordonance(int idOrdo, List<Medicament> medicaments) {
		super();
		this.idOrdo = idOrdo;
	}

	public Ordonance(int idOrdo, List<Medicament> medicaments, Medecin medecin) {
		super();
		this.idOrdo = idOrdo;
		this.medicaments = medicaments;
		this.medecin = medecin;
	}

	public int getIdOrdo() {
		return idOrdo;
	}

	public void setIdOrdo(int idOrdo) {
		this.idOrdo = idOrdo;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@Override
	public String toString() {
		return "Ordonance [idOrdo=" + idOrdo + ", medicaments=" + medicaments + ", medecin=" + medecin + "]";
	}

}

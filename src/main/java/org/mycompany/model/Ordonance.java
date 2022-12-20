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

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Ordonance {
	@Id
	private int idOrdo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "T_Ordo_Medi_Associations",
            joinColumns = @JoinColumn( name = "idOrdo" ),
            inverseJoinColumns = @JoinColumn( name = "idMedi" ) )
	  private List<Medicament> medicaments = new ArrayList<>();
	

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


	@Override
	public String toString() {
		return "Ordonance [idOrdo=" + idOrdo + ", medicaments=" + medicaments + "]";
	}

}

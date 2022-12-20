package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Ordonance {
	private int idOrdo;

	@ManyToMany
	@JoinTable( name = "T_Ordo_Medi_Associations",
            joinColumns = @JoinColumn( name = "idOrdo" ),
            inverseJoinColumns = @JoinColumn( name = "idMedi" ) )
	  private List<Medicament> medicaments = new ArrayList<>();
	
	   @ManyToMany  @JoinColumn( name="idMede" )
	    private Medecin medecin;
}

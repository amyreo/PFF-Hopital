package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table
public class Medicament {
	
	private int idMedi;
	private String nom;
	private String description;
	
	@ManyToMany
	@JoinTable( name = "T_Ordo_Medi_Associations",
            joinColumns = @JoinColumn( name = "idMEdi" ),
            inverseJoinColumns = @JoinColumn( name = "idOrdo" ) )
	  private List<Ordonance> roles = new ArrayList<>();

}

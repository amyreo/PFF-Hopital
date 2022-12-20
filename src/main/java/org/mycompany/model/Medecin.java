package org.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table

public class Medecin {

	private int idMede;
	private String nom;
	private String prenom;
	private String role;
	
	@OneToMany( targetEntity=Ordonance.class, mappedBy="Medecin" )
    private List<Ordonance> ordonances = new ArrayList<>();
	
	
}

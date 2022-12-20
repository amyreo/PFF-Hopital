package org.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RDV {
	
	@Id
	private int id;
	private String heureDebut;
	

}

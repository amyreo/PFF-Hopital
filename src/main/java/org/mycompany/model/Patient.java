package org.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Patient {
	
	@Id
	private int id;
	private String nom;
	private String prenom;
	private int age;
	
	
	
	
}

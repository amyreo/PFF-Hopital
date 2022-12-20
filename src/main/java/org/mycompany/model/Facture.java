package org.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Facture {
	@Id
	private int id;
	private double montant;
	

}

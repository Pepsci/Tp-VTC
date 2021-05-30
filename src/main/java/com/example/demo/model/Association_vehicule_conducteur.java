package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Association_vehicule_conducteur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long conducteur;
	private Long vehicule;

	public Association_vehicule_conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Association_vehicule_conducteur(Long conducteur, Long vehicule) {
		super();
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConducteur() {
		return conducteur;
	}

	public void setConducteur(Long conducteur) {
		this.conducteur = conducteur;
	}

	public Long getVehicule() {
		return vehicule;
	}

	public void setVehicule(Long vehicule) {
		this.vehicule = vehicule;
	}

	
}

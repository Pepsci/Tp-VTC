package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marque;
	private String model;
	private String couleur;
	private String immatriculation;
	
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicule(String marque, String model, String couleur, String immatriculation) {
		super();
		this.marque = marque;
		this.model = model;
		this.couleur = couleur;
		this.immatriculation = immatriculation;
	}

	public Vehicule(Long id, String marque, String model, String couleur, String immatriculation) {
		super();
		this.id = id;
		this.marque = marque;
		this.model = model;
		this.couleur = couleur;
		this.immatriculation = immatriculation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_vehicule) {
		this.id = id_vehicule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	

}

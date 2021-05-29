package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conducteur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_conducteur;
	
	private String nom;
	private String prenom;
	
	public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conducteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Conducteur(Long id_conducteur, String nom, String prenom) {
		super();
		this.id_conducteur = id_conducteur;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId_conducteur() {
		return id_conducteur;
	}

	public void setId_conducteur(Long id_conducteur) {
		this.id_conducteur = id_conducteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}

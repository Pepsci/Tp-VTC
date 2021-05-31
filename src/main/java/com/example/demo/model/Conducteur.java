package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Conducteur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	
	@ManyToMany
	@JoinTable(name="association_vehicule_conducteur",
	joinColumns = {@JoinColumn(name ="conducteur")},	
	inverseJoinColumns = {@JoinColumn(name="vehicule")})
	private List<Vehicule>vehicules;
	
	public Conducteur(String nom, String prenom, List<Vehicule> vehicules) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.vehicules = vehicules;
	}

	public Conducteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@Override
	public String toString() {
		return "" + nom + " " + prenom + "";
	}

	
}

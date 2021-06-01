package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Association_vehicule_conducteur;
import com.example.demo.model.Vehicule;

public interface IndexRepositoy extends JpaRepository<Association_vehicule_conducteur, Long>{
	
	@Query(value="SELECT count(*) FROM vehicule WHERE id NOT IN (SELECT vehicule FROM Association_vehicule_conducteur)", nativeQuery = true)
	Long nbreVehi_sans_conducteur();
	
	@Query(value="SELECT count(*) FROM conducteur WHERE id NOT IN (SELECT conducteur FROM Association_vehicule_conducteur)", nativeQuery = true)
	Long nbreConducteurDispo();
	
	
}

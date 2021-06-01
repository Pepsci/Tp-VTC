package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Conducteur;
import com.example.demo.model.Vehicule;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
	
	@Query(value="SELECT * FROM conducteur WHERE id NOT IN (SELECT conducteur FROM Association_vehicule_conducteur)", nativeQuery = true)
	List<Conducteur> listeConducteurDispo();

}

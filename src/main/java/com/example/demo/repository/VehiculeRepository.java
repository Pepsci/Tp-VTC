package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{

	@Query(value="SELECT * FROM vehicule WHERE id NOT IN (SELECT vehicule FROM Association_vehicule_conducteur)", nativeQuery = true)
	List<Vehicule> listeVehiculeDispo();
	
}

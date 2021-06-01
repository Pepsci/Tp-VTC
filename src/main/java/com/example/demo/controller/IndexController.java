package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.Association_vehicule_conducteurRepository;
import com.example.demo.repository.ConducteurRepository;
import com.example.demo.repository.IndexRepositoy;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class IndexController {

	@Autowired ConducteurRepository conducteurRepository;
	@Autowired VehiculeRepository vehiculeRepository;
	@Autowired Association_vehicule_conducteurRepository assoRepository;
	@Autowired IndexRepositoy indexRepositoy;
	
	@GetMapping("/")
	public String Index(Model model) {
		
		model.addAttribute("nbrConducteur",conducteurRepository.count());
		model.addAttribute("nbrVehicule",vehiculeRepository.count());
		model.addAttribute("nbrAsso",assoRepository.count());
		model.addAttribute("nbrConducteurDispo",indexRepositoy.nbreVehi_sans_conducteur());
		model.addAttribute("nbrVehiculeDispo",indexRepositoy.nbreConducteurDispo());
		
		model.addAttribute("listeVehiculeDispos",vehiculeRepository.listeVehiculeDispo());
		model.addAttribute("listeConducteurDispos",conducteurRepository.listeConducteurDispo());
		return "index";
	}
	
	
	
}

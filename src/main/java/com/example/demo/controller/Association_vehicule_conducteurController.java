package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Association_vehicule_conducteur;
import com.example.demo.repository.Association_vehicule_conducteurRepository;
import com.example.demo.repository.ConducteurRepository;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class Association_vehicule_conducteurController {
	
	@Autowired Association_vehicule_conducteurRepository association_vehicule_conducteurRepository;
	@Autowired ConducteurRepository conducteurRepository;
	@Autowired VehiculeRepository vehiculeRepository;


	@GetMapping("/gestion")
	public String gestion(Model model){
		
		model.addAttribute("association_vehicule_conducteurs",association_vehicule_conducteurRepository.findAll());
		model.addAttribute("conducteurs",conducteurRepository.findAll());
		model.addAttribute("vehicules",vehiculeRepository.findAll());
		return "menu/gestion";
	}
	
	@PostMapping("/gestion")
	public String ajoutAsso(@Validated Association_vehicule_conducteur association_vehicule_conducteur,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "menu/gestion";
		}
		association_vehicule_conducteurRepository.save(association_vehicule_conducteur);
		return "redirect:/gestion";
	}
	
	@GetMapping("/showA/{id}")
	public String ShowAction(@PathVariable(value = "id") Long assoID, Model model) {
		model.addAttribute("association_vehicule_conducteur",association_vehicule_conducteurRepository.findById(assoID));
		
		return "menu/gestion";
	}
	
	@GetMapping("/deleteA/{id}")
	public String suppA(@PathVariable("id") Long id, Model model) {
		Association_vehicule_conducteur association_vehicule_conducteur = association_vehicule_conducteurRepository.findById(id)
	    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		association_vehicule_conducteurRepository.delete(association_vehicule_conducteur);
	    return "redirect:/gestion";
	}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Conducteur;
import com.example.demo.model.Vehicule;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class VehiculeController {

	@Autowired VehiculeRepository vehiculeRepository;
	
	@GetMapping("/vehicule")
	public String vehicule(Model model) {
		model.addAttribute("vehicules", vehiculeRepository.findAll());
		
		return "menu/vehicule";
	}
	
	@PostMapping("/vehicule")
	public String Ajoutvehicule(@Validated Vehicule vehicule, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "menu/vehicule";		
		}
		vehiculeRepository.save(vehicule);
		return "redirect:/vehicule";		
	}
	
	@GetMapping("/deleteV/{id}")
	public String suppVehicule(@PathVariable("id") long id, Model model) {
		Vehicule vehicule = vehiculeRepository.findById(id)
	    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		vehiculeRepository.delete(vehicule);
	    return "redirect:/vehicule";
	}
	
}

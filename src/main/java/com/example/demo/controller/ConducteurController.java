package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Conducteur;
import com.example.demo.repository.ConducteurRepository;

@Controller
public class ConducteurController {
	
	@Autowired ConducteurRepository conducteurRepository;
	
	@GetMapping("/conducteur")
	public String conducteur() {
		
		return"menu/conducteur";
	}
	
	@GetMapping("/lconducteur")
	public String ListConducteur(Model model) {
		
		model.addAttribute("conducteurs", conducteurRepository.findAll());
		return "menu/conducteur";
      }
	
	@PostMapping("/conducteur")
	public String ajoutConducteur(@Validated Conducteur conducteur, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			 return "menu/conducteur";
    	}
		
		conducteurRepository.save(conducteur);
		 return "menu/conducteur";
	}
	

}

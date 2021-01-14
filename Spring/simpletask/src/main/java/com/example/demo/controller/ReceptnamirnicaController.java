package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ReceptRepo;
import com.example.demo.dao.ReceptnamirnicaRepo;
import com.example.demo.model.Recept;
import com.example.demo.model.Receptnamirnica;

@RestController
public class ReceptnamirnicaController {

	@Autowired
	ReceptnamirnicaRepo rnRepo;
	
	@Autowired
	ReceptRepo receptRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/dodajReceptnamirnica")
	public Receptnamirnica dodajRecept(@RequestBody Receptnamirnica rn) {
		
		rnRepo.save(rn);
		return rn;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/dobaviListuNamirnica/{idrecept}")
	public List<Receptnamirnica> dobaviListuNamirnica(@PathVariable("idrecept") int idrecept) {
		Optional<Recept> or = receptRepo.findById(idrecept);
		if (or.isPresent()) {
			List<Receptnamirnica> lista = rnRepo.dobaviReceptnamirnica(or.get());
			return lista;
		}
		return null;
	}
	
}

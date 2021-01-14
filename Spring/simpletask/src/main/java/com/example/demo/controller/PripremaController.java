package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PripremaRepo;
import com.example.demo.model.Priprema;
import com.example.demo.model.Recept;
import com.example.demo.model.Receptnamirnica;

@RestController
public class PripremaController {
	
	@Autowired
	PripremaRepo pripremaRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/pripremiJelo")
	public Priprema pripremiJelo(@RequestBody Recept r) {
		
		Priprema p = new Priprema();
		p.setDatum(new Date());
		p.setVreme(new Date());
		p.setRecept(r);
		
		pripremaRepo.save(p);
		return p;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/listaPriprema/{idrecept}")
	public List<Priprema> listaPriprema(@PathVariable("idrecept") int idrecept) {
		List<Priprema> lista = pripremaRepo.pripremeRecepta(idrecept);
		return lista;
	}
	
}

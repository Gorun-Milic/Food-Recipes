package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.NamirnicaRepo;
import com.example.demo.model.Namirnica;

@RestController
public class NamirnicaController {
	
	@Autowired
	NamirnicaRepo namirnicaRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/dodajNamirnicu")
	public Namirnica dodajNamirnicu(@RequestBody Namirnica namirnica) {
		
		if (namirnica.getCena()!=0 && namirnica.getKalorije()!=0 && namirnica.getKolicina()!=0 && namirnica.getNaziv()!=null && namirnica.getVrsta()!=null) {
			namirnicaRepo.save(namirnica);
			return namirnica;
		}
		
		return null;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/izmeniNamirnicu")
	public Namirnica izmeniNamirnicu(@RequestBody Namirnica namirnica) {
		
		if (namirnica.getCena()!=0 && namirnica.getKalorije()!=0 && namirnica.getKolicina()!=0 && namirnica.getNaziv()!=null && namirnica.getVrsta()!=null) {
			namirnicaRepo.save(namirnica);
			return namirnica;
		}
		
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/obrisiNamirnicu/{idnamirnica}")
	public Namirnica obrisiNamirnicu(@PathVariable("idnamirnica") int idnamirnica) {
		Optional<Namirnica> optNamirnica = namirnicaRepo.findById(idnamirnica);
		if (optNamirnica.isPresent()) {
			Namirnica n = optNamirnica.get();
			namirnicaRepo.delete(n);
			return n;
		}
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/mojeNamirnice/{idkorisnik}")
	public List<Namirnica> mojeNamirnice(@PathVariable("idkorisnik") int idkorisnik) {
		System.out.println("ggggggggggg");
		return namirnicaRepo.namirniceKorisnika(idkorisnik);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/dobaviNamirnicu/{idnamirnica}")
	public Namirnica dobaviNamirnicu(@PathVariable("idnamirnica") int idnamirnica) {
		Optional<Namirnica> optNamirnica = namirnicaRepo.findById(idnamirnica);
		Namirnica product = optNamirnica.get();
		return product;
	}

}

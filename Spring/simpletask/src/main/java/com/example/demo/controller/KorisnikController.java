package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.KorisnikRepo;
import com.example.demo.dto.PrijavaDTO;
import com.example.demo.model.Korisnik;

@RestController
public class KorisnikController {
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registrujKorisnika")
	public Korisnik addUser(@RequestBody Korisnik korisnik) {
		
		System.out.println("sss");
		System.out.println(korisnik);
		
		if (!validaijaKorisnika(korisnik)) {
			return null;
		}
		
		List<Korisnik> korisnici = korisnikRepo.vecPostoji(korisnik.getKorisnickoime(), korisnik.getLozinka());
		if (!korisnici.isEmpty()) {
			return null;
		}
		korisnik.setBmi(korisnik.getMasa()/((korisnik.getVisina()/100)*(korisnik.getVisina()/100)));
		korisnikRepo.save(korisnik);
		return korisnik;
	}
	
	public boolean validaijaKorisnika(Korisnik korisnik) {
		if (korisnik.getKorisnickoime().equals("") || korisnik.getLozinka().equals("") || korisnik.getEmail().equals("") || korisnik.getGodiste()==0 || korisnik.getMasa()==0 || korisnik.getIme().equals("") || korisnik.getPrezime().equals("")) {
			return false;
		}
		return true;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/prijava")
	public Korisnik login(@RequestBody PrijavaDTO prijavaDTO) {
		if (prijavaDTO.getKorisnickoime()==null || prijavaDTO.getLozinka()==null) {
			return null;
		}
		List<Korisnik> korisnici = korisnikRepo.validacijaKorisnika(prijavaDTO.getKorisnickoime(), prijavaDTO.getLozinka());
		if (!korisnici.isEmpty()) {
			Korisnik korisnik = korisnici.get(0);
			return korisnik;
		}
		return null;
	}

}

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
import com.example.demo.dto.PretragaDTO;
import com.example.demo.model.Recept;

@RestController
public class ReceptController {

	@Autowired
	ReceptRepo receptRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/sviRecepti")
	public List<Recept> sviRecepti() {
		return receptRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/dodajRecept")
	public Recept dodajRecept(@RequestBody Recept recept) {
		
		if (recept.getNaziv()!=null && recept.getOpis()!=null) {
			receptRepo.save(recept);
			return recept;
		}
		
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/mojiRecepti/{idkorisnik}")
	public List<Recept> mojiRecepti(@PathVariable("idkorisnik") int idkorisnik) {
		System.out.println("ggggggggggg");
		return receptRepo.receptiKorisnika(idkorisnik);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/dobaviRecept/{idrecept}")
	public Recept dobaviRecept(@PathVariable("idrecept") int idrecept) {
		Optional<Recept> optr = receptRepo.findById(idrecept);
		Recept product = optr.get();
		return product;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/pretraga")
	public List<Recept> pretraga(@RequestBody PretragaDTO pretraga) {
		
		List<Recept> lista = null;
		
		if (pretraga.getCena()==0 && pretraga.getKalorije()==0) {
			return null;
		}
		else if (pretraga.getCena()!=0 && pretraga.getKalorije()==0) {
			lista = receptRepo.pretragaCena(pretraga.getCena()-20, pretraga.getCena()+20);
		}
		else if (pretraga.getCena()==0 && pretraga.getKalorije()!=0) {
			lista = receptRepo.pretragaKalorije(pretraga.getKalorije()-20, pretraga.getKalorije());
		}
		else {
			lista = receptRepo.pretragaCenaIKalorije(pretraga.getCena()-20, pretraga.getCena()+20, pretraga.getKalorije()-20, pretraga.getKalorije()+20);
		}
		
		return lista;
	}
	
}

package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Namirnica;
import com.example.demo.model.Recept;

public interface ReceptRepo extends JpaRepository<Recept, Integer> {
	
	@Query("from Recept where idkorisnik=?1")
	public List<Recept> receptiKorisnika(int idkorisnik);
	
	@Query("from Recept where cena between ?1 and ?2")
	public List<Recept> pretragaCena(int donjaGranica, int gornjaGranica);
	
	@Query("from Recept where kalorije between ?1 and ?2")
	public List<Recept> pretragaKalorije(int donjaGranica, int gornjaGranica);
	
	@Query("from Recept where cena between ?1 and ?2 or kalorije between ?3 and ?4")
	public List<Recept> pretragaCenaIKalorije(int cenaM, int cenaV, int kalorijeM, int kalorijeV);

}
